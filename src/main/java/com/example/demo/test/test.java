package com.example.demo.test;

import java.io.*;

/**
 * @Author LiuJixue
 * @Date 2022/12/1 18:36
 * @PackageName:com.example.demo.test
 * @ClassName: test
 * @Description: TODO
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        String url = "/Users/LIU/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/9b622d71f8b0c111811375fa23463cf2/Message/MessageTemp/8efda25b0e0af27f8b6b8b7d6e8e089d/OpenData/20221130R9000005.FSN";
        readFile(url);
    }

    public static void readFile(String url) {
        String Content = "";//文件很长的话建议使用StringBuffer
        try {
            FileInputStream fis = new FileInputStream(url);
            InputStreamReader isr = new InputStreamReader(fis);

            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                Content += line;
                Content += "\r\n"; // 补上换行符
            }
            System.out.println(Content);
         } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
