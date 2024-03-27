package javaLow.实验二;

// 定义一个 Athlete 类，表示运动员
class Athlete {
    String name; // 运动员姓名
    String sport; // 所参加的运动项目
    int medal; // 奖牌数量

    // 构造函数，用于初始化 Athlete 对象的属性
    public Athlete(String name1, String sport1, int medal1) {
        name = name1;
        sport = sport1;
        medal = medal1;
    }

    // 覆盖 toString() 方法，返回对象的详细信息
    public String toString() {
        return "姓名：" + name + '\n' + "运动项目："
                + sport + '\n' + "奖牌数量：" + medal;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // 创建一个 Athlete 对象，表示杨倩运动员，参加射击项目，获得 2 枚奖牌
        Athlete yangQian = new Athlete("杨倩", "射击", 2);

        // 打印对象的详细信息，将调用 toString() 方法
        System.out.println(yangQian);
    }
}
