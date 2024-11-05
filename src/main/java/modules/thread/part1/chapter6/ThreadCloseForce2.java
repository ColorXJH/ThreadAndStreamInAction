package modules.thread.part1.chapter6;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-05 12:34
 */
public class ThreadCloseForce2 {

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start=System.currentTimeMillis();
        service.execute(()->{
            //模拟这边去加载一个非常中的耗时的资源（假设需要半小时搞定，但是实际上1小时才完成）
            /*while(true){

            }*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown(10000);
        long end=System.currentTimeMillis();
        System.out.println("最终耗时："+(end-start));

    }
}
