package javaLow.实验二;

// 定义一个 Queue 类，用来存储 short 型数据，实现先进先出队列
class Queue {
    private short[] elements; // 存储 short 型数据的数组
    private int size; // 队列的大小
    private int capacity; // 队列的容量

    // 构造方法，初始化队列容量为 16
    Queue() {
        size = 0; // 初始化队列大小为 0
        capacity = 16; // 初始化队列容量为 16
        elements = new short[capacity]; // 创建 short 型数组来存储数据
    }

    // 向队列中添加 short 型数据
    void enqueue(short v) {
        if (size >= capacity) {
            // 队列已满，输出错误信息
            System.out.println("队列已满! 无法添加数据!");
            return;
        }
        elements[size] = v; // 将数据添加到队列尾部
        size++; // 增加队列的大小
        System.out.println("成功在队列中添加数据" + v);
    }

    // 从队列中删除并返回 short 型数据
    short dequeue() {
        if (size <= 0) {
            // 队列内无数据，输出错误信息
            System.out.println("队列内无数据！删除数据失败！");
            return 0;
        }

        short temp = elements[0]; // 获取队列头部的数据
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1]; // 将队列中的数据往前移动一位
        }
        size--; // 减小队列的大小
        return temp; // 返回被删除的数据
    }

    // 返回队列的大小
    int getSize() {
        return size;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue((short) 1); // 向队列中添加数据 1
        System.out.println("队列大小为" + queue.getSize());

        queue.enqueue((short) 3); // 向队列中添加数据 3
        System.out.println("队列大小为" + queue.getSize());

        queue.enqueue((short) 5); // 向队列中添加数据 5
        System.out.println("队列大小为" + queue.getSize());

        System.out.println("从队列中移除数据" + queue.dequeue()); // 从队列中移除数据并输出
        System.out.println("队列大小为" + queue.getSize()); // 打印队列的当前大小
    }
}
