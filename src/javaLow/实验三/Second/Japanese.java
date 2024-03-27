package javaLow.实验三.Second;

// Japanese 类
public class Japanese extends javaLow.实验三.Second.Human {
    // 构造方法
    public Japanese(String name) {
        super(name);
    }

    // 重写 sayHi() 方法
    @Override
    public void sayHi() {
        System.out.println("こんにちは、私は" + name + "です。"); // 输出日文问候
    }
}
