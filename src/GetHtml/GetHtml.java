package GetHtml;

import bean.ZhiHu;
import utils.FileReaderWriter;
import utils.Spider;

import java.util.ArrayList;

/**
 * 尝试获取HTML页面内容
 * Created by fanwei_last on 2017/11/8.
 */
public class GetHtml {
    public static void main(String[] args){
        //定义访问链接
        String url = "https://www.zhihu.com/explore/recommendations";
        //String url = "http://www.baidu.com";
        String result = Spider.sendGet(url);

        //System.out.println(result);
        //String imgSrc = regexString(result, "src=//(.+?) ");
        ArrayList<ZhiHu> zhiHus = Spider.getZhiHu(result);
        for (ZhiHu zhiHu : zhiHus){
            FileReaderWriter.writeToFile(zhiHu.writeString(),
                    "D:/software/OpenSource/BUG/file/知乎_编辑推荐", true);
        }
    }


}
