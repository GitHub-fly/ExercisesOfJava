package exercises.IO;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xunmi
 * @ClassName IORandom
 * @Description TODO
 * @Date 2020/1/17
 * @Version 1.0
 **/
public class IORandom {

    public static void main(String[] args) {
        RandomAccessFile ras = null;
        String data = null;
        try {
            /**
             * 该流的第二个参数 可选值： "r" ---> 只读模式
             *                         "w" ---> 只写模式
             *                         "rw" --> 读写模式
             *                         "rws" -> 读写模式
             */
            ras = new RandomAccessFile("F:\\Idea_Java\\homework\\data.txt", "r");
            while ((data = ras.readLine()) != null) {
                if (data.equals("Host")) {
                    System.out.println("Host:" + ras.readLine());
                } else if (data.equals("Content-Type")) {
                    System.out.println("Content-Type:" + ras.readLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定文件");
        } catch (IOException e) {
            System.out.println("文件读写出现异常");
        }
    }
}
