package javaLow.实验一; // 声明包名

import java.util.Scanner;

public class Electricity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建一个Scanner对象来获取用户输入

        while (true) { // 无限循环，直到用户手动停止程序
            System.out.print("请输入电量使用量（单位：度）：");
            int electricityUsage = scanner.nextInt(); // 获取用户输入的电量使用量

            double electricityCost = calculate(electricityUsage); // 调用calculate方法计算电费

            System.out.println("用电量为：" + electricityUsage + "  电费为：" + electricityCost); // 输出电量和电费
        }
    }

    public static double calculate(int electricityUsage) {
        if (electricityUsage <= 50) { // 如果电量使用量小于等于50度
            return electricityUsage * 0.55; // 计算电费
        } else if (electricityUsage <= 220) { // 如果电量使用量在51到220度之间
            return 50 * 0.55 + (electricityUsage - 50) * 0.58; // 计算电费
        } else { // 如果电量使用量大于220度
            return 50 * 0.55 + (220 - 50) * 0.58 + (electricityUsage - 220) * 0.65; // 计算电费
        }
    }
}
