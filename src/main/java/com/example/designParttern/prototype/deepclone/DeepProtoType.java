package com.example.designParttern.prototype.deepclone;

import java.io.*;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 16:14
 * @PackageName:com.example.designParttern.prototype.deepclone
 * @ClassName: DeepProtoType
 * @Description: TODO
 * @Version 1.0
 */
public class DeepProtoType implements Serializable,Cloneable {
    // String 类型
    public String name;
    // 引用类型
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }
    // 完成深拷贝实现 方式一 ： 使用clone 方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        // 完成对基本数据类型（属性）的克隆
        deep = super.clone();
        // 对引用类型的属性进行单独处理
        DeepProtoType deepProtoType =  (DeepProtoType)deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();
        return deep;
    }
    // 方式二： 通过对象的序列化实现深拷贝
    public Object deepClone(){
        // 创建流对象
        ByteArrayOutputStream  bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化操作
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); // 当前这个对象以对象流的方式输出
            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copy  = (DeepProtoType) ois.readObject();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
