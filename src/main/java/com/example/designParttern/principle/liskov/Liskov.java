package com.example.designParttern.principle.liskov;

/**
 * @Author LiuJixue
 * @Date 2022/12/13 10:33
 * @PackageName:com.example.designParttern.liskov
 * @ClassName: Liskov
 * @Description: TODO
 * @Version 1.0
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.fun1(11,3));
        System.out.println("1 - 8 = " + a.fun1(1,8));
        System.out.println("-----------------------");
        B b = new B();
        // 本意是求出 11- 3 和 1-8
        System.out.println("11 - 3 = " + b.fun1(11,3));
        System.out.println("11 - 3 = " + b.fun1(1,8));
        System.out.println("11 - 3 = " + b.fun2(11,3));
    }
}
//A类
class A{
    public int fun1(int num1,int num2){
        return num1 - num2;
    }
}
// B类 继承了A类
// 增加一个新功能，完成两个数相加，然后和9求和
class B extends A{
    public int fun1(int a,int b){
        return a + b;
    }
    public int fun2(int a,int b){
        return fun1(a,b) + 9;
    }
}