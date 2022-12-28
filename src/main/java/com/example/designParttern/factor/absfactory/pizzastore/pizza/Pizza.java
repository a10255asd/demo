package com.example.designParttern.factor.absfactory.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/20 18:51
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore
 * @ClassName: Pizza
 * @Description: 将披萨做成抽象类
 * @Version 1.0
 */
public abstract class Pizza {
    protected String name; //名字
    //准备原材料，不同的pizza是一样的，因此我我们把它做成抽象方法
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
