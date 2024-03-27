package javaLow.实验三;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fifth {
    public static void main(String[] args) {
        // 读取网页内容并保存为字符串
        String webpageContent = readWebpage("https://en.szu.edu.cn/About/About2.htm");

        // 统计单词出现次数
        Map<String, Integer> wordFrequencyMap = countWordFrequency(webpageContent);

        // 对单词出现次数进行排序
        List<Map.Entry<String, Integer>> sortedWordList = sortWordFrequency(wordFrequencyMap);

        // 输出前50个单词
        outputTop50Words(sortedWordList);
    }

    // 从网页读取内容
    private static String readWebpage(String url) {
        StringBuilder content = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new URL(url).openStream());
            while (scanner.hasNext()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // 统计单词出现次数
    private static Map<String, Integer> countWordFrequency(String content) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // 使用正则表达式提取英文单词
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        Matcher matcher = pattern.matcher(content.toLowerCase()); // 转换为小写进行统计
        while (matcher.find()) {
            String word = matcher.group();
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        return wordFrequencyMap;
    }

    // 对单词出现次数进行排序
    private static List<Map.Entry<String, Integer>> sortWordFrequency(Map<String, Integer> wordFrequencyMap) {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFrequencyMap.entrySet());

        // 使用Comparator对单词进行排序，按出现次数降序排列
        wordList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        return wordList;
    }

    // 输出前50个单词，每行输出10个单词
    private static void outputTop50Words(List<Map.Entry<String, Integer>> sortedWordList) {
        System.out.println("出现次数最多的50个英文单词：");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWordList) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")  ");
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }
            if (count == 50) {
                break;
            }
        }
    }
}
