package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 17:31
 */
public class ThreadWait {
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        /*Thread thread = new Thread(){
            public void run(){
                while(true){
                    synchronized(this){
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("Thread is interrupted"+isInterrupted());
                        }
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(100);
        System.out.println("thread is interrupted:"+thread.isInterrupted());
        thread.interrupt();
        System.out.println("thread is interrupted:"+thread.isInterrupted());

        Thread t2=new Thread(()->{
            while(true){
                synchronized(lock){
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Thread is interrupted"+Thread.interrupted());
                    }
                }
            }
        });
        t2.start();
        Thread.sleep(100);
        System.out.println("t2 is interrupted:"+thread.isInterrupted());
        t2.interrupt();
        System.out.println("t2 is interrupted:"+thread.isInterrupted());
*/
        final Thread t3=new Thread(()->{
                while(true){
                    if(Thread.interrupted()){
                        //Thread.currentThread().isInterrupted()
                        break;
                    }
                }
        });
        t3.start();
        Thread main=Thread.currentThread();
        Thread t4=new Thread(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t3.interrupt();//打断了但是并没有捕获或者正常退出
            //main.interrupt();
            System.out.println("t4 finish");
        });
        t4.start();
        try {
            t3.join();//当前线程（main）等待t3线程执行完毕,main线程被阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
