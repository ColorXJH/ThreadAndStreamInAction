package modules.thread.part1.chapter9;/**
 * @ClassName: MyService
 * @Package: modules.thread.part1.chapter9
 * @Description:
 * @Datetime: 2024/11/6 19:07
 * @author: ColorXJH
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @description: 自己思考的如何控制线程数来消费线程
 * @author ColorXJH
 * @date 2024/11/6 19:07
 * @version 1.0
 */
public class MyService {
    private static int THREAD_NUM=1000;
    private static int TASK_NUM=10;
    public static void main(String[] args) {
        System.out.println("start the plan...");
        long startTime = System.currentTimeMillis();
        //定义任务队列
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        //添加1000个可执行单元到队列
        IntStream.range(1,THREAD_NUM).forEach(i->{
            System.out.println("ready to add collection");
            try {
                queue.put(new Worker());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //启动10个消费者线程处理任务
        IntStream.range(1, TASK_NUM).forEach(i -> {
            Thread thread=new Thread(new Task(queue),"Consumer "+i);
            thread.start();
        });
        //等待分线程执行完毕
        while(!queue.isEmpty()){
        }
        //下面这种写法有问题
        /*while(queue.isEmpty()){
            break;
        }*/

        long endTime = System.currentTimeMillis();
        System.out.println("the total time is : "+(endTime-startTime)/1000+"秒");
        System.out.println("end the plan...");

    }

}
//消费者线程
class Task implements Runnable {
    private final BlockingQueue<Runnable> queue;

    Task(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
                System.out.println(Thread.currentThread().getName()+" handle worker");
                Runnable take = queue.poll();
                if(take!=null){
                    take.run();
                }else{
                    System.out.println(Thread.currentThread().getName()+" has no worker to run");
                    break;
                }
        }
    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start to work");
        try {
            //模拟每个任务要执行的事情耗时
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}