package com.example.demo.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author LiuJixue
 * @Date 2022/10/24 15:33
 * @PackageName:com.example.demo.question
 * @ClassName: AtomicReferenceDemo
 * @Description: TODO
 * @Version 1.0
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3",22);
        User l4 = new User("l4",25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get().toString());
    }
}
@Data
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}