package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-01 17:21
 */
public class Bank2 {
    public static void main(String[] args) {
        final TicketWindowRunnable runnable=new TicketWindowRunnable();
        Thread w1=new Thread(runnable,"一号窗口");
        Thread w2=new Thread(runnable,"二号窗口");
        Thread w3=new Thread(runnable,"三号窗口");
        w1.start();
        w2.start();
        w3.start();
    }
}
