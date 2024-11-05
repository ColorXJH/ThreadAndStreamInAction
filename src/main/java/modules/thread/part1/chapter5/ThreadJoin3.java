package modules.thread.part1.chapter5;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 17:02
 */
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        Thread t1=new Thread(new CaptureRunnable("M1",10000L));
        Thread t2=new Thread(new CaptureRunnable("M2",30000L));
        Thread t3=new Thread(new CaptureRunnable("M3",15000L));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long endTime=System.currentTimeMillis();
        System.out.printf("save data begin is %s, end at %s.:",startTime,endTime);
    }
}
class CaptureRunnable implements Runnable{
    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName,long spendTime) {
        this.machineName = machineName;
        this.spendTime=spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName+"采集 finish..");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getResult(){
        return machineName+" finish.";
    }
}