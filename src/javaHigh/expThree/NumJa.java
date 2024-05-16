package javaHigh.expThree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author guiyi
 * @Date 2024/5/15 下午2:45:14
 * @ClassName javaHigh.expThree.Numpy
 * @function -->
 */
public class NumJa<E extends Comparable<E>> {
    // 用于存储数据的一维ArrayList
    private ArrayList<E> data = new ArrayList<>();
    // 行数
    private int rows;
    // 列数
    private int cols;

    // 构造方法，初始化行数和列数
    public NumJa(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    // 向数组中添加元素
    public void add(E element) {
        // 添加元素到ArrayList
        data.add(element);
    }

    // 获取指定位置的元素
    public E get(int row, int col) {
        // 计算一维数组中的索引并返回相应的元素
        return data.get(row * cols + col);
    }

    // 返回2D数组的行数和列数
    public int[] size() {
        // 返回包含行数和列数的数组
        return new int[]{rows, cols};
    }

    // 检查是否包含指定元素
    public boolean contains(E element) {
        // 使用ArrayList的contains方法检查元素
        return data.contains(element);
    }

    // 以数组形式返回存储的数据，axis参数来指定数组的存储顺序（0表示行优先，1表示列优先）
    @SuppressWarnings("unchecked")
    public E[] toArray(int axis) {
        // 使用Array.newInstance来创建泛型数组
        E[] result = (E[]) Array.newInstance(data.get(0).getClass(), rows * cols);
        if (axis == 0) {
            // 行优先顺序，将ArrayList转换为数组
            data.toArray(result);
        } else if (axis == 1) {
            // 列优先顺序
            int index = 0;
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    // 计算列优先顺序的索引并存储到结果数组
                    result[index++] = data.get(i * cols + j);
                }
            }
        } else {
            // 如果axis值不为0或1，抛出异常
            throw new IllegalArgumentException("Invalid axis value. Must be 0 or 1.");
        }
        return result;
    }

    // 根据指定的 axis 参数（0 表示按行排序，1 表示按列排序）返回数组值从小到大的索引值
    public int[] argsort(int axis) {
        // 创建一个数组来存储排序后的索引
        int[] result = new int[rows * cols];
        int index = 0;
        if (axis == 0) {
            // 按行排序
            for (int i = 0; i < rows; i++) {
                final int row = i; // 保存当前行号
                // 创建一个 Integer 数组来存储列的索引
                Integer[] indices = IntStream.range(0, cols).boxed().toArray(Integer[]::new);
                // 使用 Arrays.sort 方法对列索引进行排序
                Arrays.sort(indices, Comparator.comparing(a -> data.get(a + row * cols)));
                // 将排序后的索引转换为 int 数组并存储到结果数组中
                for (int j = 0; j < indices.length; j++) {
                    result[index++] = indices[j] + row * cols;
                }
            }
        } else if (axis == 1) {
            // 按列排序
            for (int j = 0; j < cols; j++) {
                final int col = j; // 保存当前列号
                // 创建一个 Integer 数组来存储行的索引
                Integer[] indices = IntStream.range(0, rows).boxed().toArray(Integer[]::new);
                // 使用 Arrays.sort 方法对行索引进行排序
                Arrays.sort(indices, Comparator.comparing(a -> data.get(a * cols + col)));
                // 将排序后的索引转换为 int 数组并存储到结果数组中
                for (int i = 0; i < indices.length; i++) {
                    result[index++] = indices[i] * cols + col;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid axis value. Must be 0 or 1.");
        }
        return result;
    }

    // 提取最小值
    public static <E extends Comparable<E>> E amin(NumJa<E> arr, int axis) {
        if (axis < 0 || axis > 1) {
            throw new IllegalArgumentException("Invalid axis value. Must be 0 or 1.");
        }
        E min = null;
        if (axis == 0) {
            // 按行计算最小值
            for (int i = 0; i < arr.rows; i++) {
                for (int j = 0; j < arr.cols; j++) {
                    E value = arr.get(i, j);
                    if (min == null || value.compareTo(min) < 0) {
                        min = value;
                    }
                }
            }
        } else if (axis == 1) {
            // 按列计算最小值
            for (int j = 0; j < arr.cols; j++) {
                for (int i = 0; i < arr.rows; i++) {
                    E value = arr.get(i, j);
                    if (min == null || value.compareTo(min) < 0) {
                        min = value;
                    }
                }
            }
        }
        return min;
    }

    // 按照行或列进行合并
    public static <E extends Comparable<E>> NumJa<E> concatenate(NumJa<E> arr1, NumJa<E> arr2, int axis) {
        if (axis < 0 || axis > 1) {
            throw new IllegalArgumentException("Invalid axis value. Must be 0 or 1.");
        }
        if (axis == 0) {
            if (arr1.cols != arr2.cols) {
                throw new IllegalArgumentException("Arrays must have the same number of columns to concatenate along rows.");
            }
            // 合并行
            NumJa<E> result = new NumJa<>(arr1.rows + arr2.rows, arr1.cols);
            result.data.addAll(arr1.data);
            result.data.addAll(arr2.data);
            return result;
        } else {
            if (arr1.rows != arr2.rows) {
                throw new IllegalArgumentException("Arrays must have the same number of rows to concatenate along columns.");
            }
            // 合并列
            NumJa<E> result = new NumJa<>(arr1.rows, arr1.cols + arr2.cols);
            for (int i = 0; i < arr1.rows; i++) {
                for (int j = 0; j < arr1.cols; j++) {
                    result.add(arr1.get(i, j));
                }
                for (int j = 0; j < arr2.cols; j++) {
                    result.add(arr2.get(i, j));
                }
            }
            return result;
        }
    }

    // 查找满足条件的元素的坐标
    public static <E extends Comparable<E>> List<Integer> where(NumJa<E> arr, Predicate<E> condition) {
        List<Integer> result = new ArrayList<>();// 存储结果的列表
        List<Integer> rowIndices = new ArrayList<>();// 存储满足条件的元素的行索引
        List<Integer> colIndices = new ArrayList<>();// 存储满足条件的元素的列索引

        int num = 0;// 统计满足条件的元素数量
        // 遍历二维数组的所有元素
        for (int i = 0; i < arr.rows; i++) {
            for (int j = 0; j < arr.cols; j++) {
                // 如果元素满足条件
                if (condition.test(arr.get(i, j))) {
                    rowIndices.add(i); // 添加行索引
                    colIndices.add(j);// 添加列索引
                    num++;// 满足条件的元素数量增加
                }
            }
        }

        result.add(num);// 将满足条件的元素数量添加到结果列表
        result.addAll(rowIndices);// 将所有的行索引添加到结果列表
        result.addAll(colIndices);// 将所有的列索引添加到结果列表

        return result;
    }
}
