package javaLow.实验二;

// 定义抽象类 Ball
abstract class Ball {
    private String sportName;   // 球类运动的名称

    // 构造函数
    public Ball(String name) {
        sportName = name;
    }

    // 抽象方法，用于描述球类的运动行为
    public abstract void play();

    // 返回球类名称
    public String getSport() {
        return sportName;
    }
}

// 实现羽毛球类
class Badminton extends Ball {
    // 构造函数
    public Badminton() {
        super("羽毛球");
    }

    // 实现抽象方法
    public void play() {
        System.out.println("现在打的是羽毛球");
    }
}

// 实现兵乓球类
class TableTennis extends Ball {
    // 构造函数
    public TableTennis() {
        super("兵乓球");
    }

    // 实现抽象方法
    public void play() {
        System.out.println("现在打的是兵乓球");
    }
}

// 实现排球类
class Volleyball extends Ball {
    // 构造函数
    public Volleyball() {
        super("排球");
    }

    // 实现抽象方法
    public void play() {
        System.out.println("现在打的是排球");
    }
}

public class Main1 {
    public static void main(String[] args) {
        // 创建三个球类的对象
        Badminton ball1 = new Badminton();
        TableTennis ball2 = new TableTennis();
        Volleyball ball3 = new Volleyball();

        // 输出ball1的球类名称并调用实现后的抽象方法
        System.out.println(ball1.getSport());
        ball1.play();

        System.out.println(ball2.getSport());
        ball2.play();

        System.out.println(ball3.getSport());
        ball2.play();
    }
}
