package javaHigh.expOne.exp2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guiyi
 * @Date 2024/4/16 22:43:17
 * @ClassName javaHigh.expOne.exp2.SmartHomeSystem
 * @function -->
 */
// 定义智能家居系统类
public class SmartHomeSystem {
    private List<Component> components;

    public SmartHomeSystem() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void operateAll() {
        for (Component component : components) {
            component.function();
        }
    }
}

