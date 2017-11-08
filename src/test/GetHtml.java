package test;

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
        String result = sendGet(url);

        System.out.println(result);
        //String imgSrc = regexString(result, "src=//(.+?) ");
        List<String> title = regexString(result, "question_link.+?>(.+?)<");

        System.out.println(title);
    }

    static String sendGet(String url){
        //定义字符串存储读取到的内容
        String result = "";
        //定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            //读入url
            URL realUrl = new URL(url);
            //初始化URL连接
            URLConnection connection = realUrl.openConnection();
            //开始连接
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            in = new BufferedReader(inputStreamReader);
            //临时保存每一行的数据
            String line = "";
            while ((line = in.readLine()) != null){
                ////遍历抓取到的每一行并将其存储到result里面
                result = result + line;
            }
        } catch (MalformedURLException e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    static List<String> regexString(String targetStr, String patternStr){
        List<String> result = new ArrayList<>();
        //定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        Pattern pattern = Pattern.compile(patternStr);
        // 定义一个matcher用来做匹配
        Matcher matcher = pattern.matcher(targetStr);
        // 如果找到了
        boolean isFind = matcher.find();
        while (isFind){
            result.add(matcher.group(1));
            isFind = matcher.find();
        }
        return result;
    }
}
