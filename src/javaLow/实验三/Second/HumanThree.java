package javaLow.实验三.Second;

// 定义接口 Human
interface Human2 {
    void sayHi();
}

// Chinese 类实现 Human 接口
class Chinese2 implements Human2 {
    private String name;

    // 构造方法
    public Chinese2(String name) {
        this.name = name;
    }

    // 实现接口的方法
    @Override
    public void sayHi() {
        System.out.println("你好，我是" + name + "。"); // 输出中文问候
    }
}

// Japanese 类实现 Human 接口
class Japanese2 implements Human2 {
    private String name;

    // 构造方法
    public Japanese2(String name) {
        this.name = name;
    }

    // 实现接口的方法
    @Override
    public void sayHi() {
        System.out.println("こんにちは、私は" + name + "です。"); // 输出日文问候
    }
}

// English 类实现 Human 接口
class English2 implements Human2 {
    private String name;

    // 构造方法
    public English2(String name) {
        this.name = name;
    }

    // 实现接口的方法
    @Override
    public void sayHi() {
        System.out.println("Hello, I am " + name + "."); // 输出英文问候
    }
}

public class HumanThree {
    public static void main(String[] args) {
        // 创建包含3个Human对象的数组
        Human2[] humans = new Human2[3];

        // 创建 Chinese、Japanese 和 English 对象并放入数组中
        humans[0] = new Chinese2("张三");
        humans[1] = new Japanese2("田中");
        humans[2] = new English2("John");

        // 循环调用数组中的元素的 sayHi() 方法
        for (Human2 human : humans) {
            human.sayHi();
        }
    }
}

