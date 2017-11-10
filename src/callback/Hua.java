package callback;


/**
 * 小花
 * Created by fanwei_last on 2017/11/10.
 */
public class Hua {

    /**
     * 解决问题
     * @param callback
     * @param question
     */
    public void executeMessage(CallBack callback, String question){
        System.out.println("小明问的问题--->" + question);

        //模拟小花办自己的事情需要很长时间
        for(int i=0; i<10000;i++){

        }

        /**
         * 小花办完自己的事情之后想到了答案是2
         */
        String result = "答案是2";

        /**
         * 于是就打电话告诉小明，调用小明中的方法
         *
         */
        callback.answer(result);
    }
}
