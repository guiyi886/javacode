package javaLow.作业5.cn.edu;

import java.util.ArrayList;
import java.util.List;

// 深圳大学类
public class SZU {
    List<javaLow.作业5.cn.edu.College> colleges;

    // 构造方法，初始化学院列表
    public SZU() {
        colleges = new ArrayList<>();
    }

    // 添加学院的方法
    public void addCollege(javaLow.作业5.cn.edu.College college) {
        colleges.add(college);
    }

    // 获取学院名称并输出的方法
    public void getCollegeNames() {
        System.out.println("学院列表：");
        for (javaLow.作业5.cn.edu.College college : colleges) {
            System.out.println(college.getName());
        }
    }

    // 获取学院数量并输出的方法
    public void getCollegeNumber() {
        System.out.println("学院数量：" + colleges.size());
    }
}
