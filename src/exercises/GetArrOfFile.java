package exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName GetArrOfFile
 * @Description 指定一个本地路径，从该路径及所有子路径获取所有图片类型的文件，得到一个
 * File数组，将其按文件大小排序输出。
 * @Date 2020/1/17
 * @Version 1.0
 **/
public class GetArrOfFile {

    /**
     * 存放文件的集合
     */
    private static List<File> list = new ArrayList<>(10);

    /**
     * 获取指定文件名的文件类型
     *
     * @param fileName 指定文件的文件名
     * @return 该文件的类型
     */
    public static String getType(String fileName) {
        // 截取文件类型
        String type = fileName.substring(fileName.lastIndexOf('.') + 1);
        return type;
    }

    /**
     * 判断文件是否为图片
     *
     * @param fileName 指定文件名称
     * @return boolean值，是否为图片
     */
    public static boolean isPicture(String fileName) {
        String type = getType(fileName);
        if (type.equalsIgnoreCase("psd") || type.equalsIgnoreCase("psb") ||
                type.equalsIgnoreCase("jpg") || type.equalsIgnoreCase("gif") ||
                type.equalsIgnoreCase("png")) {
            return true;
        }
        return false;
    }

    /**
     * 获取文件数组，该数组内全部数据均为图片文件类型
     *
     * @param filePath 指定文件路径
     * @return 图片文件集合
     */
    public static List<File> getPictureList(String filePath) {
        File dir = new File(filePath);
        // 该文件目录下文件全部放入数组
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                // 是文件的话就是要递归再深入查找文件
                if (files[i].isDirectory()) {
                    getPictureList(files[i].getAbsolutePath());
                } else {
                    // 如果是文件，就直接判断是否为图片类型文件
                    if (isPicture(files[i].getName())) {
                        list.add(files[i]);
                    }
                }
            }
        }
        return list;
    }


    /**
     * 通过指定路径，获取该路径下所有的图片类型文件并排序（降序）
     *
     * @param filePath 指定文件路径
     */
    public static void sortFileBySize(String filePath) {
        // 1. 通过指定文路径，获取该路劲下的所有的图片集合 list
        getPictureList(filePath);
        // 2. 将图片集合转为图片数组
        File[] picArr = list.toArray(new File[list.size()]);
        // 3. 冒泡排序从大到小
        for (int i = 0; i < picArr.length - 1; i++) {
            // 控制循环几趟
            for (int j = 0; j < picArr.length - i - 1; j++) {
                // 控制每趟需要交换的次数
                if (picArr[j].length() < picArr[j + 1].length()) {
                    File temp = null;
                    temp = picArr[j];
                    picArr[j] = picArr[j + 1];
                    picArr[j + 1] = temp;
                }
            }
        }
        // 4. 遍历输出结果
        for (File f : picArr) {
            System.out.println(f.getName() + "\t" + "(" + f.length() + "  B)");
        }
    }


    public static void main(String[] args) {
        sortFileBySize("E:\\test");
    }
}
