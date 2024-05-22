package javaHigh.exp7.second;

import java.util.Random;

public class Sample {
    // 如果@ExceptionTest的方法名为value则可以用@ExceptionTest(ArrayIndexOutOfBoundsException.class)
    @ExceptionTest(exception = ArrayIndexOutOfBoundsException.class)
    public static void m1() {
        int[] array = new int[0];
        int i = array[1];
    }

    @ExceptionTest(exception = ArithmeticException.class)
    public static void m2() {
        int i = 0;
        int j = 1 / i;
    }

    @ExceptionTest(exception = NullPointerException.class)
    public static void m3() {
        String s = null;
        int length = s.length();
    }

    @ExceptionTests({
            @ExceptionTest(exception = ArrayIndexOutOfBoundsException.class),
            @ExceptionTest(exception = NullPointerException.class)
    })
    public static void m4() {
        Random rand = new Random();
        int randNum = rand.nextInt(101);
        if (randNum % 2 == 0) {
            m1();
        } else {
            m3();
        }
    }
}

