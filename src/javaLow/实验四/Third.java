package javaLow.实验四;// 导入包

import java.util.Random;

// 银行账户类
class BankAccount {
    private int balance; // 账户余额

    // 构造方法，初始化账户余额
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // 同步方法，用于取款操作
    public synchronized void withdraw(int amount) {
        // 检查余额是否足够
        if (balance >= amount) {
            // 执行取款操作
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取钱成功，余额为：" + balance);
        } else {
            // 余额不足，输出提示信息
            System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
        }
    }
}

// 取款线程类
class WithdrawThread implements Runnable {
    private BankAccount account; // 银行账户对象
    private Random random = new Random(); // 随机数生成器

    // 构造方法，接受一个 BankAccount 对象
    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    // 实现 Runnable 接口的 run 方法
    @Override
    public void run() {
        // 循环进行取款操作
        for (int i = 0; i < 5; i++) {
            // 随机生成取款金额
            int amount = random.nextInt(100) + 1;
            // 调用 BankAccount 的 withdraw 方法进行取款操作
            account.withdraw(amount);
            // 随机休眠一段时间，模拟不同线程之间的竞争
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 主类
public class Third {
    public static void main(String[] args) {
        // 创建一个 BankAccount 对象，初始余额为 500
        BankAccount account = new BankAccount(500);

        // 创建两个线程，共享同一个 BankAccount 对象
        Thread thread1 = new Thread(new WithdrawThread(account));
        Thread thread2 = new Thread(new WithdrawThread(account));

        // 启动两个线程
        thread1.start();
        thread2.start();
    }
}
