package modules.thread.part1.chapter10;/**
 * @ClassName: BooleanLock
 * @Package: modules.thread.part1.chapter10
 * @Description:
 * @Datetime: 2024-11-07 13:40
 * @author: ColorXJH
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @description:
 * @author ColorXJH
 * @date 2024-11-07 13:40
 * @version 1.0
 */
public class BooleanLock implements Lock{
    private boolean initValue;
    private Collection<Thread> blockedThreads=new ArrayList<>();
    private Thread currentThread;
    public BooleanLock(){
        //false 状态表示空闲，可以抢锁，true表示锁已经被获得
        initValue = false;
    }
    @Override
    public synchronized void lock() throws InterruptedException {
        while(initValue){
            blockedThreads.add(Thread.currentThread());
            wait();
        }
        blockedThreads.remove(Thread.currentThread());
        initValue = true;
        //获取到锁时设置
        currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long timeout) throws InterruptedException, TimeOutException {
        if(timeout<=0){
            lock();
        }else{
            //等待时间
            long hasRemainingTime=timeout;
            //应该的结束时间
            long endTime=System.currentTimeMillis()+hasRemainingTime;
            //如果锁已经被占用，
            while(initValue){
                //在某个线程wait结束后，被唤醒后重新去查看这个锁标识（重新去竞争锁），如果很不幸没有竞争到
                //这个标识再次被别人至成了true（被另一个线程抢到了锁），那么这个线程还需要等待，但是在等待之前需要判断是否超时
                if(hasRemainingTime<=0){
                    //如果小于等于0表示当前时间已经过了我的endTime
                    throw new TimeOutException("Time Out");
                }
                //进入等待队列
                blockedThreads.add(Thread.currentThread());
                //等待
                wait(timeout);
                //如果有人通知这个线程（wait被唤醒之后），重新计算有没有超时
                hasRemainingTime=endTime-System.currentTimeMillis();
                System.out.println("hasRemainingTime: "+hasRemainingTime);
            }

            //如果抢到了锁，设置标志
            initValue = true;
            //同时设置当前线程
            currentThread = Thread.currentThread();
        }
    }

    @Override
    public synchronized void unlock() {
        //释放锁的时候只能由加锁的线程释放
        if(Thread.currentThread()==currentThread){
            initValue = false;
            System.out.println(Thread.currentThread()+"release the look monitor(BooleanLock instance)");
            notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThreads() {
        //方式外部方法对改返回引用修改
        return Collections.unmodifiableCollection(blockedThreads);
    }

    @Override
    public int getBlockedThreadCount() {
        return blockedThreads.size();
    }
}
