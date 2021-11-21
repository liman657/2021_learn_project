package com.learn.sample.urlpageread;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:通过httpclient读取HTML页面的内容
 */
@Slf4j
public class ReadHtmlPage {
    public static void main(String[] args) {
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet("https://coding.imooc.com/class/chapter/409.html#Anchor");
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                writeHtml2File(html,"");
//                System.out.println(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    /**
     * 处理返回的HTML数据
     */
    public static void readLength(){

    }

    /**
     * 写入文件
     * @param htmlStr
     */
    public static void writeHtml2File(String htmlStr,String filePath){
        FileWriter writer;
        String fileName = "F:/htmlPage.txt";
        try {
            File file = new File("F:/htmlPage.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            writer = new FileWriter(file);
            writer.write(htmlStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readDataFromFile(fileName);
    }

    public static void readDataFromFile(String fileName){
        File sourceFile = new File(fileName);
        if(!sourceFile.exists()){
            log.warn("文件:{}不存在",fileName);
            return;
        }
        BufferedReader reader = null;
        try {
            //构造源文件读取器
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            String tempStr = "";
            String regex = "\\<span\\sclass=\\\"chapter-num\\\">[0-9]+\\s节\\s\\|\\s[0-9]分钟<\\/span>";
            Pattern pattern = Pattern.compile(regex);
            while ((tempStr = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(tempStr);
                if (matcher.find()) {//如果匹配上，进行截取
                    //按照指定正则替换
                    System.out.println(tempStr.trim());
                    log.info("文件:{},替换后的字符串为:{}",sourceFile.getAbsoluteFile(), tempStr.trim());
                }
            }
        } catch (Exception e) {
            //记录异常
            log.error("文件:{},字符替换异常，异常信息为:{}，请手动操作", fileName,e);
            return;
        } finally {
            //关闭流
            try {
                reader.close();
            } catch (IOException e) {
                log.error("文件:{},流关闭异常", fileName);
            }
        }
    }
}
