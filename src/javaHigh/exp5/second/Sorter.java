package javaHigh.exp5.second;

/**
 * @author guiyi
 * @Date 2024/5/7 下午10:31:34
 * @ClassName javaHigh.exp5.second.Sorter
 * @function -->
 */
public class Sorter {
    // 对传入的容器参数进行排序
    // 使用 <? super E> 来限定类型参数的上界，确保在比较时使用 E 类型或其父类的对象。
    // <E extends Comparable<? super E>>的作用是，要求类型参数 E 或者 E 的父类实现了 Comparable 接口
    public static <E extends Comparable<? super E>> void sort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    E temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}

