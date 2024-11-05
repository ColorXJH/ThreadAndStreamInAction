package modules.thread.part1.chapter7;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 15:35
 */
public class SynchronizedRunnable implements Runnable {
    //真正意义上得共享数据 需要操作修改的
    private int index=1;
    //只读得共享数据
    private static final int MAX=500;
    private final Object lock=new Object();

    @Override
    public void run() {
        while (true){
             if(ticket()){
                 break;
             }
        }
    }

    private synchronized boolean ticket(){
        if(index>MAX){return true;}
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //1: getField index
        //2: index=index+1
        //3: putField index
        System.out.println(Thread.currentThread()+"的号码是："+(index++));
        return false;
    }
}
