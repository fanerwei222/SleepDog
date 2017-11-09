package thread.bank;

/**
 * 银行main类
 * Created by fanwei_last on 2017/11/9.
 */
public class Main {
    public static void main(String[] args){
        Bank bank = new Bank();
        PersonHuaThread personHuaThread = new PersonHuaThread("小花", bank);
        PersonMingThread personMingThread = new PersonMingThread("小明", bank);
        personHuaThread.start();
        personMingThread.start();

    }
}
