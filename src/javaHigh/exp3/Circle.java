package javaHigh.exp3;


/**
 * @author guiyi
 * @Date 2024/4/28 下午5:01:41
 * @ClassName javaHigh.exp3.Circle
 * @function -->
 */
public class Circle extends Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
