package javaLow.作业6.second;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guiyi
 * @Date 2023/12/29 16:10:51
 * @ClassName javaLow.作业6.second.CalculatorTest
 * @function -->
 */
public class CalculatorTest {
    javaLow.作业6.second.Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new javaLow.作业6.second.Calculator();
    }

    @AfterEach
    public void tearDown() {
        this.calculator = null;
    }

    @Test
    void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
    }

    @Test
    void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
    }
}
