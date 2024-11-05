package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 17:17
 */
public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号：");
                        throw new RuntimeException("抛出打断异常");
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.isInterrupted());

        t1.interrupt();//这个线程中断了，但是程序并没有终止，因为你没有捕获到这个中断异常

        System.out.println(t1.isInterrupted());
    }
}
