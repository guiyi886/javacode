package javaLow.实验五;

import javaLow.实验五.baidu.BaiduTranslations;
import javaLow.实验五.youdao.YouDaoTranslates;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class First {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Translation Demo");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            JLabel chineseLabel = new JLabel("中文句子:");
            JTextArea chineseTextArea = new JTextArea(3, 20);
            JLabel englishLabel1 = new JLabel("百度翻译:");
            JTextArea englishTextArea1 = new JTextArea(3, 20);
            JLabel englishLabel2 = new JLabel("有道翻译:");
            JTextArea englishTextArea2 = new JTextArea(3, 20);
            JLabel commonLabel = new JLabel("相同单词:");
            JTextArea commonTextArea = new JTextArea(3, 20);

            JButton translateButton = new JButton("翻译");

            translateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 调用翻译 API，获取翻译结果，并更新 JTextArea 的内容
                    String chineseText = chineseTextArea.getText();

                    String translation1 = new BaiduTranslations().translation(chineseText); // 使用第一个翻译 API
                    String translation2 = new YouDaoTranslates().translate(chineseText); // 使用第二个翻译 API

                    englishTextArea1.setText(translation1);
                    englishTextArea2.setText(translation2);

                    // 比较两个翻译的相同之处，并更新 JTextArea 的内容
                    String commonPart = findCommonPart(translation1, translation2);
                    commonTextArea.setText(commonPart);
                }
            });

            panel.add(chineseLabel);
            panel.add(chineseTextArea);
            panel.add(englishLabel1);
            panel.add(englishTextArea1);
            panel.add(englishLabel2);
            panel.add(englishTextArea2);
            panel.add(commonLabel);
            panel.add(commonTextArea);
            panel.add(translateButton);

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        });
    }


    // 比较两个翻译结果，找出相同之处的方法
    private static String findCommonPart(String translation1, String translation2) {
        // 检查输入是否为null
        if (translation1 == null || translation2 == null) {
            return "";
        }

        String[] words1 = translation1.split("\\s+");
        String[] words2 = translation2.split("\\s+");

        Set<String> commonWords = new HashSet<>();

        // 遍历单词数组，找出相同之处
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equals(word2)) {
                    commonWords.add(word1);
                    break;  // 找到相同之处，跳出内层循环
                }
            }
        }

        // 将Set转为字符串并用空格分隔
        StringBuilder commonPart = new StringBuilder();
        for (String commonWord : commonWords) {
            commonPart.append(commonWord).append(" ");
        }

        // 移除末尾的空格
        return commonPart.toString().trim();
    }
}
