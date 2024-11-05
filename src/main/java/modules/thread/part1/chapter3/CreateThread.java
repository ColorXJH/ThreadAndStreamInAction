package modules.thread.part1.chapter3;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 创建线程的一些细节
 * @date 2024-11-04 10:10
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("CreateThread.run");
            }
        };
        t.start();
    }
    //1:创建线程对象thread,默认有一个线程名，以Thread-开头，从0开始计数
    //2:如果没有传入Runnable,或者没有复写Thread的run方法，该Thread不会调用任何东西，反之则会执行响应的逻辑单元
    //3:如果构造线程对象时未能传入ThreadGroup，则thread会默认获取父线程的ThreadGroup做为该线程的ThreadGroup，此时父子线程将会在同一个ThreadGroup
    //4:
}
