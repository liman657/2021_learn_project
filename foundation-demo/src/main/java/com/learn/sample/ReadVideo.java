package com.learn.sample;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment: 计算视频文件的播放时长总和
 */
@Slf4j
public class ReadVideo {

    private static Set<String> videoFileSuffix = new HashSet<>();

    static{
        videoFileSuffix.add("mp4");
        //videoFileSuffix.add("avi");
    }


    public static void main(String[] args){

        String path = "F:\\BaiduNetdiskDownload\\mksz162 - Java企业级电商项目架构演进之路 Tomcat集群与Redis分布式";
        //1.读取文件夹下的所有视频文件
        List<File> fileList = new ArrayList<>();
        readFileInDir(path,fileList);
        List<String> fileNameList = fileList.stream().map(File::getName).collect(Collectors.toList());
        log.info("得到的文件列表为:");
        fileNameList.stream().forEach(t-> System.out.println(t));

        //计算时长
        double result = calVideoFilePlayTime(fileList);
        System.out.println("总共耗时:"+result+"小时");
    }

    /**
     * 递归读取文件夹下的所有文件
     * @param path
     */
    public static void readFileInDir(String path,List<File> fileList){
        File f = new File(path);
        //得到文件下的所有文件
        File[] files = f.listFiles();

        for(File file:files){
            if(file.isDirectory()){
                readFileInDir(file.getAbsolutePath(),fileList);
            }else{
                if(isVideoFile(file.getName())) {
                    fileList.add(file);
                }
            }
        }
    }

    public static boolean isVideoFile(String fileName){
        boolean result = false;
        String suffix = fileName.substring(fileName.lastIndexOf('.')+1);
        if(videoFileSuffix.contains(suffix)){
            result = true;
        }
        return result;
    }

    public static double calVideoFilePlayTime(List<File> fileList){
        Encoder encoder = new Encoder();
        Double totalMillsecond = 0.0d;
        BigDecimal totalMinute = new BigDecimal(0.0d);
        BigDecimal oneHourMinute = new BigDecimal(60d);
        BigDecimal finalResult = new BigDecimal(0.0d);
        for (File file : fileList) {
            try {
                MultimediaInfo mediaFileInfo = encoder.getInfo(file);
                Double millsecond = Double.valueOf(mediaFileInfo.getDuration()); //ls是获取到的毫秒数
                BigDecimal millSecondBigDecimal = new BigDecimal(millsecond);

                Double beDevided = 60000.0d;//得到分钟数
                BigDecimal toDevided = new BigDecimal(beDevided);
                BigDecimal minute = millSecondBigDecimal.divide(toDevided, 3, RoundingMode.HALF_UP);
                log.info("文件{},总时长为:{}毫秒,{}分钟",file.getName(),millsecond,minute);
                totalMillsecond+=millsecond;
                totalMinute=totalMinute.add(new BigDecimal(minute.toString()));
            } catch (Exception e) {
                log.warn("该文件:{}可能不是视频文件",file.getAbsolutePath());
                continue;
            }
        }
        finalResult = totalMinute.divide(oneHourMinute,3,RoundingMode.HALF_UP);
        log.info("总共文件耗时:{}毫秒，{}分钟，{}小时",totalMillsecond,totalMinute,finalResult);
        return finalResult.doubleValue();
    }
}
