package javaHigh.exp10.first;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ReflectiveListCreator {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: No class name provided.");
            return;
        }

        String className = args[0];
        try {
            // 使用反射机制创建 List 实例
            Class<?> clazz = Class.forName(className);
            if (!List.class.isAssignableFrom(clazz)) {
                System.out.println("Error: The provided class is not a List.");
                return;
            }

            List<String> list = (List<String>) clazz.getDeclaredConstructor().newInstance();

            // 添加命令行提供的其他参数到列表中
            for (int i = 1; i < args.length; i++) {
                list.add(args[i]);
            }

            // 输出列表内容
            System.out.println("List contents: " + list);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 IllegalArgumentException | InvocationTargetException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}

