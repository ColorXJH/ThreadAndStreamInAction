package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 如何优雅的关闭线程 1:设置开关的方式
 * @date 2024-11-05 11:19
 */
public class ThreadCloseGraceful {
    private static class Worker extends Thread {
        private volatile boolean start=true;
        @Override
        public void run() {
            while(start) {
                //
            }
        }
        public void shutdown() {
            this.start=false;
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
        worker.shutdown();
    }
}
