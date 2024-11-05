package modules.thread.part1.chapter9;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 生产者消费者
 * @date 2024-11-05 17:06
 */
public class ProduceConsumerVersion1 {
    private int i=1;
    private final Object lock = new Object();
    private void produce() {
        synchronized (lock) {
            System.out.println("P->>"+(i++));
        }
    }
    private void consume() {
        synchronized (lock) {
            System.out.println("C->>"+i);
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 pc=new ProduceConsumerVersion1();;
        new Thread("Produce"){
            @Override
            public void run() {
                while(true){
                    pc.produce();
                }
            }
        }.start();
        new Thread("Consumer"){
            @Override
            public void run() {
               while (true){
                   pc.consume();
               }
            }
        }.start();
    }
}
