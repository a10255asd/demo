package com.example.demo.controller;


import com.example.demo.Log.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testAgain")
public class test02 {
    @RequestMapping("/haha")
    @Log(name = "笑个屁",Type = 1)
    public void tryAgain(){
        System.out.println("笑个屁");
    }
}
