package com.example.designParttern.inversion.improve;

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
        // 客户端无需改变
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}
// 定义一个接口
interface IReceiver{
    public String getInfo();
}
class Email implements IReceiver{
    public String getInfo(){
        return "电子邮件信息：Hello World";
    }
}
// 微信
class WeiXin implements IReceiver{
    @Override
    public String getInfo() {
        return "微信信息：Hello World";
    }
}
class Person{
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}
