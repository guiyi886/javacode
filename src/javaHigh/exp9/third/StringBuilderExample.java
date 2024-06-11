package javaHigh.exp9.third;

public class StringBuilderExample {

    public static String myFormat(String format, String... args) {
        StringBuilder result = new StringBuilder();
        int argIndex = 0;
        int i = 0;

        while (i < format.length()) {
            if (i < format.length() - 1 && format.charAt(i) == '{' && format.charAt(i + 1) == '}') {
                result.append(args[argIndex]);
                argIndex++;
                i += 2; // 跳过"{}"
            } else {
                result.append(format.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // 测试用例
        String result = myFormat("This is {} {}", "pos1", "pos2");
        System.out.println("Test Case: " + result); // 期望输出: "This is pos1 pos2"
    }
}

