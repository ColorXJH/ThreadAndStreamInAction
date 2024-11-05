package modules.thread.part1.chapter8;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 16:39
 */
public class OtherService {
    private final Object lock = new Object();
    private DeadLock deadLock;

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void s1(){
           synchronized (lock){
               System.out.println("s1() called");
           }
    }
    public void s2(){
        synchronized (lock){
            System.out.println("s1() called");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deadLock.m2();
        }
    }
}
