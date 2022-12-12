package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/12/5 18:32
 * @PackageName:com.example.demo.test
 * @ClassName: parseLogFile
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class parseLogFile {
//    public static void main(String[] args) {
//        parseLogFile("/Users/LIU/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/9b622d71f8b0c111811375fa23463cf2/Message/MessageTemp/8efda25b0e0af27f8b6b8b7d6e8e089d/OpenData/20221130R9000005.LOG");
//    }
    public static Map<String, Map<String, String>> parseLogFile(String fileName) {
        log.info("开始解析RDP " + fileName);
        Map<String, Map<String, String>> currFileMap = new HashMap<String, Map<String, String>>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(
                    fileName)));
            String currLine = br.readLine();
            while (currLine != null) {
                String[] currRecord = currLine.split("\\,");
                Map<String, String> currMap = new HashMap<String, String>();
                String logtrantype=currRecord[4];
                if(logtrantype.length()>8){
                    logtrantype=currRecord[4].substring(0, 6);
                }
                currMap.put("TRANTYPE", logtrantype);
                currMap.put("ACCOUNTNO", currRecord[5]);
                currMap.put("SYSJNLNO", currRecord[6]);
                currMap.put("TRANSAMOUNT", currRecord[7]);
                currFileMap.put(currRecord[0] + currRecord[1] + currRecord[3],
                        currMap);
                currLine = br.readLine();
            }
            log.info("解析RDP " + fileName + " 结束");
            log.info(currFileMap.toString());
        } catch (FileNotFoundException e) {
            log.error("解析[" + fileName + "]文件不存在" , e);
        } catch (IOException e) {
            log.error("解析[" + fileName + "]异常:" + e.getMessage(), e);
        } catch (Exception e) {
            log.error("解析[" + fileName + "]异常:" + e.getMessage(), e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    br = null;
                    log.error("解析[" + fileName + "]异常", e);
                }
            }
        }
        return currFileMap;
    }
}
