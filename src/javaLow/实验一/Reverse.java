package javaLow.实验一; // 声明包名

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建一个Scanner对象来获取用户输入

        while (true) { // 无限循环，直到用户手动停止程序
            System.out.print("请输入一个字符串：");
            String str = scanner.next(); // 获取用户输入的字符串

            String strRev = new StringBuilder(str).reverse().toString(); // 使用StringBuilder反转字符串
            System.out.println(str + "逆序结果为" + strRev); // 输出原字符串和逆序结果
        }
    }
}
