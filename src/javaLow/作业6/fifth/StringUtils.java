package javaLow.作业6.fifth;

/**
 * @author guiyi
 * @Date 2023/12/29 16:45:39
 * @ClassName javaLow.作业6.fifth.StringUtils
 * @function -->
 */
public class StringUtils {
    public static String capitalize(String s) {
        if (s.length() == 0) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
