package javaHigh.exp4.first;

/**
 * @author guiyi
 * @Date 2024/4/29 下午3:57:00
 * @ClassName javaHigh.exp4.first.Test
 * @function -->
 */
public class Test {
    public static void main(String[] args) {
        SmartLamp smartLamp = new SmartLamp();
        smartLamp.turnOff();
        smartLamp.turnOn();
        smartLamp.charge(25);
        smartLamp.connectToWiFi("myWifi");
    }
}
