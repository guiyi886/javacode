package javaHigh.exp8.second;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        // 使用Stream API将单词转换为大写
        List<String> list1 = Arrays.asList("My", "name", "is", "John", "Doe");
        List<String> final1 = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(final1);

        // 使用Stream API筛选字母长度小于4的单词
        List<String> final2 = list1.stream().filter(word -> word.length() < 4).collect(Collectors.toList());
        System.out.println(final2);

        // 使用flatMap将列表展开
        List<List<String>> list2 = Arrays.asList(
                Arrays.asList("Viktor", "Farcic"),
                Arrays.asList("John", "Doe", "Third")
        );
        List<String> final3 = list2.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(final3);
    }
}
