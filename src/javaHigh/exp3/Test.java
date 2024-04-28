package javaHigh.exp3;

/**
 * @author guiyi
 * @Date 2024/4/28 下午6:17:23
 * @ClassName javaHigh.exp3.Test
 * @function -->
 */
public class Test {
    public static void main(String[] args) {
        // 创建普通存储对象
        Storage<String> storage = new Storage<>();

        // 存储一些元素
        storage.store("Item 1");
        storage.store("Item 2");
        storage.store("Item 3");

        // 检索并打印元素
        System.out.println("Retrieved item at index 0: " + storage.retrieve(0));
        System.out.println("Retrieved item at index 1: " + storage.retrieve(1));
        System.out.println("Retrieved item at index 2: " + storage.retrieve(2));
        System.out.println();

        // 创建计数存储对象
        CountingStorage<String> countingStorage = new CountingStorage<>();

        // 存储一些元素
        countingStorage.store("Item A");
        countingStorage.store("Item B");

        // 检索并打印元素
        System.out.println("Retrieved item at index 0: " + countingStorage.retrieve(0));
        System.out.println("Retrieved item at index 1: " + countingStorage.retrieve(1));

        // 打印存储的元素总数
        System.out.println("Total items stored: " + countingStorage.getItemCount());
        System.out.println();

        // 创建转发计数存储对象
        CountingStorageWithForwarding<String> forwardingStorage = new CountingStorageWithForwarding<>();

        // 存储一些元素
        forwardingStorage.store("Item X");
        forwardingStorage.store("Item Y");

        // 检索并打印元素
        System.out.println("Retrieved item at index 0: " + forwardingStorage.retrieve(0));
        System.out.println("Retrieved item at index 1: " + forwardingStorage.retrieve(1));

        // 打印存储的元素总数
        System.out.println("Total items stored: " + forwardingStorage.getItemCount());
    }
}
