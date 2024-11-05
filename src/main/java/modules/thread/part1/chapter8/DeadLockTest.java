package modules.thread.part1.chapter8;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 16:51
 */
public class DeadLockTest {
    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock=new DeadLock(otherService);
        otherService.setDeadLock(deadLock);
        new Thread("T1"){
            @Override
            public void run() {
                deadLock.m1();
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run() {
                otherService.s2();
            }
        }.start();
        System.out.println("DeadLockTest.main finished but two thread have been dead locked");

    }
}
