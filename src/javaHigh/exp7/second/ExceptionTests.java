package javaHigh.exp7.second;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义 ExceptionTests 注解，包含一个 ExceptionTest 数组
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTests {
    ExceptionTest[] value();    // 容器注解必须包含一个 value 方法
}
