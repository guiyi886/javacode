package javaLow.javaLow.作业2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HackAssemblerNoSymbol {
    public static void main(String[] args) {
//        String inputFileName = "D:\\Add.asm"; // 输入的汇编文件路径
//        String outputFileName = "D:\\Add.hack"; // 输出的二进制文件路径

        String inputFileName = "D:\\MaxL.asm"; // 输入的汇编文件路径
        String outputFileName = "D:\\MaxL.hack"; // 输出的二进制文件路径

        try {
            // 打开输入文件以及创建输出文件
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            int instructionCounter = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("//")) {
                    continue; // 忽略空行和注释
                }

                // 解析指令并生成对应的二进制代码
                String binaryCode = parseInstruction(line, instructionCounter);
                writer.write(binaryCode + "\n"); // 将二进制代码写入输出文件
                instructionCounter++;
            }

            // 关闭文件
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseInstruction(String instruction, int lineCounter) {
        if (instruction.startsWith("@")) {
            // A指令，以@开头
            String address = instruction.substring(1);
            int value = Integer.parseInt(address);
            // 转化为16位二进制代码
            return String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        } else {
            // C指令
            String dest = "000";
            String comp = "0000000";
            String jump = "000";

            if (instruction.contains("=")) {
                // 包含目的寄存器的情况
                String[] parts = instruction.split("=");
                dest = parseDest(parts[0]);
                comp = parseComp(parts[1]);
            } else if (instruction.contains(";")) {
                // 包含跳转条件的情况
                String[] parts = instruction.split(";");
                comp = parseComp(parts[0]);
                jump = parseJump(parts[1]);
            }

            // 组合C指令的二进制代码
            return "111" + comp + dest + jump;
        }
    }

    private static String parseDest(String dest) {
        // 解析目的寄存器
        if (dest.equals("M")) {
            return "001";
        } else if (dest.equals("D")) {
            return "010";
        } else if (dest.equals("MD")) {
            return "011";
        } else {
            return "000"; // 默认情况
        }
    }

    private static String parseComp(String comp) {
        // 解析计算部分
        Map<String, String> compTable = new HashMap<>();
        compTable.put("0", "0101010");
        compTable.put("D", "0001100");
        compTable.put("A", "0110000");
        compTable.put("!D", "0001101");
        compTable.put("!A", "0110001");
        compTable.put("-D", "0001111");
        compTable.put("-A", "0110011");
        compTable.put("D+1", "0011111");
        compTable.put("A+1", "0110111");
        compTable.put("D-1", "0001110");
        compTable.put("A-1", "0110010");
        compTable.put("D+A", "0000010");
        compTable.put("D-A", "0010011");
        compTable.put("A-D", "0000111");
        compTable.put("D&A", "0000000");
        compTable.put("D|A", "0010101");

        return compTable.get(comp);
    }

    private static String parseJump(String jump) {
        // 解析跳转条件
        Map<String, String> jumpTable = new HashMap<>();
        jumpTable.put("JGT", "001");
        jumpTable.put("JEQ", "010");
        jumpTable.put("JGE", "011");
        jumpTable.put("JLT", "100");
        jumpTable.put("JNE", "101");
        jumpTable.put("JLE", "110");
        jumpTable.put("JMP", "111");

        return jumpTable.get(jump);
    }
}
