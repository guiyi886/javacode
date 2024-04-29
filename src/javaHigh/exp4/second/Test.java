package javaHigh.exp4.second;

/**
 * @author guiyi
 * @Date 2024/4/29 下午4:22:45
 * @ClassName javaHigh.exp4.second.Test
 * @function -->
 */
public class Test {
    public static void main(String[] args) {
        // 创建圆形对象并测试
        Circle circle = new Circle(5);
        circle.draw(); // 绘制圆形
        System.out.println("Circle area: " + circle.area()); // 计算并打印圆形的面积
        System.out.println();

        // 创建矩形对象并测试
        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.draw(); // 绘制矩形
        System.out.println("Rectangle area: " + rectangle.area()); // 计算并打印矩形的面积
    }
}
