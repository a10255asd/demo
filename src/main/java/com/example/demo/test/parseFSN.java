package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author LiuJixue
 * @Date 2022/12/5 18:48
 * @PackageName:com.example.demo.test
 * @ClassName: parseFSN
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class parseFSN {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static String oldImgPath1;
    private static String imgPath;

    public static void main(String[] args) {
//        Map<String, Map<String, String>> currFileMap =
//                parseLogFile("/Users/LIU/Documents/20221213R2000266.LOG");
        Map<String, Map<String, String>> currFileMap = null;
        parseFSNFile("R9000005", "20221130",
                "H:/BQD19_ZJOL_0218A80259014000000000120221221084944.FSN",
                currFileMap);
    }


    public static int parseFSNFile(String untid, String generateDate, String fileName, Map<String, Map<String, String>> currFileMap)
    throws NumberFormatException {
        List<String> imgList = new ArrayList<String>();
        log.info("开始解析RDP " + fileName);
        FileInputStream read = null;
        try {
            read = new FileInputStream(fileName);
            int fileLength = read.available();
            if (fileLength <= 0) {
                read.close();
                return -1;
            }
            int index = 0;
            byte[] title = new byte[32];
            read.read(title, index, 32);
            index += 32;
            boolean isHavePic = false;
            if (title[12] == 0x2e) {
                isHavePic = true;
            }
            byte[] content = new byte[100];
            byte[] picTitle = new byte[8];
            byte[] picContent = new byte[1536];
            String orgncode = "";
            ArrayList<ListOrderedMap> setterList = new ArrayList<ListOrderedMap>();

            // test失败的FSN
            List<String> errFSN = new ArrayList<>();

            while (fileLength > index) {
                ListOrderedMap setterMap = new ListOrderedMap();
                String oldImgPath = oldImgPath1;
                read.read(content, 0, content.length);

                int CharNM = Integer.parseInt(content[25] + "" + content[24]);// 冠字号码字符数
                StringBuffer sb = new StringBuffer("");
                for (int k = 26; k <= 48; k = k + 2) {
                    sb.append(content[k] == 0 ? "?" : (char) content[k]);
                }
                String SNo = sb.toString();
                SNo = SNo.substring(0, CharNM).replaceAll("\\?", "_");
                // 输出冠字号？
                log.info("--------冠字号是：--------：" + SNo);

                // 输出数组到控制台
                if (content[6] < 0 || content[8] < 0 || content[10] < 0) {
                    log.info("--------content的内容是--------：" + Arrays.toString(content));
                    log.info("--------content[7]是：" + content[7] + "--------content[6]是：" + Math.abs(content[6]));
                    log.info("--------content[9]是：" + content[9] + "--------content[8]是：" + content[8]);
                    log.info("--------content[11]是：" + content[11] + "--------content[10]是：" + content[10]);
                    errFSN.add(SNo);
                }

                int tranDate = Integer.parseInt(byte2Hex(content[1])
                        + byte2Hex(content[0]), 16);// 验钞启动日期
                int tranTime = Integer.parseInt(byte2Hex(content[3])
                        + byte2Hex(content[2]), 16);// 验钞启动时间
                int noteType = Integer.parseInt(content[5] + "" + content[4]);// 真、假、残和旧币标志
//                try {
//                    int errorCode[] = {
//                            Integer.parseInt(content[7] + "" + content[6]),
//                            Integer.parseInt(content[9] + "" + content[8]),
//                            Integer.parseInt(content[11] + "" + content[10])};// 错误码（3个）
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                int errorCode[] = {
                        //Integer.parseInt(content[7] + "" + content[6]),
                        Integer.parseInt(content[7] + "" + Math.abs(content[6])),
                        Integer.parseInt(content[9] + "" + content[8]),
                        Integer.parseInt(content[11] + "" + content[10])};// 错误码（3个）

                String moneyFlag = ""
                        + (content[12] == 0 ? "0" : (char) content[12])
                        + (content[12] == 0 ? "0" : (char) content[14])
                        + (content[12] == 0 ? "0" : (char) content[16]);
                String Ver = Integer.parseInt(byte2Hex(content[21])
                        + byte2Hex(content[20]), 16)
                        + "";// 版本号content[20]+""+content[19]
                int Value = Integer.parseInt(content[23] + "" + content[22]);// 币值

                String deviceType = "" + (Integer.parseInt("" + content[99]) >> 4);
                String formatDate = descDate(tranDate);
                String formatTime = descTime(tranTime);
                String bmpfileName = "";
                if (isHavePic) {// 读取图片头
                    read.read(picTitle, 0, picTitle.length);
                    int num = Integer.parseInt(picTitle[1] + "" + picTitle[0]);
                    read.read(picContent, 0, 1536);
                    bmpfileName = formatDate + formatTime + SNo;
                    String test=imgPath;
//                    test=test.replace("$targetdate", generateDate);
//                    test=test.replace("$branch_no", untid);
//
//                    String imgStorePath = test + File.separator
//                            + bmpfileName + ".bmp";
//                    if (!(sdf.format(new Date())).equals(generateDate)) {
//                        File datePath = new File(oldImgPath + File.separator
//                                + generateDate);
//                        if (!datePath.exists()) {
//                            datePath.mkdir();
//                        }
//                        oldImgPath = datePath.getAbsolutePath();
//                        File untidPath = new File(oldImgPath + File.separator
//                                + untid);
//                        if (!untidPath.exists()) {
//                            untidPath.mkdir();
//                        }
//                        oldImgPath = untidPath.getAbsolutePath();
//                        imgStorePath = oldImgPath + File.separator
//                                + bmpfileName + ".bmp";
//                    }
//                    writeBMP384X32_2(imgStorePath, picContent, num);
//                    imgList.add(imgStorePath);
                    index += 1644;
                }
                setterMap.put("UNTID", untid);
                setterMap.put("TRANDATE", formatDate);
                setterMap.put("TRANTIME", formatTime);
                setterMap.put("NOTESERIALNO", SNo);
                setterMap.put("NOTETYPE", noteType);
                setterMap.put("NOTECURR", moneyFlag);
                setterMap.put("NOTEID", Ver);
                setterMap.put("NOTEVALUE", Value);
                setterMap.put("IMAGEFILENAME", "/cash/qfj/img/" + generateDate + "/" + untid + "/" + bmpfileName + ".jpeg");
                setterMap.put("DEVTYPE", "4");
                setterMap.put("BRANCH", orgncode);
//                setterMap.put("error_CODE1", errorCode[0]);
//                setterMap.put("error_CODE2", errorCode[1]);
//                setterMap.put("error_CODE3", errorCode[2]);
                /*Map<String, String> temp = currFileMap.get(formatDate
                        + formatTime + SNo);
                if (temp != null) {
                    setterMap.put("TRANTYPE", temp.get("TRANTYPE"));
                    setterMap.put("ACCOUNTNO", temp.get("ACCOUNTNO"));
                    setterMap.put("SYSJNLNO", temp.get("SYSJNLNO"));
                    setterMap.put("TRANSAMOUNT", temp.get("TRANSAMOUNT"));
                } else {
                    setterMap.put("TRANTYPE", "");
                    setterMap.put("ACCOUNTNO", "");
                    setterMap.put("SYSJNLNO", "");
                    setterMap.put("TRANSAMOUNT", "");
                }
                setterList.add(setterMap);*/

            }
            System.out.println("失败的冠字号是：" + errFSN.toString());
            // bmp2Jpeg(imgList);
            if (imgList != null) {
                imgList.clear();
            }
            if (setterList != null) {
                setterList.clear();
            }

            read.close();
            log.info("解析 " + fileName + " 结束");
            return 0;
        } catch (UnsupportedEncodingException e) {
            log.error("解析" + fileName + "异常：" + e.getMessage(), e);
            return -1;
        } catch (FileNotFoundException e) {
            log.error("解析" + fileName + "异常：" + e.getMessage(), e);
            return -1;
        } catch (IOException e) {
            log.error("解析" + fileName + "异常：" + e.getMessage(), e);
            return -1;
        } catch (Exception e) {
            log.error("解析" + fileName + "异常：" + e.getMessage(), e);
            return -1;
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException e) {
                read = null;
                log.error("解析" + fileName + "异常：" + e.getMessage(), e);
            }
        }

    }

    private static String byte2Hex(byte b) {
        String s = Integer.toHexString(b);
        if (s.length() == 1)
            return "0" + s;
        else if (s.length() > 2)
            return s.substring(s.length() - 2);
        else
            return s;
    }

    public static String descDate(int date) {
        String year = "" + ((date >> 9) + 1980);
        String month = "" + ((date % 512) >> 5);
        String day = "" + (date % 32);
        if (month.length() != 2) {
            month = "0" + month;
        }
        if (day.length() != 2) {
            day = "0" + day;
        }
        return year + month + day;
    }

    public static String descTime(int time) {
        String hour = "" + (time >> 11);
        String minute = "" + ((time % 2048) >> 5);
        String second = "" + ((time % 32) << 1);
        if (hour.length() != 2) {
            hour = "0" + hour;
        }
        if (minute.length() != 2) {
            minute = "0" + minute;
        }
        if (second.length() != 2) {
            second = "0" + second;
        }
        return hour + minute + second;
    }

    static boolean writeBMP384X32_2(String picname, byte picbuffer[],
                                    int codenum) {

        byte lotatebuff[] = new byte[1536 + 3];
        int i;
        byte width1, width2;

        width1 = (byte) (codenum * 32 % 256);
        width2 = (byte) (codenum * 32 / 256);

        // byte bmp_Title[]={
        // //0 1 2 3 4 5 6 7 8 9 a b c d e f
        // 0x42,0x4D,0x40,0x06,0x00,0x00,0x00,0x00,0x00,0x00,0x3E,0x00,0x00,0x00,0x28,0x00,
        // 0x00,0x00,0x20,0x00,0x00,0x00,width1,width2,0x00,0x00,0x01,0x00,0x01,0x00,0x00,0x00,
        // 0x00,0x00,0x02,0x06,0x00,0x00,0x12,0x0B,0x00,0x00,0x12,0x0B,0x00,0x00,0x00,0x00,
        // 0x00,0x00,0x00,0x00,0x00,0x00,-1,-1,-1,0x00,0x00,0x00,0x00,0x00
        // };

        byte[] bmp_Title = {// bmp文件 384*32
                // 0 1 2 3 4 5 6 7 8 9 a b c d e f
                0x42, 0x4D, 0x40, 0x06, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x3E, 0x00, 0x00, 0x00, 0x28, 0x00, 0x00, 0x00, -128, 0x01,
                0x00, 0x00, 0x20, 0x00, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x02, 0x06, 0x00, 0x00, 0x12, 0x0B,
                0x00, 0x00, 0x12, 0x0B, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, -1, -1, -1, 0x00, 0x00, 0x00, 0x00,
                0x00};

        /*
         * char bmp_Title[]={ //0 1 2 3 4 5 6 7 8 9 a b c d e f
         * 0x42,0x4D,0x40,0x06
         * ,0x00,0x00,0x00,0x00,0x00,0x00,0x3E,0x00,0x00,0x00,0x28,0x00,
         * 0x00,0x00
         * ,0x20,0x00,0x00,0x00,0x80,0x01,0x00,0x00,0x01,0x00,0x01,0x00,
         * 0x00,0x00,
         * 0x00,0x00,0x02,0x06,0x00,0x00,0x12,0x0B,0x00,0x00,0x12,0x0B
         * ,0x00,0x00,0x00,0x00,
         * 0x00,0x00,0x00,0x00,0x00,0x00,0xFF,0xFF,0xFF,0x00,0x00,0x00,0x00,0x00
         * };
         */
        for (i = 0; i < 384; i++) {
            lotatebuff[3 + i * 4] = picbuffer[0 + i * 4];
            lotatebuff[2 + i * 4] = picbuffer[1 + i * 4];
            lotatebuff[1 + i * 4] = picbuffer[2 + i * 4];
            lotatebuff[0 + i * 4] = picbuffer[3 + i * 4];
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(picname);
            out.write(bmp_Title);// 文件头
            out.write(leftRotateByteArray(lotatebuff));// 像素数据
            out.write(lotatebuff);
            out.write(0);// 文件结尾
            out.write(0);
            out.close();
            return true;
        } catch (FileNotFoundException e) {
            log.error("writeBMP384X32_2 [" + picname + "] error:" + e.getMessage(), e);
            return false;
        } catch (IOException e) {
            log.error("writeBMP384X32_2 [" + picname + "] error:" + e.getMessage(), e);
            return false;
        } catch (Exception e) {
            log.error("writeBMP384X32_2 [" + picname + "] error:" + e.getMessage(), e);
            return false;
        } finally {
            lotatebuff = null;
            bmp_Title = null;
            out = null;
        }
    }

    public static byte[] leftRotateByteArray(byte[] a) {
        byte b[] = new byte[32 * 48];
        int i, j, k;

        byte tmp = 0;
        byte andByte = 0;
        byte tmp2 = 0;
        for (i = 0; i < 32; i++) {
            switch (i % 8) {
                case 0:
                    andByte = -128;
                    break;
                case 1:
                    andByte = 0x40;
                    break;
                case 2:
                    andByte = 0x20;
                    break;
                case 3:
                    andByte = 0x10;
                    break;
                case 4:
                    andByte = 0x08;
                    break;
                case 5:
                    andByte = 0x04;
                    break;
                case 6:
                    andByte = 0x02;
                    break;
                case 7:
                    andByte = 0x01;
                    break;
            }
            for (j = 0; j < 384; j++) {
                tmp = (byte) (a[j * 4 + i / 8] & andByte);
                if (tmp > 0) {// 正数移动
                    int ii = i % 8 - j % 8;

                    if (ii > 0)
                        tmp2 = (byte) (tmp << ii);
                    else if (ii < 0) {
                        tmp2 = (byte) (tmp >> (0 - ii));
                        if (i == 16 && j <= 23)
                            log.info(byte2bits(tmp) + ">>" + (0 - ii) + ")="
                                    + byte2bits(tmp2));
                    } else
                        tmp2 = tmp;
                } else if (tmp < 0) {
                    int ii = i % 8 - j % 8;
                    if (ii > 0)
                        tmp2 = (byte) (tmp << ii);
                    else if (ii < 0) {// 负数右移时，会左补1
                        byte addByte = 0;
                        switch (0 - ii % 8) {
                            case 0:
                                addByte = -128;
                                break;
                            case 1:
                                addByte = 0x40;
                                break;
                            case 2:
                                addByte = 0x20;
                                break;
                            case 3:
                                addByte = 0x10;
                                break;
                            case 4:
                                addByte = 0x08;
                                break;
                            case 5:
                                addByte = 0x04;
                                break;
                            case 6:
                                addByte = 0x02;
                                break;
                            case 7:
                                addByte = 0x01;
                                break;
                        }
                        tmp2 = (byte) (tmp >> (0 - ii));
                        // if(i==16&&j<=23)log.info(byte2bits(tmp)+">>"+(0-ii)+")="+byte2bits(tmp2));
                        tmp2 &= addByte;
                        // if(i==16&&j<=23)log.info("ii="+ii+",addByte="+addByte+","+byte2bits(tmp2)+"&"+byte2bits(addByte)+")="+byte2bits(tmp2));
                    } else
                        tmp2 = tmp;
                } else
                    tmp2 = tmp;

                b[(31 - i) * 48 + j / 8] += tmp2;
                // if(i==16&&j<=23){
                // log.info(byte2bits(b[(31-i)*48+j/8])+" | "+byte2bits(tmp2)+" = "+byte2bits(b[(31-i)*48+j/8]));
                // log.info("i="+i+",j="+j+"  "+byte2bits(a[j*4+i/8])+"&"+byte2bits(andByte)+"="+byte2bits(tmp)+",tmp2="+byte2bits(tmp2)+",b["+((31-i)*48+j/8)+"]="+byte2bits(b[(31-i)*48+j/8]));
                // }
                // if(i==10)log.info("i="+i+",j="+j+",a["+(j*4+i/8)+"]="+byte2bits(a[j*4+i/8])+",tmp="+byte2bits(tmp)+",b["+(i*48+(47-j/8))+"]="+byte2bits(b[i*48+(47-j/8)]));
            }
        }
        /*
         * for(i=0;i<32*48;i++) { if(i%48==0){ log.info();
         * System.out.print(byte2bits(b[i])+" "); }else
         * System.out.print(byte2bits(b[i])+" "); }
         */
        return b;
    }

    public static String byte2bits(byte b) {
        int z = b;
        z |= 256;
        String str = Integer.toBinaryString(z);
        int len = str.length();
        return str.substring(len - 8, len);
    }

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
                String logtrantype = currRecord[4];
                if (logtrantype.length() > 8) {
                    logtrantype = currRecord[4].substring(0, 6);
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
        } catch (FileNotFoundException e) {
            log.error("解析[" + fileName + "]文件不存在", e);
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
