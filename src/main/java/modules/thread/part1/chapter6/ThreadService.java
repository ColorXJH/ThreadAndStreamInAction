package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 11:39
 */
public class ThreadService {
    private Thread executeThread;
    private volatile boolean finished = false;
    //可以某一个线程定义为守护线程，如果执行线程退出了，那么守护线程也就退出了,比如我们有一个任务想着30分钟执行完毕
    //但是在实际过程中，由于网络IO的异常一个多小时才执行完毕，对于超过30分钟的情况我们可以判定为失败，所以可以直接结束线程
    public void execute(Runnable task) {
        executeThread=new Thread(){
            @Override
            public void run() {
                //创建一个守护线程
                Thread runner=new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished=true;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime=System.currentTimeMillis();
        while (!finished) {
            if(System.currentTimeMillis()-currentTime>=mills) {
                System.out.println("任务超时，需要结束它");
                executeThread.interrupt();
                break;
            }
            //既没有超时也没有执行结束，短暂的休眠一下
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
        finished=false;
    }
}
