package modules.thread.part1.chapter4;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 15:57
 */
public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
               Thread inner=new Thread(()->{
                   try {
                       while (true){
                           System.out.println("do something for check");
                           Thread.sleep(1_000);
                       }
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               });
            inner.setDaemon(true);
            inner.start();
            try {
                Thread.sleep(1000);
                System.out.println("thread finish done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //t.setDaemon(true);
        t.start();
    }

}
