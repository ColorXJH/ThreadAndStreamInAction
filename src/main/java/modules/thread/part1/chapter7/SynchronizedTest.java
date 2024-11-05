package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 14:26
 */
public class SynchronizedTest {
    private final static Object lock = new Object();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                synchronized (lock){
                    try {
                        Thread.sleep(300_000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();


    }

}
