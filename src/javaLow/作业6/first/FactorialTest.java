package javaLow.作业6.first;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guiyi
 * @Date 2023/12/29 15:56:53
 * @ClassName javaLow.作业6.first.FactorialTest
 * @function -->
 */
public class FactorialTest {

    @Test
    public void testFactorial() {
        assertEquals(javaLow.作业6.first.Factorial.fact(0), 1);
        assertEquals(javaLow.作业6.first.Factorial.fact(2), 666);
        assertEquals(javaLow.作业6.first.Factorial.fact(3), 666);
        assertEquals(javaLow.作业6.first.Factorial.fact(10), 3628800);
        assertEquals(javaLow.作业6.first.Factorial.fact(20), 2432902008176640000L);
    }
}

