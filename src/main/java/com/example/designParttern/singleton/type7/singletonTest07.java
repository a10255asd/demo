package com.example.designParttern.singleton.type7;

/**
 * @Author LiuJixue
 * @Date 2022/12/16 10:00
 * @PackageName:com.example.designParttern.singleton.type3
 * @ClassName: singletonTest03
 * @Description: TODO
 * @Version 1.0
 */
public class singletonTest07{
    public static void main(String[] args) {
        // 测试
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
class Singleton{
    // 可见性
    private static volatile Singleton instance;
    //构造器私有化
    private Singleton(){}
    // 写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    // 提供一个静态共有方法，直接返回
    public static synchronized Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }

}
