import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("＜a href=\"index.html\"＞我的主页＜/a＞");
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
