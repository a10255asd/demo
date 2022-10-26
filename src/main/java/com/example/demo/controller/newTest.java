package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author LiuJixue
 * @Date 2022/8/18 10:56
 * @PackageName:com.example.demo.controller
 * @ClassName: newTest
 * @Description: TODO
 * @Version 1.0
 */
public class newTest {
    public static void main(String[] args) {
        test();
    }

    static class A {
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    static class B{
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void test(){
        String a = "1,2,3,4";
        A aObjcet = new A();
        aObjcet.setId(a);
        aObjcet.setName("我是整体数组");

        String[] split = aObjcet.getId().split(",");
        List<B> collect = Arrays.asList(split).stream().map((item) -> {
            System.out.println(item);
            B b = new B();
            b.setId(item);
            return b;
        }).collect(Collectors.toList());

        collect.forEach(item->{
            System.out.println("我是："+ item.getId());
        });
    }
}
