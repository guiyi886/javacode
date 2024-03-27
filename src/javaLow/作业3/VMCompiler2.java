package javaLow.javaLow.作业3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class VMCompiler2 {
    private Stack<Integer> stack = new Stack<>();
    private int[] memorySegmentLocal = new int[300];
    private int[] memorySegmentArgument = new int[300];
    private int[] memorySegmentThis = new int[300];
    private int[] memorySegmentThat = new int[300];
    private int[] memorySegmentPointer = new int[2];
    private int[] memorySegmentTemp = new int[8];
    private int[] memorySegmentStatic = new int[256];
    private int SP = 256; // Stack Pointer

    public static void main(String[] args) {
        VMCompiler2 compiler = new VMCompiler2();

        try {
//            BufferedReader reader = new BufferedReader(new FileReader("D:\\BasicTest.vm"));
//            BufferedReader reader = new BufferedReader(new FileReader("D:\\PointerTest.vm"));
            BufferedReader reader = new BufferedReader(new FileReader("D:\\staticTest.vm"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String command = parts[0];

                if (command.equals("push")) {
                    String segment = parts[1];
                    int index = Integer.parseInt(parts[2]);
                    compiler.push(segment, index);
                } else if (command.equals("pop")) {
                    String segment = parts[1];
                    int index = Integer.parseInt(parts[2]);
                    compiler.pop(segment, index);
                } else if (command.equals("add")) {
                    // 处理 add 命令
                    if (!compiler.stack.isEmpty()) {
                        int x = compiler.stack.pop();
                        if (!compiler.stack.isEmpty()) {
                            int y = compiler.stack.pop();
                            int result = x + y;
                            compiler.stack.push(result);
                        } else {
                            System.out.println("Error: Stack is empty.");
                        }
                    } else {
                        System.out.println("Error: Stack is empty.");
                    }
                } else if (command.equals("sub")) {
                    // 处理 sub 命令
                    if (!compiler.stack.isEmpty()) {
                        int x = compiler.stack.pop();
                        if (!compiler.stack.isEmpty()) {
                            int y = compiler.stack.pop();
                            int result = y - x;
                            compiler.stack.push(result);
                        } else {
                            System.out.println("Error: Stack is empty.");
                        }
                    } else {
                        System.out.println("Error: Stack is empty.");
                    }
                } else if (command.equals("neg")) {
                    // 处理 neg 命令
                    int x = compiler.stack.pop();
                    int result = -x;
                    compiler.stack.push(result);
                }
                if (!compiler.stack.isEmpty())
                    System.out.println("Result: " + compiler.stack.peek());
                else
                    System.out.println("null");
            }

            // 打印堆栈顶部的结果
            if (!compiler.stack.isEmpty()) {
                System.out.println("Result: " + compiler.stack.peek());
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void push(String segment, int index) {
        if (segment.equals("constant")) {
            stack.push(index);
        } else if (segment.equals("local")) {
            stack.push(memorySegmentLocal[index]);
        } else if (segment.equals("argument")) {
            stack.push(memorySegmentArgument[index]);
        } else if (segment.equals("this")) {
            stack.push(memorySegmentThis[index]);
        } else if (segment.equals("that")) {
            stack.push(memorySegmentThat[index]);
        } else if (segment.equals("pointer")) {
            stack.push(memorySegmentPointer[index]);
        } else if (segment.equals("temp")) {
            stack.push(memorySegmentTemp[index]);
        } else if (segment.equals("static")) {
            stack.push(memorySegmentStatic[index]);
        }
    }

    public void pop(String segment, int index) {
        if (segment.equals("local")) {
            memorySegmentLocal[index] = stack.pop();
        } else if (segment.equals("argument")) {
            memorySegmentArgument[index] = stack.pop();
        } else if (segment.equals("this")) {
            memorySegmentThis[index] = stack.pop();
        } else if (segment.equals("that")) {
            memorySegmentThat[index] = stack.pop();
        } else if (segment.equals("pointer")) {
            memorySegmentPointer[index] = stack.pop();
        } else if (segment.equals("temp")) {
            memorySegmentTemp[index] = stack.pop();
        } else if (segment.equals("static")) {
            memorySegmentStatic[index] = stack.pop();
        }
    }
}
