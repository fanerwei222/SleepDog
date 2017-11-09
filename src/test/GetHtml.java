package test;

import bean.ZhiHu;
import utils.FileReaderWriter;
import utils.Spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
