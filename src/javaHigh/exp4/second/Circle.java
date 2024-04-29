package javaHigh.exp4.second;

/**
 * @author guiyi
 * @Date 2024/4/29 下午4:13:58
 * @ClassName javaHigh.exp4.second.Circle
 * @function -->
 */

// 圆形类，继承自抽象图形类
class Circle extends AbstractShape {
    private final double radius; // 圆的半径

    // 构造方法，初始化半径
    public Circle(double radius) {
        this.radius = radius;
    }

    // 实现计算圆的面积方法
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
