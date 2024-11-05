package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 叫号窗口
 * @date 2024-11-01 16:26
 */
public class TicketWindow extends Thread{
    private final int MAX=50;
    private final String name;
    private static int index=1;

    public TicketWindow(String name){
        this.name=name;
    }

    @Override
    public void run() {
        while (index<=MAX){
            System.out.println("柜台："+name+" 当前的号码是："+(index++));
        }
    }
}
