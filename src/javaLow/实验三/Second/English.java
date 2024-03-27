package javaLow.实验三.Second;

// English 类
public class English extends javaLow.实验三.Second.Human {
    // 构造方法
    public English(String name) {
        super(name);
    }

    // 重写 sayHi() 方法
    @Override
    public void sayHi() {
        System.out.println("Hello, I am " + name + "."); // 输出英文问候
    }
}
