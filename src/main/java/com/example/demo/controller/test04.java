package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class test04 implements ApplicationRunner{

    @Autowired
    private test test ;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("恭喜你! 你成功启动了项目");
        //test.tryAgain();
    }


}
