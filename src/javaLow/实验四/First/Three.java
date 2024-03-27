package javaLow.实验四.First;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 定义类 Three
public class Three {
    // 创建一个共享账户对象
    private static Account account = new Account();

    // 主方法
    public static void main(String[] args) {
        // 创建一个可缓存的线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        // 向线程池提交 100 个任务，每个任务都是向账户添加一元钱
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPenny());
        }

        // 关闭线程池
        executor.shutdown();

        // 等待线程池中的所有任务执行完成
        while (!executor.isTerminated()) {

        }

        // 打印最终账户余额
        System.out.println("账户余额是多少？" + account.getBalance());
    }

    // 定义一个实现了 Runnable 接口的内部类 AddAPenny，用于向账户添加一分钱的任务
    private static class AddAPenny implements Runnable {
        public void run() {
            account.deposit(1);
        }
    }

    // 定义一个账户类
    private static class Account {
        private int balance = 0; // 账户余额

        // 获取账户余额的方法
        public int getBalance() {
            return balance;
        }

        // 向账户存款的方法
        public synchronized void deposit(int amount) {
            // 计算新的余额
            int newBalance = balance + amount;

            try {
                // 模拟存款过程中的一些处理时间
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                // 处理中断异常
            }

            // 更新账户余额
            balance = newBalance;
        }
    }
}
