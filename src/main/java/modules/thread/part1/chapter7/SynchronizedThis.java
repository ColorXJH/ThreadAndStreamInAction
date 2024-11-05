package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 15:58
 */
public class SynchronizedThis {
    private final Object lock = new Object();
    public static void main(String[] args) {
        ThisLock thisLock=new SynchronizedThis().new ThisLock();
        new Thread("t1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();
        new Thread("t2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();

    }
    class ThisLock{
        public synchronized void m1(){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        public  void m2(){
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
