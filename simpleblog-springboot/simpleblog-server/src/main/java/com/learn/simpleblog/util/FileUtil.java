package com.learn.simpleblog.util;

import com.learn.simpleblog.api.response.FileResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件操作util
 */
public class FileUtil {

    private static final SnowFlake snowFlake = new SnowFlake(2, 3);

    /**
     * 文件上传
     * @param file 附件
     * @param prefix  目录前缀
     * @return 返回文件名
     */
    public static FileResponse upload(MultipartFile file, String prefix, String module) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
        String path = prefix + File.separator+ module + File.separator + date + File.separator;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filename = file.getOriginalFilename();
        String ext = filename.substring(filename.lastIndexOf('.'));
        long millis = System.nanoTime();
        String dirTempName=snowFlake.nextId()+millis + ext;

        System.out.println("存储图片的目录："+path+"  目标图片名字： "+dirTempName);
        String resultFilePath=path + dirTempName;
        File temp = new File(resultFilePath);
        file.transferTo(temp);

        String accessPath=module + File.separator + date + File.separator + dirTempName;

        return new FileResponse(dirTempName,accessPath,resultFilePath);
    }

    /**
     * 删除实际的附件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static void remove(String filePath) throws Exception{
        if (StringUtils.isNotBlank(filePath)) {
            File file=new File(filePath);
            if(file.exists()){
                file.delete();
            }
        }
    }

    /*public static void main(String[] args) {
        String sentence="我和小姨子";
        System.out.println(SensitiveWordUtil.hasSenWord(sentence));
        System.out.println(SensitiveWordUtil.manageSenWord(sentence,'*'));
    }*/
}



























