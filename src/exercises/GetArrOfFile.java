package exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName GetArrOfFile
 * @Description ָ��һ������·�����Ӹ�·����������·����ȡ����ͼƬ���͵��ļ����õ�һ��
 * File���飬���䰴�ļ���С���������
 * @Date 2020/1/17
 * @Version 1.0
 **/
public class GetArrOfFile {

    /**
     * ����ļ��ļ���
     */
    private static List<File> list = new ArrayList<>(10);

    /**
     * ��ȡָ���ļ������ļ�����
     *
     * @param fileName ָ���ļ����ļ���
     * @return ���ļ�������
     */
    public static String getType(String fileName) {
        // ��ȡ�ļ�����
        String type = fileName.substring(fileName.lastIndexOf('.') + 1);
        return type;
    }

    /**
     * �ж��ļ��Ƿ�ΪͼƬ
     *
     * @param fileName ָ���ļ�����
     * @return booleanֵ���Ƿ�ΪͼƬ
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
     * ��ȡ�ļ����飬��������ȫ�����ݾ�ΪͼƬ�ļ�����
     *
     * @param filePath ָ���ļ�·��
     * @return ͼƬ�ļ�����
     */
    public static List<File> getPictureList(String filePath) {
        File dir = new File(filePath);
        // ���ļ�Ŀ¼���ļ�ȫ����������
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                // ���ļ��Ļ�����Ҫ�ݹ�����������ļ�
                if (files[i].isDirectory()) {
                    getPictureList(files[i].getAbsolutePath());
                } else {
                    // ������ļ�����ֱ���ж��Ƿ�ΪͼƬ�����ļ�
                    if (isPicture(files[i].getName())) {
                        list.add(files[i]);
                    }
                }
            }
        }
        return list;
    }


    /**
     * ͨ��ָ��·������ȡ��·�������е�ͼƬ�����ļ������򣨽���
     *
     * @param filePath ָ���ļ�·��
     */
    public static void sortFileBySize(String filePath) {
        // 1. ͨ��ָ����·������ȡ��·���µ����е�ͼƬ���� list
        getPictureList(filePath);
        // 2. ��ͼƬ����תΪͼƬ����
        File[] picArr = list.toArray(new File[list.size()]);
        // 3. ð������Ӵ�С
        for (int i = 0; i < picArr.length - 1; i++) {
            // ����ѭ������
            for (int j = 0; j < picArr.length - i - 1; j++) {
                // ����ÿ����Ҫ�����Ĵ���
                if (picArr[j].length() < picArr[j + 1].length()) {
                    File temp = null;
                    temp = picArr[j];
                    picArr[j] = picArr[j + 1];
                    picArr[j + 1] = temp;
                }
            }
        }
        // 4. ����������
        for (File f : picArr) {
            System.out.println(f.getName() + "\t" + "(" + f.length() + "  B)");
        }
    }


    public static void main(String[] args) {
        sortFileBySize("E:\\test");
    }
}
