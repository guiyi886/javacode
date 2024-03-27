package javaLow.实验一; // 声明包名

import java.util.Scanner;

public class CalPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建一个Scanner对象来获取用户输入

        int flag = 0; // 用于控制输出格式的标志
        System.out.println("1-500之间的素数有:");
        for (int i = 2; i <= 500; i++) { // 循环从2到500，检查每个数是否为素数
            if (isPrime(i)) { // 调用isPrime方法检查是否为素数
                System.out.print(i + " "); // 输出素数

                flag++;
                if (flag == 10) { // 当输出10个素数时换行
                    System.out.println();
                    flag = 0; // 重置标志
                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 2 || number == 3) { // 2和3都是素数
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) { // 如果能被2或3整除，不是素数
            return false;
        }
        for (int i = 2; i <= number / 2; i++) { // 从2到number的一半遍历
            if (number % i == 0) { // 如果能被整除，不是素数
                return false;
            }
        }
        return true; // 如果以上条件都不满足，是素数
    }
}
