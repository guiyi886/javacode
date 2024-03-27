package javaLow.实验三.First;

public class Test2 {
    public static void main(String[] args) {
        // 定义一个字符串s
        String s = "Hi, Good morning";

        // 调用方法m，并输出返回值
        // 该方法统计字符串中大写字母的个数，输出结果为2
        System.out.println(m(s));
    }

    // 定义方法m，接收一个字符串参数s，返回字符串中大写字母的个数
    public static int m(String s) {
        // 初始化计数器count
        int count = 0;

        // 遍历字符串s的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 判断字符是否为大写字母
            if (Character.isUpperCase((s.charAt(i)))) {
                // 如果是大写字母，则计数器加1
                count++;
            }
        }

        // 返回大写字母的个数
        return count;
    }
}
