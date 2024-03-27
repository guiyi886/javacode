package javaLow.实验一; // 声明包名

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxFive {
    public static void main(String[] args) {

        // 记录程序开始时间
        long startTime = System.currentTimeMillis();

        double[][] zu = new double[100][100]; // 创建一个100x100的二维数组

        // 随机赋值
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                zu[i][j] = Math.random(); // 使用Math.random()随机生成0到1之间的数赋值给数组元素
            }
        }

        /*//输出部分数组测试
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(zu[i][j] + " ");
            }
            System.out.print('\n');
        }*/

        List<Double> maxFive = new ArrayList<>(); // 创建一个存放最大值的List

        // 获取最大的五个值
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (maxFive.size() < 5) { // 如果maxFive中不足5个值，直接添加
                    maxFive.add(zu[i][j]);
                } else {
                    double minVal = Collections.min(maxFive); // 找出maxFive中最小的值
                    int minIndex = maxFive.indexOf(minVal); // 找出最小值的索引

                    if (zu[i][j] > minVal) { // 如果当前值大于最小值，替换掉最小值
                        maxFive.set(minIndex, zu[i][j]);
                    }
                }
            }
        }

        // 排序后输出
        Collections.sort(maxFive, Collections.reverseOrder()); // 对maxFive降序排序
        for (Double value : maxFive) {
            System.out.print(value + " "); // 输出最大的五个值
        }
        System.out.print('\n');

        // 记录程序结束时间
        long endTime = System.currentTimeMillis();

        // 计算时间差（以毫秒为单位）
        long timeDifference = endTime - startTime;

        System.out.println("程序运行时间: " + timeDifference + " ms"); // 输出程序运行时间
    }
}
