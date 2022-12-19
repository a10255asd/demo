package com.example.designParttern.singleton.type6;

/**
 * @Author LiuJixue
 * @Date 2022/12/16 10:00
 * @PackageName:com.example.designParttern.singleton.type3
 * @ClassName: singletonTest03
 * @Description: TODO
 * @Version 1.0
 */
public class singletonTest06{
    public static void main(String[] args) {
        // 测试
        System.out.println("双重检查，加入Synchronized，线程安全");
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
    private Singleton(){}

    // 提供一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
    // 双重检查，同时保证了效率，推荐使用
    public static synchronized Singleton getInstance(){
        if (instance == null){
            synchronized (singletonTest06.class){
                if (instance == null){
                    instance =  new Singleton();
                }
            }
        }
        return instance;
    }

}
