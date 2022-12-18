package com.example.designParttern.principle.ocp;




/**
 * @Author LiuJixue
 * @Date 2022/12/13 11:07
 * @PackageName:com.example.designParttern.ocp
 * @ClassName: Ocp
 * @Description: TODO
 * @Version 1.0
 */
public class Ocp {
    public static void main(String[] args) {
        // 看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Shape());
        graphicEditor.drawCircle(new Circle());
        graphicEditor.drawCircle(new Triangle());
    }
}
//这是一个用户绘图的类
class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        else if (s.m_type == 3)
            drawTriangle(s);
    }

    public void drawRectangle(Shape r) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape r) {
        System.out.println("圆形");
    }
    public void drawTriangle(Shape r) {
        System.out.println("三角形");
    }
}
class Shape{
    int m_type;
}
class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}
class Circle extends Shape{
    Circle(){
        super.m_type = 2;
    }
}
//新增画三角形
class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }
}