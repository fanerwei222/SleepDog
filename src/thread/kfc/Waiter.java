package thread.kfc;

/**
 * 服务员类
 * Created by fanwei_last on 2017/11/10.
 */
public class Waiter extends Thread {

    KFC kfc;

    public Waiter(KFC kfc){
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size=(int)(Math.random()*5)+5;//每次生产的数量
        while (true) {
            kfc.prod(size);//传入每次生产的数量
        }
    }
}
