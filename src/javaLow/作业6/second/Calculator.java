package javaLow.作业6.second;

/**
 * @author guiyi
 * @Date 2023/12/29 16:10:39
 * @ClassName javaLow.作业6.second.Calculator
 * @function -->
 */
public class Calculator {
    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
}
