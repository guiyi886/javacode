package javaHigh.exp5.first;

/**
 * @author guiyi
 * @Date 2024/5/7 下午9:08:21
 * @ClassName javaHigh.exp5.first.MyLinkedList
 * @function -->
 */
public class MyLinkedList<E> {
    // 定义链表节点内部类
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // 在链表末尾添加元素
    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 在链表开头添加元素
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 根据给定的索引删除链表中的元素
    public void remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (idx == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // 返回指定位置的元素
    public E get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current.data;
    }

    // 返回链表的元素数量
    public int size() {
        return size;
    }

    // 检查是否包含指定元素
    public boolean contains(E e) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 清空链表
    public void clear() {
        head = null;
        size = 0;
    }

    // 将链表元素转换成数组
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] array = (E[]) new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }
}
