package javaHigh.expThree;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author guiyi
 * @Date 2024/5/16 下午6:59:08
 * @ClassName javaHigh.expThree.NumJaTest
 * @function -->
 */
public class NumJaTest {
    public static void main(String[] args) {
        testAddAndGetSize();
        testContains();
        testToArray();
        testArgsort();
        testAmin();
        testConcatenate();
        testWhere();
    }

    // 测试 add 方法和 size 方法
    public static void testAddAndGetSize() {
        NumJa<Integer> array = new NumJa<>(3, 3);
        for (int i = 0; i < 9; i++) {
            array.add(i);
        }
        int[] size = array.size();
        System.out.println("测试 add 和 size 方法:");
        System.out.println("行数: " + size[0] + ", 列数: " + size[1]);
        System.out.println("预期: 行数: 3, 列数: 3\n");
    }

    // 测试 contains 方法
    public static void testContains() {
        NumJa<Integer> array = new NumJa<>(3, 3);
        for (int i = 0; i < 9; i++) {
            array.add(i);
        }
        boolean contains = array.contains(5);
        System.out.println("测试 contains 方法:");
        System.out.println("包含 5: " + contains);
        System.out.println("预期: true\n");
    }

    // 测试 toArray 方法
    public static void testToArray() {
        NumJa<Integer> array = new NumJa<>(3, 3);
        for (int i = 0; i < 9; i++) {
            array.add(i);
        }
        Integer[] arr0 = array.toArray(0);
        Integer[] arr1 = array.toArray(1);
        System.out.println("测试 toArray 方法:");
        System.out.println("行优先顺序: " + Arrays.toString(arr0));
        System.out.println("列优先顺序: " + Arrays.toString(arr1));
        System.out.println("预期 行优先顺序: [0, 1, 2, 3, 4, 5, 6, 7, 8]");
        System.out.println("预期 列优先顺序: [0, 3, 6, 1, 4, 7, 2, 5, 8]\n");
    }

    // 测试 argsort 方法
    public static void testArgsort() {
        NumJa<Double> array = new NumJa<>(2, 3);
        array.add(1.2);
        array.add(3.4);
        array.add(2.1);
        array.add(4.2);
        array.add(0.1);
        array.add(3.3);

        int[] rowSortedIndices = array.argsort(0);
        int[] colSortedIndices = array.argsort(1);
        System.out.println("测试 argsort 方法:");
        System.out.println("按行排序后的索引: " + Arrays.toString(rowSortedIndices));
        System.out.println("按列排序后的索引: " + Arrays.toString(colSortedIndices));
        System.out.println("预期 按行排序后的索引: [0, 2, 1, 4, 5, 3]");
        System.out.println("预期 按列排序后的索引: [0, 3, 4, 1, 2, 5]\n");
    }

    // 测试 amin 方法
    public static void testAmin() {
        NumJa<Double> array = new NumJa<>(2, 3);
        array.add(1.2);
        array.add(3.4);
        array.add(2.1);
        array.add(4.2);
        array.add(0.1);
        array.add(3.3);

        Double minRow = NumJa.amin(array, 0);
        Double minCol = NumJa.amin(array, 1);
        System.out.println("测试 amin 方法:");
        System.out.println("按行的最小值: " + minRow);
        System.out.println("按列的最小值: " + minCol);
        System.out.println("预期 按行的最小值: 0.1");
        System.out.println("预期 按列的最小值: 0.1\n");
    }

    // 测试 concatenate 方法
    public static void testConcatenate() {
        NumJa<Integer> array1 = new NumJa<>(2, 2);
        array1.add(1);
        array1.add(2);
        array1.add(3);
        array1.add(4);

        NumJa<Integer> array2 = new NumJa<>(2, 2);
        array2.add(5);
        array2.add(6);
        array2.add(7);
        array2.add(8);

        NumJa<Integer> rowConcat = NumJa.concatenate(array1, array2, 0);
        NumJa<Integer> colConcat = NumJa.concatenate(array1, array2, 1);

        System.out.println("测试 concatenate 方法:");
        System.out.println("按行合并: " + Arrays.toString(rowConcat.toArray(0)));
        System.out.println("按列合并: " + Arrays.toString(colConcat.toArray(0)));
        System.out.println("预期 按行合并: [1, 2, 3, 4, 5, 6, 7, 8]");
        System.out.println("预期 按列合并: [1, 2, 5, 6, 3, 4, 7, 8]\n");
    }

    // 测试 where 方法
    public static void testWhere() {
        NumJa<Double> array = new NumJa<>(3, 3);
        for (int i = 0; i < 9; i++) {
            array.add((double) i);
        }

        Predicate<Double> condition = x -> x > 4.0;
        List<Integer> result = NumJa.where(array, condition);

        System.out.println("测试 where 方法:");
        System.out.println("满足条件的元素数量: " + result.get(0));
        System.out.println("行索引: " + result.subList(1, result.get(0) + 1));
        System.out.println("列索引: " + result.subList(result.get(0) + 1, result.size()));
        System.out.println("预期 满足条件的元素数量: 4");
        System.out.println("预期 行索引: [1, 2, 2, 2]");
        System.out.println("预期 列索引: [2, 0, 1, 2]");
    }
}
