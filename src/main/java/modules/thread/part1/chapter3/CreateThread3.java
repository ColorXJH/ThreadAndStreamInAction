package modules.thread.part1.chapter3;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 11:26
 */
public class CreateThread3 {
    private int i=0;
    private byte[] bytes=new byte[1024];
    private static int counter=0;
    //jvm创建main线程
    public static void main(String[] args) {
        //创建一个虚拟机栈
        //创建局部变量
        int j=0;
        int[] arr=new int[1024];
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    //递归方法
    private static void add(int i){
        ++counter;
        add(i+1);
    }
}
