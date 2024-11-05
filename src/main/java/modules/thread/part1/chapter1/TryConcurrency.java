package modules.thread.part1.chapter1;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-10-31 16:12
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread("my task"){
            @Override
            public void run() {
                readFromDatabase();
            }

            @Override
            public synchronized void start() {
                System.out.println("嘿嘿 我重写了模板方法，并不能启动新的线程");
            }
        }.start();
        writeDataToFile();
    }
    private static void readFromDatabase(){
        try {
            System.out.println("begin read from db");
            Thread.sleep(10*1000);
            System.out.println("read done and start handle it");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("the data handle finish and successfully");
    }

    private static void writeDataToFile(){
        try {
            System.out.println("begin write date to file");
            Thread.sleep(10*2000);
            System.out.println("write data to file finish and start handle it");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("the write data to file  finish and successfully");
    }

}
