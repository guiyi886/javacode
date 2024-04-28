package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午5:00:35
 * @ClassName javaHigh.exp3.Shape
 * @function -->抽象类 Shape，其中包含了两个抽象方法 area 和 perimeter，用于计算形状的面积和周长。
 * Shape 类是矩形类和圆类的父类，提供了面积和周长的计算接口。
 */
public abstract class Shape {
    public abstract double area();

    public abstract double perimeter();
}
