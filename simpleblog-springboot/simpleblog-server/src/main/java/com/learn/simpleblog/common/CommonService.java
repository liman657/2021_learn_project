package com.learn.simpleblog.common;

import cn.hutool.core.lang.Snowflake;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 **/
@Service
public class CommonService {

    private static final Logger log= LoggerFactory.getLogger(CommonService.class);

    private static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyyMMdd");

    private static final Snowflake SNOWFLAKE=new Snowflake(3,2);


    @Autowired
    private Environment env;


    //上传文件-nio的方式
    public Map<String,Object> uploadV2(MultipartFile multipartFile, final SysModule sysModule) throws Exception{
        Map<String,Object> resMap= Maps.newHashMap();

        //TODO:将前端上传过来的文件保存到指定的服务器目录下
        String fileName=multipartFile.getOriginalFilename();
        Long size=multipartFile.getSize();
        //1.jpg  ->  .jpg
        String suffix=StringUtils.substring(fileName,StringUtils.indexOf(fileName,"."));

        //图片命名方式一：以时间戳 - 纳秒级为奠基
        //String newFileName=System.nanoTime()+suffix;

        //图片命名方式二：雪花算法
        String newFileName=SNOWFLAKE.nextIdStr()+suffix;
        String filePath=DATE_FORMAT.format(new Date())+ "/"+sysModule.getCode()+"/"+newFileName;
        String newFile=env.getProperty("common.file.upload.root.url")+filePath;

        File file=new File(newFile);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        Path path=Paths.get(newFile);

        //TODO:如果文件名相同，则覆盖
        Files.copy(multipartFile.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);


        //TODO:保存成功后将可以被访问的Url拿出来，然后添加到数据库中-用于记录:上传历史
        resMap.put("fileUrl",filePath);
        resMap.put("fileName",fileName);
        resMap.put("size",size.toString());
        resMap.put("suffix",suffix);

        return resMap;
    }
}































