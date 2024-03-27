package javaLow.实验三.First;

public class Test3 {
    public static void main(String[] args) {
        // 定义一个字符串s
        String s = "Java";

        // 创建一个StringBuilder对象builder，并用s初始化它
        StringBuilder builder = new StringBuilder(s);

        // 调用change方法，传递字符串s和StringBuilder对象builder
        change(s, builder);

        // 输出原始字符串s，预期结果为"Java"
        System.out.println(s);

        // 输出经过change方法修改后的StringBuilder对象builder，预期结果为"Java and HTML"
        System.out.println(builder);
    }

    // 定义一个私有方法change，接收一个字符串s和一个StringBuilder对象builder
    private static void change(String s, StringBuilder builder) {
        // 修改字符串s，将其末尾添加" and HTML"
        s = s + " and HTML";

        // 修改StringBuilder对象builder，将其末尾添加" and HTML"
        builder.append(" and HTML");
    }
}
