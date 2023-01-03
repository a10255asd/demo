package com.example.designParttern.dapater.interfaceAdapter;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 15:17
 * @PackageName:com.example.designParttern.dapater.interfaceAdapter
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            //只需要去覆盖我们需要使用的接口方法
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };
        absAdapter.m1();
    }
}
