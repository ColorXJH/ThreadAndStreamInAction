package modules.thread.part1.chapter10;/**
 * @ClassName: Lock
 * @Package: modules.thread.part1.chapter10
 * @Description:
 * @Datetime: 2024-11-07 11:38
 * @author: ColorXJH
 */

import java.util.Collection;

/**
 * @description:
 * @author ColorXJH
 * @date 2024-11-07 11:38
 * @version 1.0
 */
public interface Lock {

    class TimeOutException extends Exception {
        public TimeOutException(String message) {
            super(message);
        }
    }
    void lock() throws InterruptedException;
    void lock(long timeout) throws InterruptedException,TimeOutException;
    void unlock();
    Collection<Thread>getBlockedThreads();
    int getBlockedThreadCount();
}
