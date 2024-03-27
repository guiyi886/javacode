package javaLow.实验三.Second;

// Chinese 类
public class Chinese extends javaLow.实验三.Second.Human {
    // 构造方法
    public Chinese(String name) {
        super(name);
    }

    // 重写 sayHi() 方法
    @Override
    public void sayHi() {
        System.out.println("你好，我是" + name + "。"); // 输出中文问候
    }
}
