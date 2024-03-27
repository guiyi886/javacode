package javaHigh.exp1.singleton;

/**
 * @author guiyi
 * @Date 2024/3/14 22:23:54
 * @ClassName javaHigh.exp1.singleton.Emperor
 * @function -->
 */
public class Emperor {

    // private static final Emperor EMPEROR = new Emperor();

    // volatile保证线程间修改可见，但还是不保证原子性
    private static volatile Emperor EMPEROR;

    private Emperor() {
    }

    public static Emperor getEmperor() {
        if (EMPEROR == null) {
            synchronized (Emperor.class) {
                if (EMPEROR == null) {
                    EMPEROR = new Emperor();
                }
            }
        }
        return EMPEROR;
    }

    public static void main(String[] args) {
        Emperor emperor1 = Emperor.getEmperor();
        Emperor emperor2 = Emperor.getEmperor();

        // 直接输出对象是调用toString方法（默认是类名+十进制的哈希值）
        // hashCode方法输出的是十六进制的哈希值
        System.out.println(emperor1);
        System.out.println(emperor2);
        System.out.println(emperor1 == emperor2 ? "相同\n" : "不同\n");

        Thread thread1 = new Thread(new EmperorThread());
        Thread thread2 = new Thread(new EmperorThread());

        thread1.start();
        thread2.start();
    }
}
