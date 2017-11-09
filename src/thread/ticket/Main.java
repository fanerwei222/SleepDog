package thread.ticket;

/**
 * Created by fanwei_last on 2017/11/9.
 */
public class Main {
    public static void main(String[] args){
        SaleTicketThread thread1 = new SaleTicketThread();//new三个站台卖票
        SaleTicketThread thread2 = new SaleTicketThread();
        SaleTicketThread thread3 = new SaleTicketThread();

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
