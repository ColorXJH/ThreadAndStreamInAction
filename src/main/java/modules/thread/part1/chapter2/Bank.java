package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 银行大厅
 * @date 2024-11-01 16:26
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1=new TicketWindow("一号柜台");
        ticketWindow1.start();
        TicketWindow ticketWindow2=new TicketWindow("二号柜台");
        ticketWindow2.start();
        TicketWindow ticketWindow3=new TicketWindow("三号柜台");
        ticketWindow3.start();
    }
}
