package javaHigh.exp8.first;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    // 构造函数
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // 获取x坐标
    public double getX() {
        return x;
    }

    // 获取y坐标
    public double getY() {
        return y;
    }

    // 获取z坐标
    public double getZ() {
        return z;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Vector3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}

