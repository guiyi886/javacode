package javaLow.作业5;

import java.util.ArrayList;
import java.util.List;

// 学院类
class College {
    String name;

    // 构造方法，用于初始化学院的名称
    public College(String name) {
        this.name = name;
    }

    // 获取学院名称的方法
    public String getName() {
        return name;
    }
}

// 深圳大学类
class SZU {
    List<College> colleges;

    // 构造方法，初始化学院列表
    public SZU() {
        colleges = new ArrayList<>();
    }

    // 添加学院的方法
    public void addCollege(College college) {
        colleges.add(college);
    }

    // 获取学院名称并输出的方法
    public void getCollegeNames() {
        System.out.println("学院列表：");
        for (College college : colleges) {
            System.out.println(college.getName());
        }
    }

    // 获取学院数量并输出的方法
    public void getCollegeNumber() {
        System.out.println("学院数量：" + colleges.size());
    }
}

// 主类
class First {
    public static void main(String[] args) {
        // 创建深圳大学实例
        SZU szu = new SZU();

        // 添加两个学院到深圳大学实例中
        szu.addCollege(new College("计算与软件学院"));
        szu.addCollege(new College("电子与信息学院"));

        // 调用方法输出学院数量和学院列表
        szu.getCollegeNumber();
        szu.getCollegeNames();
    }
}
