package javaLow.作业6.Third;


import javaLow.作业6.first.Factorial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author guiyi
 * @Date 2023/12/29 16:18:15
 * @ClassName javaLow.作业6.Third.TestNegative
 * @function -->
 */
public class TestNegative {
    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(-1);
            }
        });
    }
}
