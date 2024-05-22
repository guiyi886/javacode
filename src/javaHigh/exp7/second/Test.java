package javaHigh.exp7.second;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        // 获取 Sample 类的 Class 对象
        Class<Sample> testClass = Sample.class;

        // 遍历 Sample 类中所有的方法
        for (Method m : testClass.getDeclaredMethods()) {

            // 检查方法是否被 @ExceptionTests 或 @ExceptionTest 注解标记
            if (m.isAnnotationPresent(ExceptionTests.class) || m.isAnnotationPresent(ExceptionTest.class)) {
                try {
                    // 设置方法为可访问
                    m.setAccessible(true);

                    // 调用方法
                    m.invoke(null);
                    passed++;

                } catch (Throwable wrappedExc) {
                    // 捕获方法执行过程中抛出的异常
                    Throwable exc = wrappedExc.getCause();
                    boolean passedTest = false;

                    // 如果方法被 @ExceptionTests 注解标记
                    if (m.isAnnotationPresent(ExceptionTests.class)) {
                        ExceptionTests exceptionTests = m.getAnnotation(ExceptionTests.class);

                        // 检查方法是否抛出了 @ExceptionTests 中定义的任何一个异常
                        for (ExceptionTest exceptionTest : exceptionTests.value()) {
                            if (exceptionTest.exception().isInstance(exc)) {
                                failed++;
                                passedTest = true;
                                break;
                            }
                        }

                        // 如果方法被单个 @ExceptionTest 注解标记
                    } else {
                        ExceptionTest exceptionTest = m.getAnnotation(ExceptionTest.class);

                        // 检查方法是否抛出了 @ExceptionTest 中定义的异常
                        if (exceptionTest.exception().isInstance(exc)) {
                            failed++;
                            passedTest = true;
                        }
                    }

                    // 如果抛出异常，打印
                    if (passedTest) {
                        System.out.printf("Test %s failed: %s %n", m.getName(), exc);
                    }
                }
            }
        }

        // 打印测试结果
        System.out.printf("Passed: %d, Failed: %d%n", passed, failed);
    }
}
