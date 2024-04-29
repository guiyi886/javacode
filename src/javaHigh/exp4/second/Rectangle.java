package javaHigh.exp4.second;

/**
 * @author guiyi
 * @Date 2024/4/29 下午4:13:58
 * @ClassName javaHigh.exp4.second.Circle
 * @function -->
 */
// 矩形类，继承自抽象图形类
class Rectangle extends AbstractShape {
    private final double width; // 矩形的宽度
    private final double height; // 矩形的高度

    // 构造方法，初始化宽度和高度
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 实现计算矩形的面积方法
    @Override
    public double area() {
        return width * height;
    }
}
