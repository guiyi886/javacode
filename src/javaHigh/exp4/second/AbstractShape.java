package javaHigh.exp4.second;

/**
 * @author guiyi
 * @Date 2024/4/29 下午4:13:08
 * @ClassName javaHigh.exp4.second.AbstractShape
 * @function -->
 */
// 骨架类--抽象图形类，提供了绘制图形的默认实现，并要求子类实现计算面积的方法
abstract class AbstractShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getSimpleName());
    }
}
