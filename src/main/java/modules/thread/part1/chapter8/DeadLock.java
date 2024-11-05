package modules.thread.part1.chapter8;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 16:38
 */
public class DeadLock {
    private final Object lock1 = new Object();
    private final OtherService otherService;
    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (lock1){
            System.out.println("DeadLock.m1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            otherService.s1();
        }
    }
    public void m2(){
         synchronized (lock1){
             System.out.println("DeadLock.m2");
         }
    }

}
