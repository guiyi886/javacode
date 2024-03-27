package javaLow.作业6.first;

/**
 * @author guiyi
 * @Date 2023/12/29 15:56:31
 * @ClassName javaLow.作业6.first.Factorial
 * @function -->
 */
public class Factorial {
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
