package com.example.designParttern.singleton.type4;

/**
 * @Author LiuJixue
 * @Date 2022/12/16 10:00
 * @PackageName:com.example.designParttern.singleton.type3
 * @ClassName: singletonTest03
 * @Description: TODO
 * @Version 1.0
 */
public class singletonTest04 {
    public static void main(String[] args) {
        // 测试
        System.out.println("懒汉式2，加入Synchronized，线程安全");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
class Singleton{
    private static Singleton instance;
    private Singleton(){}

    // 提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    // 懒汉式
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance =  new Singleton();
        }
        return instance;
    }

}
