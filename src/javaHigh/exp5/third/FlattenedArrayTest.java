package javaHigh.exp5.third;

/**
 * @author guiyi
 * @Date 2024/5/7 下午11:06:46
 * @ClassName javaHigh.exp5.third.FlattenedArrayTest
 * @function -->
 */
public class FlattenedArrayTest {
    public static void main(String[] args) {
        FlattenedArray<String> fa = new FlattenedArray<>();
        fa.add(new String[]{"apple", "banana"});
        fa.add(new String[]{"cherry", "date", "elderberry"});
        fa.add(new String[]{"fig"});

        System.out.println("Original: " + fa.get(0)); // 输出 "apple"
        fa.set(0, 0, "apricot"); // 修改第⼀个数组的第⼀个元素
        System.out.println("Modified: " + fa.get(0)); // 输出 "apricot"
        System.out.println("Unaffected: " + fa.get(3)); // 输出 "date"，验证独⽴性
        System.out.println(fa.size()); // 输出 6
        System.out.println("Arrays: " + fa.toString()); // 输出所有数组的元素
        // 输出格式：[[apricot, banana], [cherry, date, elderberry], [fig]]

        try {
            fa.get(-1); // 尝试访问⼀个负索引
            System.out.println("Test Illegal Index Access: Failed (No exception for negative index)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Test Illegal Index Access: Passed (Correct exception for negative index)");
        }

        try {
            fa.get(6); // 尝试访问⼀个不存在的索引
            System.out.println("Test Illegal Index Access: Failed (No exception for index out of bounds)");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Test Illegal Index Access: Passed (Correct exception for index out of bounds)");
        }
    }
}

