package javaHigh.exp6.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {
    // 返回列表最⼤值
    public static <E extends Comparable<? super E>> E min(List<? extends E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return Collections.min(list);
    }

    // 返回列表最⼩值
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        return Collections.max(list);
    }

    // 返回列表中位数
    public static <E extends Comparable<? super E>> E median(List<? extends E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        List<E> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int size = sortedList.size();
        int middle = size / 2;
        if (size % 2 == 0) {
            return sortedList.get(middle - 1); // 偶数个元素时返回中间两个的前一个
        } else {
            return sortedList.get(middle); // 奇数个元素时返回中间元素
        }
    }
}

