package javaHigh.expOne.exp2;

/**
 * @author guiyi
 * @Date 2024/4/16 22:48:48
 * @ClassName javaHigh.expOne.exp2.SmartTest
 * @function -->
 */
public class SmartTest {
    public static void main(String[] args) {
        // 创建智能家居系统
        SmartHomeSystem smartHomeSystem = new SmartHomeSystem();

        // 添加智能设备
        smartHomeSystem.addComponent(DeviceFactory.createDevice("SmartLight"));
        smartHomeSystem.addComponent(DeviceFactory.createDevice("SmartDoor"));

        // 操作所有设备
        smartHomeSystem.operateAll();
    }
}
