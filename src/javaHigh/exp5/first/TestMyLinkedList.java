package javaHigh.exp5.first;

import java.util.Arrays;

/**
 * @author guiyi
 * @Date 2024/5/7 下午9:08:29
 * @ClassName javaHigh.exp5.first.TestMyLinkedList
 * @function -->
 */
public class TestMyLinkedList {
    public static void main(String[] args) {
        // 创建 MyLinkedList 实例
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // 测试空链表的操作
        System.out.println("Initial size of list: " + list.size()); // 预期输出: 0
        try {
            System.out.println("Get element from empty list: " + list.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an IndexOutOfBoundsException when trying to get element from empty list");
        }

        // 测试 addLast 和 addFirst 方法
        list.addLast(10);
        list.addFirst(5);
        list.addLast(20);
        System.out.println("After adding elements: " + Arrays.toString(list.toArray())); // 预期输出: [5, 10, 20]

        // 测试添加 null 元素
        try {
            list.addLast(null);
            System.out.println("After adding null: " + Arrays.toString(list.toArray()));
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException when adding null");
        }

        // 测试越界访问
        try {
            System.out.println("Attempt to access out of bounds: " + list.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an IndexOutOfBoundsException when accessing out of bounds");
        }

        // 测试删除操作中的越界
        try {
            list.remove(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an IndexOutOfBoundsException when trying to remove out of bounds element");
        }

        // 正常测试 contains, remove 和 size 方法
        System.out.println("List contains 10: " + list.contains(10)); // 预期输出: true
        list.remove(1);
        System.out.println("After removing element at index 1: " + Arrays.toString(list.toArray())); // 预期输出: [5, 20]
        System.out.println("Size after removal: " + list.size()); // 预期输出: 2

        // 测试 clear 方法
        list.clear();
        System.out.println("After clearing the list: " + list.size()); // 预期输出: 0

        // 重新添加元素并测试 toArray 方法
        list.addFirst(15);
        list.addLast(25);
        System.out.println("Final list: " + Arrays.toString(list.toArray())); // 预期输出: [15, 25]
    }
}
