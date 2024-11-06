package modules.thread.part1.chapter9;/**
 * @ClassName: CaptureService
 * @Package: modules.thread.part1.chapter9
 * @Description:
 * @Datetime: 2024-11-06 16:07
 * @author: ColorXJH
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @description: 调度采集任务，统一结束时间，1000台主机，每次只有3个线程在运行采集，如何实现
 * @author ColorXJH
 * @date 2024-11-06 16:07
 * @version 1.0
 */
public class CaptureService {
    private static LinkedList<Control>controls = new LinkedList<Control>();
    private static final int MAX_WORKER=10;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Thread> workers=new ArrayList<Thread>();
        IntStream.range(0,1000).mapToObj(String::valueOf)
        //Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10","M11","M12","M13","M14","M15").stream()
                //函数推导的方式
                .map(CaptureService::createCaptureThread)
                .forEach(t->{
                    t.start();
                    workers.add(t);
                });
        workers.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.currentTimeMillis();
        Optional.of("all of capture workers finished").ifPresent(System.out::println);
        System.out.println("all_time is :"+(endTime-startTime)/1000+"秒");

    }



    private static Thread createCaptureThread(String name) {
        return new Thread(()->{
            Optional.of("the worker["+Thread.currentThread().getName()+"] try to running").ifPresent(System.out::println);
            //线程进入判断
            synchronized (controls) {
                while (controls.size()>MAX_WORKER) {
                    try {
                        //等待时释放锁，没有上下文切换
                        controls.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                controls.addLast(new Control());
            }

            Optional.of("the worker["+Thread.currentThread().getName()+"] is running").ifPresent(System.out::println);
            try {
                //模拟采集时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //做完工作了，唤醒其他线程
            synchronized (controls) {
                Optional.of("the worker["+Thread.currentThread().getName()+"] finished work").ifPresent(System.out::println);
                //先进先出
                controls.removeFirst();
                //唤醒等带的其他线程
                controls.notifyAll();
            }



        },name);
    }

    private static class Control{

    }
}
