package javaLow.实验四;

public class Forth {
    private static final Object lock = new Object(); // 用于同步的锁对象
    private static int westCount = 0;
    private static int eastCount = 0;
    private static String lastPerson;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            runSimulation();
        }
        System.out.println("东边先过桥的总次数为： " + eastCount);
        System.out.println("西边先过桥的总次数为： " + westCount);
    }

    private static void runSimulation() {
        // 创建20个东边和20个西边的人线程
        Thread[] eastThreads = createThreads("E", 20);
        Thread[] westThreads = createThreads("W", 20);

        // 启动所有线程
        startThreads(eastThreads);
        startThreads(westThreads);

        // 等待所有线程执行完毕
        joinThreads(eastThreads);
        joinThreads(westThreads);

        // 输出本次模拟的统计结果
        if (lastPerson.equals("E")) { // 注意字符串比较应该使用 equals 方法
            System.out.println("西边的先过完桥");
            westCount++;
        } else {
            System.out.println("东边的先过完桥");
            eastCount++;
        }
        System.out.println();
    }

    private static Thread[] createThreads(String prefix, int count) {
        Thread[] threads = new Thread[count];
        for (int i = 1; i <= count; i++) {
            threads[i - 1] = new Thread(new Person(prefix + i));
        }
        return threads;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void joinThreads(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 代表一个人的线程类
    private static class Person implements Runnable {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            crossBridge();
        }

        private void crossBridge() {
            synchronized (lock) {
                try {
                    Thread.sleep(1); // 模拟过桥时间
                    System.out.print(name + ",");
                    if (name.startsWith("E")) {
                        lastPerson = "E";
                    } else {
                        lastPerson = "W";
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

