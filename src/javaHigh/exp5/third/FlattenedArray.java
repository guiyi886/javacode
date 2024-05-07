package javaHigh.exp5.third;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guiyi
 * @Date 2024/5/7 下午11:04:50
 * @ClassName javaHigh.exp5.third.FlattenedArray
 * @function -->
 */
public class FlattenedArray<T> {
    private List<T[]> arrays;
    private List<Integer> lengths;

    public FlattenedArray() {
        arrays = new ArrayList<>();
        lengths = new ArrayList<>();
    }

    // 添加数组
    public void add(T[] array) {
        arrays.add(array);
        lengths.add(array.length);
    }

    // 通过索引访问元素
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int i = 0;
        while (index >= lengths.get(i)) {
            index -= lengths.get(i);
            i++;
        }

        return arrays.get(i)[index];
    }

    // 计算总长度
    public int size() {
        int size = 0;
        for (int length : lengths) {
            size += length;
        }
        return size;
    }

    // 支持修改
    public void set(int arrayIndex, int elementIndex, T element) {
        if (arrayIndex < 0 || arrayIndex >= arrays.size()) {
            throw new IndexOutOfBoundsException("Array index out of bounds");
        }

        T[] array = arrays.get(arrayIndex);
        if (elementIndex < 0 || elementIndex >= array.length) {
            throw new IndexOutOfBoundsException("Element index out of bounds");
        }

        array[elementIndex] = element;
    }

    // 支持打印所有数组中的元素
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T[] array : arrays) {
            result.append("[");
            for (int i = 0; i < array.length; i++) {
                result.append(array[i]);
                if (i < array.length - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
        }
        result.append("]");
        return result.toString();
    }
}
