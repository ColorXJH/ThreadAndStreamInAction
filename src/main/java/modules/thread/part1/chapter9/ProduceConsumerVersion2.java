package modules.thread.part1.chapter9;

import java.util.stream.Stream;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 改进版
 * @date 2024-11-05 17:13
 */
public class ProduceConsumerVersion2 {
    public static void main(String[] args) {
        ProduceConsumerVersion2 pc=new ProduceConsumerVersion2();
        Stream.of("P1","P2").forEach(n->
                new Thread("Produce"){
                    @Override
                    public void run() {
                        while(true){
                            pc.produce();
                        }
                    }
                }.start()
        );
        Stream.of("C1","C2").forEach(n->
                new Thread("Consumer"){
                    @Override
                    public void run() {
                        while (true){
                            pc.consume();
                        }
                    }
                }.start()
        );
    }
    private int i=0;
    private final Object lock = new Object();
    private volatile boolean isProduced = false;//是否已经生产
    private void produce() {
        synchronized (lock) {
                if(isProduced) {//已经生产
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    i++;
                    System.out.println("P--》》"+i);
                    isProduced = true;
                    lock.notifyAll();//通知消费者消费
                }
        }
    }
    private void consume() {
        synchronized (lock) {
                if(isProduced) {//已经生产 需要消费
                    System.out.println("C-->>"+i);
                    isProduced=false;
                    lock.notifyAll();//通知生产者生产
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }
}
