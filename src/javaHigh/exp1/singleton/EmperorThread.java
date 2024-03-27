package javaHigh.exp1.singleton;

/**
 * @author guiyi
 * @Date 2024/3/14 22:57:54
 * @ClassName javaHigh.exp1.singleton.EmperorThread
 * @function -->
 */
public class EmperorThread implements Runnable {
    @Override
    public void run() {
        Emperor emperor = Emperor.getEmperor();
        System.out.println(Thread.currentThread().getName() + ":" + emperor);
    }
}
