package javaLow.作业3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class VMCompiler {
    public static void main(String[] args) {
        // 用于模拟堆栈的数据结构
        Stack<Integer> stack = new Stack<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\StackTest.vm"));
//            BufferedReader reader = new BufferedReader(new FileReader("D:\\SimpleAdd.vm"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String command = parts[0];

                if (command.equals("push")) {
                    // 处理 push 命令
                    int value = Integer.parseInt(parts[2]);
                    stack.push(value);
                } else if (command.equals("add")) {
                    // 处理 add 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = x + y;
                    stack.push(result);
                } else if (command.equals("sub")) {
                    // 处理 sub 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = y - x;
                    stack.push(result);
                } else if (command.equals("neg")) {
                    // 处理 neg 命令
                    int x = stack.pop();
                    int result = -x;
                    stack.push(result);
                } else if (command.equals("eq")) {
                    // 处理 eq 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = (y == x) ? -1 : 0;
                    stack.push(result);
                } else if (command.equals("gt")) {
                    // 处理 gt 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = (y > x) ? -1 : 0;
                    stack.push(result);
                } else if (command.equals("lt")) {
                    // 处理 lt 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = (y < x) ? -1 : 0;
                    stack.push(result);
                } else if (command.equals("and")) {
                    // 处理 and 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = x & y;
                    stack.push(result);
                } else if (command.equals("or")) {
                    // 处理 or 命令
                    int x = stack.pop();
                    int y = stack.pop();
                    int result = x | y;
                    stack.push(result);
                } else if (command.equals("not")) {
                    // 处理 not 命令
                    int x = stack.pop();
                    int result = ~x;
                    stack.push(result);
                }
                // 添加输出以便观察
                System.out.println("Result: " + stack.peek());
            }

            // 打印堆栈顶部的结果
            if (!stack.isEmpty()) {
                System.out.println("Result: " + stack.peek());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
