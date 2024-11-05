package modules.thread.part1.chapter3;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 14:42
 */
public class CreateThread5 {
    private static int counter=1;
    public static void main(String[] args) {
        try {
            for(int i=0;i<Integer.MAX_VALUE;i++){
                counter++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }

        } catch (Error e) {

        }
        System.out.println("total create thread nums=> "+counter);
    }
}
