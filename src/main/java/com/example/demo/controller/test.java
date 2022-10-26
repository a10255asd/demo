package com.example.demo.controller;

import com.example.demo.Log.Log;
import com.example.demo.entity.TestInfo;
import com.example.demo.mapper.LogMapper;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/trya")
    @Log(name = "嘿",Type = 1)
    public void trya(){
        if(redisUtil.hasKey("1")){
            System.out.println(redisUtil.get("1"));
        }else{
            TestInfo testInfo = logMapper.selectByKey(new TestInfo(1,"aa"));
            redisUtil.set(String.valueOf(testInfo.getId()),testInfo.getName());
            redisUtil.expire(String.valueOf(testInfo.getId()),60);
            System.out.println(redisUtil.get("1"));
        }
    }

    @RequestMapping("/tryAgain")
    @Log(name = "嘿嘿",Type = 2)
    @Transactional
    public void tryAgain(){
        TestInfo testInfo = new TestInfo();
        testInfo.setId(2);
        testInfo.setName("第二");
        String s = "中考满分作文的范例:晒出我的梦想\n" +
                "\n" +
                "时常有人问我，你的梦想是什么？今天我就晒出来与大家共享。\n" +
                "我的第一个梦想：考上理想的学校。\n" +
                "不要说我自私，从某种意义上讲，人都有点儿“自私”。我的短期目标就是考上我心仪已久的一中。平时，就是课间那比金子还难得的一点儿闲暇，我也常常闭上眼睛，想象自己在一中如画的校园里，度过我快乐而温馨的学生时代，这将为我考上理想的大学搭设一个很好的台阶。\n" +
                "我的第二个梦想：找一份儿好的工作。\n" +
                "大学毕业后的我步入社会，肩上的责任感倏地加重了。首先要照顾好我的家人，所以我需要一份儿好工作，让我有能力去做一个负责的好女儿、好姐姐。当然，这些工作必须是我喜爱的，能让我的人生过得更充实、更潇洒。\n" +
                "我的第三个梦想：买车买房给爸妈，让他们幸福。\n" +
                "每次逛街，妈妈常眯着眼睛，出神地看着路边那一幢幢漂亮的楼房，我知道，她真的很想尝尝住楼房的滋味儿；每次挤公共汽车，爸爸气喘吁吁，玩笑似地说：“要是自己有车就好喽！”但我很清楚，爸妈为了我们姐弟三人一直忙忙碌碌，我们姐弟三人使他们的梦想也只能是梦想。尽管他们从无怨言，但我要凭自己的努力给他们一个幸福愉快的晚年。\n" +
                "我的第四：我的村庄变成小康村。\n" +
                "村里人一年到头鼓捣那几亩地，很少有人出去闯一闯。所以，邻村都富起来了，我们村却依旧“光荣”。我要在不远的将来让自己有这样的实力，在村边建起自己的工厂，让我的村庄摇身变成金凤凰；我要让村里所有的人都飞到山外的大海上去搏击风浪。\n" +
                "我的最后一个梦想：我们的祖国成为世界第一强国。……\n" +
                "我知道我的梦想还仅仅是“梦想”，但我会用自己的双手和大脑，去填充我梦想圆内的每一平方毫米的空间。";

        logMapper.insertOne(testInfo);
        logMapper.insertOne(new TestInfo(2,s));
        //        try {
//            testMapper.insertOne(testInfo);
//            testMapper.insertOne(new TestInfo(2,s));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("再试一试");
    }

}
