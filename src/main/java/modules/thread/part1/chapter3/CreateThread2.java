package modules.thread.part1.chapter3;

import java.util.Arrays;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 10:38
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t=new Thread();
        t.start();
        //System.out.println(t.getThreadGroup().getName());
        //System.out.println(Thread.currentThread().getName());
        //System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        Thread[] threads=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        Arrays.stream(threads).forEach(System.out::println);
    }
}
