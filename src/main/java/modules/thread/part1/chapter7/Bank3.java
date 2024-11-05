package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 15:36
 */
public class Bank3 {
    public static void main(String[] args) {
        final SynchronizedRunnable runnable=new SynchronizedRunnable();
        Thread w1=new Thread(runnable,"一号窗口");
        Thread w2=new Thread(runnable,"二号窗口");
        Thread w3=new Thread(runnable,"三号窗口");
        w1.start();
        w2.start();
        w3.start();
    }
}
