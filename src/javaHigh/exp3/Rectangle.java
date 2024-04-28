package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午5:01:36
 * @ClassName javaHigh.exp3.Rectangle
 * @function -->
 */
public class Rectangle extends Shape {
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
