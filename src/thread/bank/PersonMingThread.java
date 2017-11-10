package thread.bank;

/**
 * 线程 小明
 * Created by fanwei_last on 2017/11/9.
 */
public class PersonMingThread extends Thread{

    private String userName;
    Bank bank;

    public PersonMingThread(String userName, Bank bank){
        super(userName);
        this.userName = userName;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 200){
            synchronized (bank){//拥有bank锁之后才执行
                if (Bank.money >= 200){
                    bank.ATM(200, userName);
                }
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
