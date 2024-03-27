package javaLow.实验三.Second;

public class HumanTest {
    public static void main(String[] args) {
        // 创建包含3个Human对象的数组
        javaLow.实验三.Second.Human[] humans = new javaLow.实验三.Second.Human[3];

        // 创建 Chinese、Japanese 和 English 对象并放入数组中
        humans[0] = new javaLow.实验三.Second.Chinese("张三");
        humans[1] = new javaLow.实验三.Second.Japanese("田中");
        humans[2] = new javaLow.实验三.Second.English("John");

        // 循环调用数组中的元素的 sayHi() 方法
        for (javaLow.实验三.Second.Human human : humans) {
            human.sayHi();
        }
    }
}

