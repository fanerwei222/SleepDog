package thread.race;

/**
 * 兔子线程类
 * Created by fanwei_last on 2017/11/10.
 */
public class Rabbit implements Animal, Runnable{

    @Override
    public void running() {
        System.out.println("兔子在跑, 速度为"+ StaticField.rabbitDis + "m/s, 还剩下" + StaticField.length +"米");
    }

    @Override
    public void run() {
        while (StaticField.length > 0){
            synchronized (StaticField.class){
                if (StaticField.length > 0){
                    StaticField.length -= StaticField.rabbitDis;
                    this.running();
                    if (StaticField.length <= 0){
                        StaticField.length = 0;
                        System.out.println("兔子获得了胜利");
                    }
                }
            }
        }
    }
}
