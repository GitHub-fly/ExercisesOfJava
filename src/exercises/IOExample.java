package exercises;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author xunmi
 * @ClassName exercises.IOExample
 * @Description 程序随机生成100个0-99之间的随机整数存入数组，选择一种合适的流，将该
 * 数组的100个整数写入本地文件。
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class IOExample {

    /**
     * 随机生成指定个数的、指定范围的随机数，并存入数组中
     *
     * @param bound  指定生成数字的范围
     * @param number 生成指定数量的数据
     * @return 返回该随机数数组
     */
    public static int[] randomInteger(int bound, int number) {
        Random random = new Random();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    /**
     * 使用OutputStreamWriter流写入数据
     * 允许文件末尾追加
     * @param arr 被写入数据的数组
     * @param filePath 文件路径（名称）
     */
    public static void write(int[] arr, String filePath) {
        String encode = "UTF-8";
        FileOutputStream fos = null;
        OutputStreamWriter out = null;
        try {
            fos = new FileOutputStream(new File(filePath), true);
            out = new OutputStreamWriter(fos, encode);
            // 打印写入时间
            out.write(LocalDateTime.now().toString() + "\n");
            for (int i = 0; i < arr.length; i++) {
                out.write(String.valueOf(arr[i]) + "\t");
                // 每十个数字进行换行
                if ((i + 1) % 10 == 0) {
                    out.write("\n");
                }
            }
            out.write("\n");
            // 冲刷缓冲区
            out.flush();
        } catch (FileNotFoundException e) {
            System.out.println("文件创建失败");
        } catch (IOException e) {
            System.out.println("数据写入时出现错误");
        } finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                System.out.println("OutputStreamWriter流关闭出现异常");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = randomInteger(100, 100);
        write(arr, "/randomInt.txt");
    }
}
