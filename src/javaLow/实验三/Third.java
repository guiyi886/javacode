package javaLow.实验三;

import java.util.HashMap;
import java.util.Map;

public class Third {
    public static void main(String[] args) {
        // 定义菜单及其价格
        Map<String, Double> menu = new HashMap<>();
        menu.put("北京烤鸭", 199.1);
        menu.put("西芹炒肉", 11.8);
        menu.put("酸菜鱼", 59.1);
        menu.put("铁板牛柳", 32.1);

        // 计算总价格
        double total = calculateTotalPrice(menu);

        // 输出总价格
        System.out.println("菜单总价格为：" + total + "元");
    }

    // 计算菜单总价格的方法
    private static double calculateTotalPrice(Map<String, Double> menu) {
        double total = 0.0;

        // 遍历菜单，累加价格
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            total += entry.getValue();
        }

        return total;
    }
}

