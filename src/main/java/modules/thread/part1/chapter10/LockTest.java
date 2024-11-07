package modules.thread.part1.chapter10;/**
 * @ClassName: LockTest
 * @Package: modules.thread.part1.chapter10
 * @Description:
 * @Datetime: 2024-11-07 14:38
 * @author: ColorXJH
 */

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @description:
 * @author ColorXJH
 * @date 2024-11-07 14:38
 * @version 1.0
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1","T2","T3","T4").forEach(name->new Thread(()->{
                    try {
                        //booleanLock.lock();
                        booleanLock.lock(5000);
                        Optional.of(Thread.currentThread().getName()+" hava the lock monitor.").ifPresent(System.out::println);
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Lock.TimeOutException e) {
                        System.out.println(Thread.currentThread().getName()+" time out");
                    } finally {
                        booleanLock.unlock();
                    }
                },name).start()
        );
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName()+" is working...").ifPresent(System.out::println);
        Thread.sleep(1000);
    }
}
