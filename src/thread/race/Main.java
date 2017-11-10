package thread.race;

/**
 * 龟兔赛跑(错误的例子..请勿参考...留着以后修改)
 * Created by fanwei_last on 2017/11/10.
 */
public class Main {
    public static void main(String[] args){

        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();

        LetOneStop rabbitStop = new LetOneStop(rabbit);
        LetOneStop tortoiseStop = new LetOneStop(tortoise);

        new Thread(rabbit).start();
        new Thread(tortoise).start();

        //rabbitStop.win();
        //tortoiseStop.win();

    }
}
