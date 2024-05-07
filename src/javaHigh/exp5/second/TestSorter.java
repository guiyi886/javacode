package javaHigh.exp5.second;

/**
 * @author guiyi
 * @Date 2024/5/7 下午10:31:41
 * @ClassName javaHigh.exp5.second.TestSorter
 * @function -->
 */
public class TestSorter {
    public static void main(String[] args) {
        Integer[] numbers = {10, 3, 4, 15, 7};
        String[] words = {"banana", "apple", "pear", "orange"};

        Sorter.sort(numbers);
        Sorter.sort(words);

        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Sorted words:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}

