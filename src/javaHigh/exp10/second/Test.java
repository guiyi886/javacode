package javaHigh.exp10.second;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        FileParser parser = new FileParser();

        try {
            // 正常文件
            List<Integer> numbers = parser.parseFile("D:\\numbers.txt");
            System.out.println("Parsed numbers: " + numbers);
        } catch (FileNotFoundException | InvalidContentException | EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // 含有非数字字符的文件
            List<Integer> numbers = parser.parseFile("D:\\invalid_content.txt");
            System.out.println("Parsed numbers: " + numbers);
        } catch (FileNotFoundException | InvalidContentException | EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // 空文件
            List<Integer> numbers = parser.parseFile("D:\\empty.txt");
            System.out.println("Parsed numbers: " + numbers);
        } catch (FileNotFoundException | InvalidContentException | EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // 包含空格和换行的文件
            List<Integer> numbers = parser.parseFile("D:\\spaces_and_newlines.txt");
            System.out.println("Parsed numbers: " + numbers);
        } catch (FileNotFoundException | InvalidContentException | EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
