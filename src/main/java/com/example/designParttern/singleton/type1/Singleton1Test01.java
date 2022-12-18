package com.example.designParttern.singleton.type1;

/**
 * @Author LiuJixue
 * @Date 2022/12/15 16:25
 * @PackageName:com.example.designParttern.singleton.type1
 * @ClassName: Singleton1Test01
 * @Description: TODO
 * @Version 1.0
 */
public class Singleton1Test01 {
    public static void main(String[] args) {
        // 测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
// 恶汉式
class Singleton{
    //1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();
    // 3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
