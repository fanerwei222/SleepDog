package thread.kfc;

/**
 * 消费者
 * Created by fanwei_last on 2017/11/10.
 */
public class Customers extends Thread {

    KFC kfc ;

    public Customers(KFC kfc){
        this.kfc = kfc;
    }

    @Override
    public void run() {
        int size = (int) (Math.random()*5);//每次要消费的食物的数量
        while (true){
            kfc.consu(size);
        }
    }
}
