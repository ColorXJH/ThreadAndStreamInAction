package modules.thread.part1.chapter10;/**
 * @ClassName: SynchronizedProblem
 * @Package: modules.thread.part1.chapter10
 * @Description:
 * @Datetime: 2024-11-07 14:57
 * @author: ColorXJH
 */

/**
 * @description:
 * @author ColorXJH
 * @date 2024-11-07 14:57
 * @version 1.0
 */
public class SynchronizedProblem {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread("T1"){
            public void run(){
                SynchronizedProblem.run();
            }
        };
        t1.start();
        Thread.sleep(1000);
        Thread t2=new Thread("T2"){
            public void run(){
                SynchronizedProblem.run();
            }
        };
        t2.start();
        Thread.sleep(2000);
        //可以打断（设置这个中断标识，但是没有释放锁，结果是t2仍然无法执行）
        t2.interrupt();
        System.out.println("t2 is interrupted:"+t2.isInterrupted());
    }

    private synchronized static void run() {
        System.out.println(Thread.currentThread().getName());
        while (true){

        }
    }
}
