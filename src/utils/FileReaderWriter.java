package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件读写工具类
 * Created by fanwei_last on 2017/11/9.
 */
public class FileReaderWriter {

    /**
     * 创建文件
     * @param filePath
     * @return
     */
    public static boolean createNewFile(String filePath){
        boolean isSuccess = false;
        //如有则将"\\"转为"/",没有则不产生任何变化
        String filePathTurn = filePath.replace("\\\\", "/");
        //先过滤掉文件名
        int index = filePathTurn.lastIndexOf("/");
        String dir = filePathTurn.substring(0, index);
        //创建文件夹
        File fileDir = new File(dir);
        if (!fileDir.exists()){
            isSuccess = fileDir.mkdirs();
        }
        //创建文件
        File file = new File(filePathTurn);
        try {
            isSuccess = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    /**
     * 把数据写入到文件里头
     * @param content
     * @param filePath
     * @return
     */
    public static boolean writeToFile(String content, String filePath, boolean isAppend){
        boolean isSuccess = false;
        //先过滤掉文件名
        int index = filePath.lastIndexOf("/");
        String dir = filePath.substring(0, index);
        //创建文件夹
        File fileDir = new File(dir);
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        // 再创建路径下的文件
        File file = null;
        try {
            file = new File(filePath);
            file.createNewFile();
        } catch (IOException e) {
            isSuccess = false;
            e.printStackTrace();
        }
        //写入文件
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, isAppend);
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            isSuccess = false;
            e.printStackTrace();
        } finally {
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }
}
