package javaLow.实验三.Second;

// 定义抽象类 Human
public abstract class Human {
    // 成员变量
    protected String name;

    // 构造方法，用于初始化姓名
    public Human(String name) {
        this.name = name;
    }

    // 抽象方法，子类需要实现
    public abstract void sayHi();
}

