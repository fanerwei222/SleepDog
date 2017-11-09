package bean;

import java.util.ArrayList;

/**
 * 知乎的bean类
 * Created by fanwei_last on 2017/11/8.
 */
public class ZhiHu {
    public String question; //问题
    public String zhihuUrl; //网页链接
    public String questionDescription; //问题描述
    public ArrayList<String> answers; //所有回答

    public ZhiHu(){
        this.question = "";
        this.zhihuUrl = "";
        this.questionDescription = "";
        this.answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getZhihuUrl() {
        return zhihuUrl;
    }

    public void setZhihuUrl(String zhihuUrl) {
        this.zhihuUrl = zhihuUrl;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    @Override
    public String toString() {
        return "ZhiHu{" +
                "question='" + question + '\'' +
                ", zhihuUrl='" + zhihuUrl + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", answers=" + answers +
                '}';
    }
}
