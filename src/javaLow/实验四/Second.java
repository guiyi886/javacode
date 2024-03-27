// 导入包
package javaLow.实验四;

// 定义 Second 类
public class Second {
    // 创建一个共享的锁对象
    private static final Object lock = new Object();
    // 用于标识数字是否已经打印的变量
    private static boolean numberPrinted = false;

    // 主方法
    public static void main(String[] args) {
        // 创建两个线程，分别用于输出数字和月份
        Thread numberThread = new Thread(new NumberPrinter());
        Thread monthThread = new Thread(new MonthPrinter());

        // 启动两个线程
        numberThread.start();
        monthThread.start();
    }

    // 实现 Runnable 接口的线程类，用于输出数字
    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 12; i++) {
                    try {
                        // 如果数字已经打印，则等待
                        while (numberPrinted == true) {
                            lock.wait();
                        }
                        // 输出数字
                        System.out.print(i);
                        // 设置数字已打印标志
                        numberPrinted = true;
                        // 唤醒等待的线程（月份线程）`
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 实现 Runnable 接口的线程类，用于输出月份
    static class MonthPrinter implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                // 定义月份数组
                String[] months = {"OneJanuary", "TwoFebruary", "ThreeMarch", "FourApril", "FiveMay", "SixJune",
                        "SevenJuly", "EightAugust", "NineSeptember", "TenOctober", "ElevenNovember", "TwelveDecember"};

                // 循环输出月份
                for (int i = 0; i < 12; i++) {
                    try {
                        // 如果数字未打印，则等待
                        while (numberPrinted == false) {
                            lock.wait();
                        }
                        // 输出月份
                        System.out.print(months[i]);
                        // 设置数字未打印标志
                        numberPrinted = false;
                        // 唤醒等待的线程（数字线程）
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
