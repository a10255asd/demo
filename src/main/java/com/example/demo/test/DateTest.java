package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author LiuJixue
 * @Date 2022/12/23 11:55
 * @PackageName:com.example.demo.test
 * @ClassName: DateTest
 * @Description: TODO
 * @Version 1.0
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        //过去三个月
        //Date date = new Date(122,4,31);
        //System.out.println(date);
        //c.setTime(date);
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("三个月前的今天："+mon);
    }
}
