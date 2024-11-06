package modules.thread.part1.chapter9;/**
 * @ClassName: DifferenceOfWaitAndSleep
 * @Package: modules.thread.part1.chapter9
 * @Description:
 * @Datetime: 2024-11-06 13:40
 * @author: ColorXJH
 */

/**
 * @description:
 * @author ColorXJH
 * @date 2024-11-06 13:40
 * @version 1.0
 */
public class DifferenceOfWaitAndSleep
{
    private static final Object lock = new Object();
    public static void main(String[] args) {
        //m1();
        m2();
    }

    public static void m1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void m2(){
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//sleep和wait的一些区别
    //1:sleep是线程类的方法，wait是Object类的方法
    //2:sleep不会释放锁，wait会释放锁并讲线程加入锁的等待队列
    //3:sleep不依赖锁,调用wait需要依赖锁
    //4:sleep不需要唤醒，wait需要唤醒