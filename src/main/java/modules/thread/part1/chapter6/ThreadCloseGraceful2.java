package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 如何优雅的关闭线程2：打断的方式
 * @date 2024-11-05 11:25
 */
public class ThreadCloseGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    System.out.println("Worker 线程被打断了");
                    break;
                }
            }
        }

    }
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        worker.interrupt();
    }
}
