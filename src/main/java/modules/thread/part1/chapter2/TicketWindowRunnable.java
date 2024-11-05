package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 将可执行的逻辑单元和线程控制分离开来  ——》设计模式：策略模式
 * @date 2024-11-01 17:18
 */
public class TicketWindowRunnable implements Runnable{
    private int index=1;
    private static final int MAX=50;
    @Override
    public void run() {
        while (index<=MAX){
            System.out.println(Thread.currentThread()+"的号码是："+(index++));
        }
    }
}
