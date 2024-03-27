package javaLow.实验五;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.*;
import java.util.concurrent.TimeUnit;

class Question {
    String content;
    List<String> options;
    List<String> correctAnswers;

    public Question(String content, List<String> options, List<String> correctAnswers) {
        this.content = content;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }
}

public class Second extends JFrame {
    private List<Question> questionBank;
    private int currentQuestionIndex;
    private int totalQuestions;
    private int correctSingleChoice;
    private int correctMultipleChoice;
    private int correctTrueFalse;
    private int totalScore;
    private int totalTimeSpent;

    private JLabel questionLabel;
    private ButtonGroup optionGroup;
    private JButton submitButton;

    public Second() {
        // 初始化题库
        initializeQuestionBank();

        // 初始化界面
        initComponents();

        // 创建并启动题目显示线程
        Thread giveQuestionThread = new Thread(this::giveQuestion);
        giveQuestionThread.start();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        questionLabel = new JLabel();
        add(questionLabel, BorderLayout.CENTER);

        optionGroup = new ButtonGroup();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理用户提交答案的逻辑
                checkAnswer();
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeQuestionBank() {
        questionBank = new ArrayList<>();

        // 添加至少10个单选题
        for (int i = 1; i <= 10; i++) {
            String content = "单选题 " + i + ": 1+1=?";
            List<String> options = Arrays.asList("A. 1 ", "B. 2 ", "C. 3 ", "D. 4 ");
            List<String> correctAnswers = Collections.singletonList("B");
            questionBank.add(new Question(content, options, correctAnswers));
        }

        // 添加至少10个多选题
        for (int i = 1; i <= 10; i++) {
            String content = "多选题 " + i + ": 这是问题的内容?";
            List<String> options = Arrays.asList("A. 选项A", "B. 选项B", "C. 选项C", "D. 选项D");
            List<String> correctAnswers = Arrays.asList("A", "B");
            questionBank.add(new Question(content, options, correctAnswers));
        }

        // 添加至少10个判断题
        for (int i = 1; i <= 10; i++) {
            String content = "判断题 " + i + ": 这是问题的内容?";
            List<String> options = Arrays.asList("A. 是", "B. 否");
            List<String> correctAnswers = Collections.singletonList("A");
            questionBank.add(new Question(content, options, correctAnswers));
        }

        // 打乱题目顺序
        Collections.shuffle(questionBank);
        totalQuestions = questionBank.size();
    }

    private void giveQuestion() {
        for (currentQuestionIndex = 0; currentQuestionIndex < totalQuestions; currentQuestionIndex++) {
            Question currentQuestion = questionBank.get(currentQuestionIndex);

            // 显示题目内容和选项
            displayQuestion(currentQuestion);

            // 重置用户答案
            resetUserAnswers();

            // 启动计时定时器
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // 用户未提交时自动提交
                    checkAnswer();
                }
            }, TimeUnit.SECONDS.toMillis(20));

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(20)); // 等待用户回答问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 计算用户答题时间
            totalTimeSpent += 20; // 使用20秒作为答题时间
            timer.cancel(); // 取消定时器
        }

        // 展示最终成绩
        displayFinalScore();
    }


    private void displayQuestion(Question question) {
        SwingUtilities.invokeLater(() -> {
            questionLabel.setText(question.content);

            optionGroup.clearSelection();

            // 清空原有的按钮
            removeAllRadioButtons();

            JPanel optionsPanel = new JPanel();
            for (String option : question.options) {
                JRadioButton radioButton = new JRadioButton(option);
                optionGroup.add(radioButton);
                optionsPanel.add(radioButton);
            }

            add(optionsPanel, BorderLayout.NORTH);
            submitButton.setEnabled(true);
            this.revalidate(); // 重绘界面
        });
    }


    // 移除之前的单选按钮
    private void removeAllRadioButtons() {
        Enumeration<AbstractButton> buttons = optionGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            remove(button);
        }
    }


    private void resetUserAnswers() {
        // 获取当前题目
        Question currentQuestion = questionBank.get(currentQuestionIndex);

        // 根据题型进行不同的重置操作
        if (currentQuestion.options.size() == 2 || currentQuestion.correctAnswers.size() == 1) {
            // 判断题或单选题，使用一个单选按钮
            clearRadioButtons(optionGroup);
        } else {
            // 多选题，使用多个复选框
            clearCheckBoxes(optionGroup);
        }
    }


    // 清空单选按钮组
    private void clearRadioButtons(ButtonGroup group) {
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            button.setSelected(false);
        }
    }

    // 清空复选框组
    private void clearCheckBoxes(ButtonGroup group) {
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button instanceof JCheckBox) {
                ((JCheckBox) button).setSelected(false);
            }
        }
    }


    private void checkAnswer() {
        // 获取当前题目
        Question currentQuestion = questionBank.get(currentQuestionIndex);

        // 获取用户的选择
        List<String> userAnswers = getUserAnswers();

        // 检查用户答案是否正确
        boolean isCorrect = checkCorrectness(currentQuestion.correctAnswers, userAnswers);

        // 更新成绩等信息
        updateScore(isCorrect, currentQuestion);

        // 清空选项
        clearOptions();

        // 如果是最后一题，显示最终成绩
        if (currentQuestionIndex == totalQuestions - 1) {
            displayFinalScore();
        }
    }

    // 获取用户的选择
    private List<String> getUserAnswers() {
        List<String> userAnswers = new ArrayList<>();
        Enumeration<AbstractButton> buttons = optionGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                userAnswers.add(button.getText());
            }
        }
        return userAnswers;
    }

    // 检查用户答案是否正确
    private boolean checkCorrectness(List<String> correctAnswers, List<String> userAnswers) {
        return correctAnswers.equals(userAnswers);
    }

    // 更新成绩等信息
    private void updateScore(boolean isCorrect, Question currentQuestion) {
        // 如果用户答对了
        if (isCorrect) {
            totalScore += calculateScore(currentQuestion); // 更新总分

            // 根据题型更新各题型正确数量
            if (currentQuestion.options.size() == 2) {
                // 判断题，分数加1
                correctTrueFalse += 1;
            } else if (currentQuestion.correctAnswers.size() == 1) {
                // 单选题，分数加1
                correctSingleChoice += 1;
            } else {
                // 多选题，分数加2
                correctMultipleChoice += 1;
            }
        }

        // 更新已经给出的题目数量
        int answeredQuestions = currentQuestionIndex + 1;

    }

    // 根据题型计算分数
    private int calculateScore(Question question) {
        if (question.options.size() == 2) {
            // 判断题，分数加1
            return 1;
        } else if (question.correctAnswers.size() == 1) {
            // 单选题，分数加1
            return 1;
        } else {
            // 多选题，分数加2
            return 2;
        }
    }

    private void clearOptions() {
        SwingUtilities.invokeLater(() -> {
            optionGroup.clearSelection();
            submitButton.setEnabled(false);
        });
    }

    private void displayFinalScore() {
        // 构建最终成绩的字符串
        StringBuilder finalScoreMessage = new StringBuilder();
        finalScoreMessage.append("你的最终成绩：\n");
        finalScoreMessage.append("总分: ").append(totalScore).append("\n");
        finalScoreMessage.append("单选题正确数量: ").append(correctSingleChoice).append("\n");
        finalScoreMessage.append("多选题正确数量: ").append(correctMultipleChoice).append("\n");
        finalScoreMessage.append("判断题正确数量: ").append(correctTrueFalse).append("\n");


        // 使用JOptionPane显示最终成绩和退出按钮
        int option = JOptionPane.showOptionDialog(
                this,
                finalScoreMessage.toString(),
                "最终成绩",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"退出应用", "重新开始"},
                "退出应用");

        // 处理用户选择
        if (option == JOptionPane.YES_OPTION) {
            // 用户选择退出应用
            System.exit(0);
        } else {
            // 用户选择重新开始
            resetScores();  // 重置成绩等信息，以便再次开始测试
            resetUserAnswers();  // 重置用户的答案
            currentQuestionIndex = 0;  // 重置题目索引
            giveQuestion();  // 开始下一轮测试
        }
    }

    // 重置成绩等信息
    private void resetScores() {
        totalScore = 0;
        correctSingleChoice = 0;
        correctMultipleChoice = 0;
        correctTrueFalse = 0;
        totalTimeSpent = 0;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Second::new);
    }
}
