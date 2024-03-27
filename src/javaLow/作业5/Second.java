package javaLow.作业5;

import javaLow.作业5.cn.edu.College;
import javaLow.作业5.cn.edu.SZU;

public class Second {
    public static void main(String[] args) {
        // 创建深圳大学实例
        javaLow.作业5.cn.edu.SZU szu = new SZU();

        // 添加两个学院到深圳大学实例中
        szu.addCollege(new javaLow.作业5.cn.edu.College("计算与软件学院"));
        szu.addCollege(new College("电子与信息学院"));

        // 调用方法输出学院数量和学院列表
        szu.getCollegeNumber();
        szu.getCollegeNames();
    }
}
