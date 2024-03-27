package javaLow.作业5.Seven;

import java.util.Arrays;

public class Seven {

    public static void main(String[] args) {
        // 示例用法
        int[] v1 = {5, 2, 1, 8};
        int[] v2 = {3, -1, 0, -4};

        Vector vector = new Vector();

        // 计算四维向量的和、差和点乘
        int[] sum = vector.add(v1, v2);
        int[] difference = vector.minus(v1, v2);
        int[] product = vector.elementwiseProduct(v1, v2);

        // 打印结果
        System.out.println("Vector 1: " + Arrays.toString(v1));
        System.out.println("Vector 2: " + Arrays.toString(v2));
        System.out.println("Sum: " + Arrays.toString(sum));
        System.out.println("Difference: " + Arrays.toString(difference));
        System.out.println("Elementwise Product: " + Arrays.toString(product));
    }
}

