package javaLow.作业6.fifth;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guiyi
 * @Date 2023/12/29 16:45:50
 * @ClassName javaLow.作业6.fifth.StringUtilsTest
 * @function -->
 */
public class StringUtilsTest {
    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String result) {
        assertEquals(result, javaLow.作业6.fifth.StringUtils.capitalize(input));
    }

    static List<Arguments> testCapitalize() {
        return List.of( // arguments:
                Arguments.of("abc", "Abc"), //
                Arguments.of("APPLE", "Apple"), //
                Arguments.of("gooD", "Good"));
    }
}
