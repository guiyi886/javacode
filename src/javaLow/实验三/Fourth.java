package javaLow.实验三;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("请输入包含大写字母、小写字母和数字的字符串（测试次数：" + i + "）：");
            String input = scanner.nextLine();

            // 调用方法进行排序和输出
            sortAndPrint(input);
        }

        scanner.close();
    }

    // 排序和输出的方法
    private static void sortAndPrint(String input) {
        StringBuilder upperCaseLetters = new StringBuilder();
        StringBuilder lowerCaseLetters = new StringBuilder();
        StringBuilder numbers = new StringBuilder();

        // 遍历输入字符串的每个字符
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCaseLetters.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowerCaseLetters.append(ch);
            } else if (Character.isDigit(ch)) {
                numbers.append(ch);
            }
        }

        // 输出结果
        System.out.println("大写英文字母：" + upperCaseLetters.toString());
        System.out.println("小写英文字母：" + lowerCaseLetters.toString());
        System.out.println("数字：" + numbers.toString());
        System.out.println();
    }
}

