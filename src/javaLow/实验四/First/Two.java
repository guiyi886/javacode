package javaLow.实验四.First;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 定义类 Two
public class Two {
    // 主方法
    public static void main(String[] args) {
        // 创建一个固定大小为 3 的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 在线程池中执行打印字符 'a' 的任务，每个任务打印 100 次
        executor.execute(new javaLow.实验四.First.PrintChar('a', 100));
        executor.execute(new javaLow.实验四.First.PrintChar('b', 100));
        executor.execute(new javaLow.实验四.First.PrintNum(100));

        // 关闭线程池
        executor.shutdown();
    }
}
