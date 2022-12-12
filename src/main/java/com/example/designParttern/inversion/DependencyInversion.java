package com.example.designParttern.inversion;

/**
 * @Author LiuJixue
 * @Date 2022/12/12 16:44
 * @PackageName:com.example.designParttern.inversion
 * @ClassName: DependencyInversion
 * @Description: TODO
 * @Version 1.0
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}
class Email{
    public String getInfo(){
        return "电子邮件信息：Hello World";
    }
}
/**
 * 完成Person接收消息的功能
 * 方式1 分析
 * 1、简单，比较容易想到
 * 2、如果我们获取的对象是 微信，短信等等，则新增类，同事Person也要增加相应的接收方法
 * 3、解决思路：
 *      引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖
 *      因为Email、微信 等等属于接收的范围，他们各自实现IReceiver接口就OK，这样我们就实现依赖倒转
 */
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}
