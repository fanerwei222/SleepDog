package thread.ticket;

/**
 * 卖票
 * Created by fanwei_last on 2017/11/9.
 */
public class SaleTicketThread implements Runnable{

    //票数30
    public static int tick = 30;

    //随便定义一个对象,用于同步锁
    private Object synOb = "";

    @Override
    public void run() {
        while (tick > 0){
            synchronized (synOb){//获取synob的对象锁,这里如果用this的话是没法保证数据是同步的
                if (tick > 0){
                    System.out.println( "卖出了第" + tick + "张票");
                    tick--;
                }else {
                    System.out.println( "余票不足!");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
