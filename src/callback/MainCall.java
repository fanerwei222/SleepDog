package callback;

/**
 * 回调  main 类  小明有问题要问小花..然后小花先自己想想..想好了再告诉小明
 * Created by fanwei_last on 2017/11/10.
 */
public class MainCall {
    public static void main(String[] args){
        Hua hua = new Hua();
        Ming ming = new Ming(hua);
        ming.askQuestion("1 + 1 等于多少呀?");

    }
}
