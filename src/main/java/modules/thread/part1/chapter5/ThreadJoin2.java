package modules.thread.part1.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 16:45
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            try {
                System.out.println("t1 is running");
                Thread.sleep(10_000);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t1.join(100);
        Optional.of("all of task finish done..").ifPresent(System.out::println);
        IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+"-->"+i));
        //当前线程（main）等待main线程结束，永远不会结束（自己在等自己结束）
        Thread.currentThread().join();
    }
}
