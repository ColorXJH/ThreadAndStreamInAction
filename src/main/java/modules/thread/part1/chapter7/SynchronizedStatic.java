package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 16:10
 */
public class SynchronizedStatic {
    static{
        synchronized (SynchronizedStatic.class){
            System.out.println("static"+Thread.currentThread().getName());
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized static void m1(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void m2(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void m3(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
