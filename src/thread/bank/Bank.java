package thread.bank;

/**
 * 银行类
 * Created by fanwei_last on 2017/11/9.
 */
public class Bank {

    //账户里头有5000块钱
    public static int money = 5000;

    /**
     * 柜台取钱方法
     * @param money
     * @param userName
     */
    public void Counter(int money, String userName){
        Bank.money = Bank.money - money;
        System.out.println(userName + "取走了" + money + "块钱,还剩下 " + Bank.money + "块钱");
    }

    /**
     * ATM取钱方法
     * @param money
     * @param userName
     */
    public void ATM(int money, String userName){
        Bank.money = Bank.money - money;
        System.out.println(userName + "取走了" + money + "块钱,还剩下 " + Bank.money + "块钱");
    }
}
