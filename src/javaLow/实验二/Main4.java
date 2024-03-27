package javaLow.实验二;

// 定义一个 Complex 复数类，包含实数部分和虚数部分
class Complex {
    private int realPart; // 实数部分
    private int imagePart; // 虚数部分

    // 构造方法，用于初始化复数对象，将实数部分 r 和虚数部分 i都设为0
    Complex() {
        realPart = 0;
        imagePart = 0;
    }

    // 构造方法，用于初始化复数对象，传入实数部分 r 和虚数部分 i
    Complex(int r, int i) {
        realPart = r;
        imagePart = i;
    }

    // 复数相加方法，接受一个复数对象 c 作为参数，返回一个新的复数对象表示相加结果
    Complex complexADD(Complex c) {
        int newRealPart = realPart + c.realPart;
        int newImagePart = imagePart + c.imagePart;
        return new Complex(newRealPart, newImagePart);
    }

    // 复数相减方法，接受一个复数对象 c 作为参数，返回一个新的复数对象表示相减结果
    Complex complexSUB(Complex c) {
        int newRealPart = realPart - c.realPart;
        int newImagePart = imagePart - c.imagePart;
        return new Complex(newRealPart, newImagePart);
    }

    // 返回复数的字符串表示形式，形如 "a+bi"
    public String toString() {
        return realPart + "+" + imagePart + "i";
    }
}

public class Main4 {
    public static void main(String[] args) {
        // 创建两个复数对象
        Complex c1 = new Complex(3, 5);
        Complex c2 = new Complex(2, 3);

        // 输出复数相加和相减的结果
        System.out.println("复数3+5i和复数2+3i相加的结果为：" + c1.complexADD(c2));
        System.out.println("复数3+5i和复数2+3i相减的结果为：" + c1.complexSUB(c2));
    }
}
