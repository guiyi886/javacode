package javaHigh.expOne.exp2;

/**
 * @author guiyi
 * @Date 2024/4/16 22:36:58
 * @ClassName javaHigh.expOne.exp2.SmartDoor
 * @function -->
 */
public class SmartDoor extends SmartDevice {
    private static SmartDoor SMARTDOOR;

    private SmartDoor() {
    }

    public static SmartDoor getSmartDoor() {
        if (SMARTDOOR == null) {
            synchronized (SmartDoor.class) {
                if (SMARTDOOR == null) {
                    SMARTDOOR = new SmartDoor();
                }
            }
        }
        return SMARTDOOR;
    }

    @Override
    public void function() {
        System.out.println("SmartDoor->function⻔的开关控制");
    }
}
