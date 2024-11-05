package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 强制
 * @date 2024-11-05 11:31
 */
public class ThreadCloseForce {
    private static class Worker extends Thread {
        private volatile boolean flag = true;
        @Override
        public void run() {
            while(flag){
                //读文件的时候block住了，没有机会打断他，没办法监听到你的中断信号,
                //即使有shutdown方法或者其他方法改变这个变量值，线程没有机会去判断执行，被IO流阻塞住了
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
