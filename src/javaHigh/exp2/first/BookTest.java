package javaHigh.exp2.first;

/**
 * @author guiyi
 * @Date 2024/3/27 14:51:26
 * @ClassName javaHigh.exp2.first.BookTest
 * @function -->
 */
public class BookTest {
    public static void main(String[] args) {
        // 创建几本书籍对象
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", "John Smith", 2022);
        Book book2 = new Book("978-3-16-148410-0", "Java Programming", "John Smith", 2022);
        Book book3 = new Book("978-3-16-148411-1", "Python Basics", "Alice Johnson", 2020);

        // 测试 equals 方法
        System.out.println("Book 1 equals Book 2: " + book1.equals(book2));
        System.out.println("Book 1 equals Book 3: " + book1.equals(book3));
        System.out.println("Book 1 equals Book 3: " + book1.equals(null));

        // 检查相同 ISBN 的书籍是否有相同的哈希码
        System.out.println("HashCode of Book 1: " + book1.hashCode());
        System.out.println("HashCode of Book 2: " + book2.hashCode());
        System.out.println("HashCode of Book 3: " + book3.hashCode());

        // 打印书籍对象，验证 toString 方法返回的字符串格式是否正确
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
    }
}
