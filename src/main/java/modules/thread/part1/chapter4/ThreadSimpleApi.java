package modules.thread.part1.chapter4;

import java.util.Optional;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 16:16
 */
public class ThreadSimpleApi {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            Optional.of("hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1000_00);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1");
        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
