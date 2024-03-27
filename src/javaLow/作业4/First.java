package javaLow.javaLow.作业4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class First {
    public static void main(String[] args) {
        // 文件路径
//        String filePath = "D:\\BasicLoop.vm";
        String filePath = "D:\\FibonacciSeries.vm";

        // 初始化堆栈
        Stack<Integer> stack = new Stack<>();

        // 初始化标签跳转表
        Map<String, Integer> labels = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int pc = 0; // 程序计数器，用于跟踪当前指令的位置

            while ((line = reader.readLine()) != null) {
                // 分割指令
                String[] parts = line.split(" ");
                String command = parts[0];

                if (command.equals("push")) {
                    int value = Integer.parseInt(parts[2]);
                    stack.push(value);
                } else if (command.equals("pop")) {
                    // 弹出堆栈中的值
                    int value = Integer.parseInt(parts[2]);
                    while (value != 0) {
                        value--;
                        stack.pop();
                    }
                } else if (command.equals("add")) {
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = x + y;
                    stack.push(result);
                } else if (command.equals("sub")) {
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = y - x;
                    stack.push(result);
                } else if (command.equals("label")) {
                    // 标签指令，将标签名称和对应的程序计数器位置映射
                    labels.put(parts[1], pc);
                } else if (command.equals("if-goto")) {
                    // 如果堆栈顶的值为0，则跳转到指定标签位置
                    String label = parts[1];
                    if (stack.peek() == 0) {
                        pc = labels.get(label);
                    }
                } else if (command.equals("goto")) {
                    // 无条件跳转到指定标签位置
                    String label = parts[1];
                    pc = labels.get(label);
                } else {
                    continue;
                }

                // 打印堆栈中的内容
                System.out.println("Stack: " + stack);
            }

            // 打印最终堆栈中的结果
            if (!stack.isEmpty()) {
                System.out.println("Result: " + stack.peek());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
