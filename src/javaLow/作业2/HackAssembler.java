package javaLow.作业2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HackAssembler {
    public static void main(String[] args) {
        String inputFileName = "D:\\Add.asm"; // 输入的汇编文件路径
        String outputFileName = "D:\\Add.hack"; // 输出的二进制文件路径

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            int instructionCounter = 0;
            Map<String, Integer> symbolTable = new HashMap<>();

            // 预定义一些内置符号
            symbolTable.put("SP", 0);
            symbolTable.put("LCL", 1);
            symbolTable.put("ARG", 2);
            symbolTable.put("THIS", 3);
            symbolTable.put("THAT", 4);
            for (int i = 0; i <= 15; i++) {
                symbolTable.put("R" + i, i);
            }
            symbolTable.put("SCREEN", 16384);
            symbolTable.put("KBD", 24576);

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("//")) {
                    continue; // 忽略空行和注释
                }

                if (line.startsWith("(")) {
                    // 处理符号定义，将符号存入符号表
                    String symbol = line.substring(1, line.length() - 1);
                    symbolTable.put(symbol, instructionCounter);
                } else {
                    // 解析指令并生成对应的二进制代码
                    String binaryCode = parseInstruction(line, symbolTable);
                    writer.write(binaryCode + "\n");
                    instructionCounter++;
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseInstruction(String instruction, Map<String, Integer> symbolTable) {
        if (instruction.startsWith("@")) {
            // A指令，以@开头
            String address = instruction.substring(1);
            int value;
            if (Character.isDigit(address.charAt(0))) {
                // 数值地址
                value = Integer.parseInt(address);
            } else {
                // 符号地址，查找符号表获取地址
                value = symbolTable.getOrDefault(address, 0);
            }
            return String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        } else {
            // C指令
            String dest = "000";
            String comp;
            String jump = "000";

            if (instruction.contains("=")) {
                String[] parts = instruction.split("=");
                dest = parseDest(parts[0]);
                comp = parts[1];
            } else {
                comp = instruction;
            }

            if (comp.contains(";")) {
                String[] parts = comp.split(";");
                comp = parts[0];
                jump = parseJump(parts[1]);
            }

            return "111" + compCode(comp) + dest + jump;
        }
    }

    private static String parseDest(String dest) {
        // 解析目的寄存器
        if (dest.contains("M")) {
            return "001";
        } else if (dest.contains("D")) {
            return "010";
        } else if (dest.contains("A")) {
            return "100";
        } else {
            return "000"; // 默认情况
        }
    }

    private static String parseJump(String jump) {
        // 解析跳转条件
        switch (jump) {
            case "JGT":
                return "001";
            case "JEQ":
                return "010";
            case "JGE":
                return "011";
            case "JLT":
                return "100";
            case "JNE":
                return "101";
            case "JLE":
                return "110";
            case "JMP":
                return "111";
            default:
                return "000"; // 默认情况
        }
    }

    private static String compCode(String comp) {
        // 解析计算部分
        Map<String, String> compTable = new HashMap<>();
        compTable.put("0", "0101010");
        compTable.put("1", "0111111");
        compTable.put("-1", "0111010");
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
}

