package javaHigh.expOne.exp2;

/**
 * @author guiyi
 * @Date 2024/4/16 22:34:51
 * @ClassName javaHigh.expOne.exp2.SmartDevice
 * @function -->
 */
public abstract class SmartDevice implements Component {
    private boolean deviceStatus;

    public void toggleStatus() {
        deviceStatus = !deviceStatus;
    }
}
