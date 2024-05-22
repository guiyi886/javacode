package javaHigh.exp7.second;

import java.lang.annotation.*;

// 定义 ExceptionTest 注解，接受一个 Class 类型的参数，该参数是 Throwable 类及其子类
@Retention(RetentionPolicy.RUNTIME) // 指定该注解在运行时可通过反射机制访问
@Target(ElementType.METHOD) // 指定该注解只能用于方法上
@Repeatable(ExceptionTests.class)   // 允许该注解在同一个元素上使用多次，并且将多次使用的注解存储在 ExceptionTests 容器注解中。
public @interface ExceptionTest {
    Class<? extends Throwable> exception(); // 注解的一个属性，表示一个 Throwable 的子类（即异常类）
}
