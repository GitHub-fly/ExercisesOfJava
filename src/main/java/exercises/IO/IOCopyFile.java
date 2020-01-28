package exercises.IO;

import java.io.*;

/**
 * @author xunmi
 * @ClassName IOCopyFile
 * @Description TODO
 * @Date 2020/1/14
 * @Version 1.0
 **/
public class IOCopyFile {


    /**
     * 通过缓冲字节流实现图片类型文件的拷贝功能
     * @param fromPath 指定文件的路径
     * @param toPath 拷贝后的文件放置路径
     */
    public static void byteStreamCopy(String fromPath, String toPath) {
        InputStream fis, bis = null;
        OutputStream fos, bos = null;

        try {
            // 创建字节输入流对象
            fis = new FileInputStream(fromPath);
            // 创建缓冲字节输入流对象，负责读取指定路径下的文件
            bis = new BufferedInputStream(fis, 512);

            // 创建字节输出流对象
            fos = new FileOutputStream(toPath);
            // 创建缓冲字节输出流对象，负责文件的复制操作
            bos = new BufferedOutputStream(fos, 512);

            // 创建中转站数组，存放每次读取的内容
            byte[] temp = new byte[1024];

            long startTime = System.currentTimeMillis();
            // 边读边写
            while ((bis.read(temp)) != -1) {
                bos.write(temp);
            }
            // 冲刷缓冲区
            bos.flush();
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("运行时间：" + endTime + "ms");
        } catch (FileNotFoundException e) {
            System.out.println("指定文件未找到");
        } catch (IOException e) {
            System.out.println("文件读取出现异常");
        } finally {
            try {
                // 关闭流
                bos.close();
                bis.close();
            } catch (IOException e) {
                System.out.println("字节流关闭出错");
            }
        }
    }

    /**
     * 通过缓冲字符流实现文本类型文件的拷贝功能
     * @param fromPath 指定文件的路径
     * @param toPath 拷贝后的文件放置路径
     */
    public static void characterStreamCopy(String fromPath, String toPath) {
        // 创建缓冲字符输入流
        Reader fileRider = null;
        BufferedReader reader = null;
        // 创建缓冲字符输出流
        Writer fileWriter = null;
        BufferedWriter writer = null;
        try {
            fileRider = new FileReader(fromPath);
            reader = new BufferedReader(fileRider);

            fileWriter = new FileWriter(toPath);
            writer = new BufferedWriter(fileWriter);

            String line = null;
            long startTime = System.currentTimeMillis();
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\r");
            }
            writer.flush();
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("运行时间：" + endTime + "ms");

        } catch (FileNotFoundException e) {
            System.out.println("未查找到指定文件");
        } catch (IOException e) {
            System.out.println("文件写入失败");
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("流关闭出现异常");
            }
        }
    }

    public static void main(String[] args) {
        byteStreamCopy("E:\\图库\\杂图\\微信头像.jpg", "E:\\图库\\杂图\\微信头像(1).jpg");
        characterStreamCopy("C:\\Users\\Asus\\Desktop\\IOExample.java", "C:\\Users\\Asus\\Desktop\\IOExample(1).java");
    }
}
