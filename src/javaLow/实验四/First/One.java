package javaLow.实验四.First;

// 定义一个名为PrintChar的类，实现Runnable接口
class PrintChar implements Runnable {
    private char charToPrint; // 要打印的字符
    private int times; // 重复次数

    // 构造函数，用于创建一个新的对象并设置这些值
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    // 实现Runnable接口的run方法，执行打印任务
    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

// 定义一个类PrintNum，实现Runnable接口
class PrintNum implements Runnable {
    private int lastNum; // 要打印的数字的上限

    // 构造函数，接受一个整数参数作为n的值
    public PrintNum(int n) {
        lastNum = n;
    }

    // 实现Runnable接口的run方法，用于打印数字
    @Override
    public void run() {
        // 使用for循环从1到n打印数字
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}

public class One {
    public static void main(String[] args) {
        // 创建三个Runnable对象
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // 创建三个线程，分别执行打印字符 'a'、字符 'b' 和数字从 1 到 100 的任务
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // 启动三个线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
