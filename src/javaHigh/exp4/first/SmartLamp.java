package javaHigh.exp4.first;

/**
 * @author guiyi
 * @Date 2024/4/28 下午7:18:32
 * @ClassName javaHigh.exp4.first.SmartLamp
 * @function -->
 */
public class SmartLamp implements SmartDevice {
    private int num = 50;

    @Override
    public void connectToWiFi(String wifiName) {
        System.out.println("连接到wifi: " + wifiName);
    }

    @Override
    public void turnOn() {
        System.out.println("打开设备");
    }

    @Override
    public void turnOff() {
        System.out.println("关闭设备");
    }

    @Override
    public void charge(int num) {
        this.num += num;
        if (num > 100) {
            this.num = 100;
        }
        System.out.println("充电至: " + num);
    }
}
