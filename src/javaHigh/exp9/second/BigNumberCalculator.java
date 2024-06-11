package javaHigh.exp9.second;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberCalculator {

    // 大整数加法
    public static BigInteger addBigIntegers(String num1, String num2) {
        BigInteger bigInt1 = new BigInteger(num1);
        BigInteger bigInt2 = new BigInteger(num2);
        return bigInt1.add(bigInt2);
    }

    // 大整数乘法
    public static BigInteger multiplyBigIntegers(String num1, String num2) {
        BigInteger bigInt1 = new BigInteger(num1);
        BigInteger bigInt2 = new BigInteger(num2);
        return bigInt1.multiply(bigInt2);
    }

    // 大整数除法
    public static BigDecimal divideBigIntegers(String num1, String num2) {
        BigDecimal bigDec1 = new BigDecimal(num1);
        BigDecimal bigDec2 = new BigDecimal(num2);
        if (bigDec2.equals(BigDecimal.ZERO)) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return bigDec1.divide(bigDec2);
    }

    // 大浮点数减法
    public static BigDecimal subtractBigDecimals(String num1, String num2) {
        BigDecimal bigDec1 = new BigDecimal(num1);
        BigDecimal bigDec2 = new BigDecimal(num2);
        return bigDec1.subtract(bigDec2);
    }

    // 大浮点数乘法
    public static BigDecimal multiplyBigDecimals(String num1, String num2) {
        BigDecimal bigDec1 = new BigDecimal(num1);
        BigDecimal bigDec2 = new BigDecimal(num2);
        return bigDec1.multiply(bigDec2);
    }

    public static void main(String[] args) {
        // 测试用例 1
        String num1 = "123456789123456789123456789";
        String num2 = "987654321987654321987654321";
        System.out.println("Test Case 1: " + num1 + " + " + num2 + " = " + addBigIntegers(num1, num2));

        // 测试用例 2
        num1 = "999999999999999999999999999999";
        num2 = "888888888888888888888888888888";
        System.out.println("Test Case 2: " + num1 + " * " + num2 + " = " + multiplyBigIntegers(num1, num2));

        // 测试用例 3
        num1 = "100000000000000000000000000000";
        num2 = "0";
        try {
            System.out.println("Test Case 3: " + num1 + " / " + num2 + " = " + divideBigIntegers(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Test Case 3: Division by zero is not allowed.");
        }

        // 测试用例 4
        String num3 = "1000.0001";
        String num4 = "999.9999";
        System.out.println("Test Case 4: " + num3 + " - " + num4 + " = " + subtractBigDecimals(num3, num4));

        // 测试用例 5
        num3 = "1234567.8910";
        num4 = "0.0001";
        System.out.println("Test Case 5: " + num3 + " * " + num4 + " = " + multiplyBigDecimals(num3, num4));
    }
}

