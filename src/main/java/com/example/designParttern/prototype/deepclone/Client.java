package com.example.designParttern.prototype.deepclone;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 16:20
 * @PackageName:com.example.designParttern.prototype.deepclone
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType d = new DeepProtoType();
        d.name = "Song";
        d.deepCloneableTarget = new DeepCloneableTarget("大牛","大牛的类");

        // 方式一 完成深拷贝
        DeepProtoType d2 =  (DeepProtoType)d.clone();
        System.out.println("d.name = " + d.name + "d.deepCloneableTarget=" +  d.deepCloneableTarget.hashCode());
        System.out.println("d2.name = " + d2.name + "d.deepCloneableTarget=" +  d2.deepCloneableTarget.hashCode());

        // 方式二 完成深拷贝
        DeepProtoType d3 =  (DeepProtoType)d.deepClone();
        System.out.println("d.name = " + d.name + "d.deepCloneableTarget=" +  d.deepCloneableTarget.hashCode());
        System.out.println("d3.name = " + d3.name + "d3.deepCloneableTarget=" +  d3.deepCloneableTarget.hashCode());

    }
}
