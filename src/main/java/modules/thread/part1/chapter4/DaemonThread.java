package modules.thread.part1.chapter4;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 守护线程
 * @date 2024-11-04 15:13
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());//Thread-0
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t.setDaemon(true);
        //守护线程会随着主线程结束而结束
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());//main线程
    }
}
