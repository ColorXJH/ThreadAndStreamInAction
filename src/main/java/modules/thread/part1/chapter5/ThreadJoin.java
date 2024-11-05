package modules.thread.part1.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 16:45
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+"-->"+i));
        });
        Thread t2=new Thread(()->{
            IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+"-->"+i));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Optional.of("all of task finish done..").ifPresent(System.out::println);
        IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+"-->"+i));
    }
}
