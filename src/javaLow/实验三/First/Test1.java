package javaLow.实验三.First;

public class Test1 {
    public static void main(String[] args) {
        // 使用正则表达式匹配，判断字符串中是否包含"ABC "，输出结果为false
        System.out.println("Hi， ABC，good".matches("ABC "));

        // 使用正则表达式匹配，判断字符串中是否包含"ABC"，输出结果为true
        System.out.println("Hi， ABC，good".matches(".*ABC.*"));

        // 将字符串中的",;"替换为"#"
        // 输出结果为"A,B;C"
        System.out.println("A,B;C".replaceAll(",;", "#"));

        // 将字符串中的","或";"替换为"#"
        // 输出结果为"A#B#C# "
        System.out.println("A,B;C ".replaceAll("[,;]", "#"));

        // 使用正则表达式分割字符串，将其拆分为数组
        // 输出结果为"A B C "
        String[] tokens = "A,B;C".split("[,;]");
        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i] + " ");
        }
    }
}
