package thread.bank;

/**
 * 线程  小花
 * Created by fanwei_last on 2017/11/9.
 */
public class PersonHuaThread extends Thread{

    private String userName;
    Bank bank;

    public PersonHuaThread(String userName, Bank bank){
        super(userName);
        this.userName = userName;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100){
            synchronized (bank){//拥有bank锁之后才执行
                if (Bank.money >= 100){
                    bank.Counter(100, userName);
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
