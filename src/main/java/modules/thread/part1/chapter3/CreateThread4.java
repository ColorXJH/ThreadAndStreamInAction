package modules.thread.part1.chapter3;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 14:16
 */
public class CreateThread4 {
    private static int counter=1;
    public static void main(String[] args) {
        Thread t1=new Thread(null,new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }
            private void add(int i){
                ++counter;
                add(i+1);
            }
        },"test",1<<5);
        t1.start();
    }
}
