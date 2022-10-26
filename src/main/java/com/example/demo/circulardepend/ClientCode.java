package com.example.demo.circulardepend;

import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 23:23
 * @PackageName:com.example.demo.circulardepend
 * @ClassName: ClientCode
 * @Description: TODO
 * @Version 1.0
 */
public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        b.setA(a);
        a.setB(b);

    }

}
