package javaLow.实验一; // 声明包名

public class FenZiMu {
    public static void main(String[] args) {
        double fenzi = 1, fenmu = 1, all = 0; // 初始化分子、分母和总和
        int n = 20; // 设置要计算的数列项数为20

        while (n-- > 0) { // 循环计算数列的前20项
            all += fenzi / fenmu; // 将当前项的分子除以分母并加到总和中
            fenzi++; // 分子递增
            fenmu *= 5; // 分母递增，每次乘以5
        }

        System.out.println("数列的前20项之和为:" + all); // 输出数列的前20项之和
    }
}
