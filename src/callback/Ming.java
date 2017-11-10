package callback;

/**
 * 小明  ..实现回调接口
 * Created by fanwei_last on 2017/11/10.
 */
public class Ming implements CallBack{

    //引用小花
    private Hua hua;

    public Ming(Hua hua){
        this.hua = hua;
    }

    /**
     * 小明问问题
     * @param question
     */
    public void askQuestion(String question){
        System.out.println("小明先问问题");
        new Thread( () -> hua.executeMessage(Ming.this, question)).start();
        //hua.executeMessage(Ming.this, question);
        play();
    }

    /**
     * 玩耍
     */
    public void play(){
        System.out.println("小明先去玩~....");
    }

    /**
     * 小花算出答案就调用这个方法告诉小明答案
     * @param result
     */
    @Override
    public void answer(String result) {
        System.out.println("小花说答案是:" + result);
    }
}
