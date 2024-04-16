package javaHigh.expOne.exp2;

/**
 * @author guiyi
 * @Date 2024/4/16 22:45:32
 * @ClassName javaHigh.expOne.exp2.DeviceFactory
 * @function -->
 */
public class DeviceFactory {
    public static SmartDevice createDevice(String type) {
        if (type.equalsIgnoreCase("SmartLight")) {
            return new SmartLight();
        } else if (type.equalsIgnoreCase("SmartDoor")) {
            return SmartDoor.getSmartDoor();
        }
        return null;
    }
}
