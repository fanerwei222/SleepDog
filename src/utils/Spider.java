package utils;

import bean.ZhiHu;

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
 * Spider工具类
 * Created by fanwei_last on 2017/11/8.
 */
public class Spider {

    /**
     * get请求获取网页数据
     * @param url
     * @return
     */
    public static String sendGet(String url){
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

    /**
     * 正则匹配
     * @param targetStr
     * @param patternStr
     * @return
     */
    public static List<String> regexString(String targetStr, String patternStr){
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

    /**
     * 爬取知乎
     */
    public static ArrayList<ZhiHu> getZhiHu(String content){
        ArrayList<ZhiHu> result = new ArrayList<>();
        // 用来匹配标题
        Pattern questionPattern = Pattern.compile("question_link.+?>(.+?)<");
        Matcher questionMatcher = questionPattern.matcher(content);
        // 用来匹配url，也就是问题的链接
        Pattern urlPattern = Pattern.compile("question_link.+?href=\"(.+?)\"");
        Matcher urlMatcher = urlPattern.matcher(content);


        boolean isFind = questionMatcher.find() && urlMatcher.find();
        while (isFind){
            ZhiHu zhiHu = new ZhiHu();
            String questionUrl = "https://www.zhihu.com" + urlMatcher.group(1);
            zhiHu.setQuestion(questionMatcher.group(1));
            zhiHu.setZhihuUrl(questionUrl);

            String answer = sendGet(questionUrl);
            //描述
            Pattern descriptionPattern = Pattern.compile("<span.+?RichText.+?>(.*?)</span>");
            Matcher descriptionMatcher = descriptionPattern.matcher(answer);
            boolean desIsFind = descriptionMatcher.find();
            while (desIsFind){
                zhiHu.setQuestionDescription(descriptionMatcher.group(1));
                desIsFind = descriptionMatcher.find();
            }
            //回答
            Pattern answerPattern = Pattern.compile("<div.+?RichContent-inner.+?>(.*?)</div>");
            Matcher answerMatcher = answerPattern.matcher(answer);
            boolean answerIsFind =answerMatcher.find();
            ArrayList<String> answerList = new ArrayList<>();
            while (answerIsFind){
                answerList.add(answerMatcher.group(1));
                answerIsFind =answerMatcher.find();
            }
            zhiHu.setAnswers(answerList);
            result.add(zhiHu);
            isFind = questionMatcher.find() && urlMatcher.find();
        }

        return result;
    }
}
