package javaHigh.exp4.first;

/**
 * @author guiyi
 * @Date 2024/4/28 下午7:15:38
 * @ClassName javaHigh.exp4.first.SmartDevice
 * @function -->
 */
public interface SmartDevice extends Powerable, Controllable {
    void connectToWiFi(String wifiName);
}
