package thread.race;

/**
 * Created by fanwei_last on 2017/11/10.
 */
public class Tortoise implements Animal, Runnable {

    @Override
    public void run() {
        while (StaticField.length > 0){
            synchronized (StaticField.class){
                if (StaticField.length > 0){
                    StaticField.length -= StaticField.tortoiseDis;
                    this.running();
                    if (StaticField.length <= 0){
                        StaticField.length = 0;
                        System.out.println("乌龟获得了胜利");
                    }
                }
            }
        }
    }

    @Override
    public void running() {
        System.out.println("乌龟在跑, 速度为"+ StaticField.tortoiseDis + "m/s, 还剩下" + StaticField.length +"米");
    }
}
