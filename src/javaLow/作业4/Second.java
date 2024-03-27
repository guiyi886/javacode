package javaLow.javaLow.作业4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Second {
    public static void main(String[] args) {
        // 初始化堆栈
        Stack<Integer> stack = new Stack<>();

        // 函数的局部变量和参数
        int local0 = 0;
        int local1 = 0;
        int argument0 = 0;
        int argument1 = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\SimpleFunction.vm"));
            String line;

            while ((line = reader.readLine()) != null) {
                // 分割指令
                String[] parts = line.split(" ");
                String command = parts[0];

                if (command.equals("function")) {
                    // 函数定义
                    String functionName = parts[1];
                    int numLocalVars = Integer.parseInt(parts[2]);

                    // 初始化局部变量
                    local0 = 0;
                    local1 = 0;
                } else if (command.equals("push")) {
                    int value = Integer.parseInt(parts[2]);
                    stack.push(value);
                } else if (command.equals("pop")) {
                    // 弹出堆栈中的值，这里我们不处理实际的存储
                    stack.pop();
                } else if (command.equals("add")) {
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = x + y;
                    stack.push(result);
                } else if (command.equals("not")) {
                    int x = stack.pop();
                    int result = ~x;
                    stack.push(result);
                } else if (command.equals("sub")) {
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = y - x;
                    stack.push(result);
                } else if (command.equals("return")) {
                    // 返回命令，结束程序
                    break;
                }
            }

            // 打印堆栈中的内容
            System.out.println("Stack: " + stack);

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
