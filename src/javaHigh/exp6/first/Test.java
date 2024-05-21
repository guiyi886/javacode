package javaHigh.exp6.first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // 测试 Statistics 类
        List<Integer> numbers = Arrays.asList(3, 5, 1, 4, 2);
        System.out.println("最小值: " + Statistics.min(numbers)); // 输出 1
        System.out.println("最大值: " + Statistics.max(numbers)); // 输出 5
        System.out.println("中位数: " + Statistics.median(numbers)); // 输出 3

        // 测试 SetOperation 类
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 6, 7));

        Set<Integer> unionSet = SetOperation.union(set1, set2, set3);
        System.out.println("并集: " + unionSet); // 输出 [1, 2, 3, 4, 5, 6, 7]

        Set<Integer> intersectionSet = SetOperation.intersection(set1, set2, set3);
        System.out.println("交集: " + intersectionSet); // 输出 [3]
    }
}

