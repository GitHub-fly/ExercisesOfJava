package exercises.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xunmi
 * @ClassName FileUtil
 * @Description �ļ���صĹ�����
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class FileUtil {

    /**
     * ��������ͼƬ�ķ�����Ĭ�ϱ�������ǰ�ļ����ڵ�
     * @param urlPath ��������ͼƬurl��ַ
     */
    public static void downPicture(String urlPath) {
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            System.out.println("����URL��������쳣");
        }
        /**
         * ����IO����������ͼƬ
         * url.openStream(): ���ڴ�URL��������һ��InputStream���Ա�Ӹ����Ӷ�ȡ
         */
        InputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream fos = null;
        BufferedOutputStream bos = null;
        byte[] temp = new byte[2048];
        try {
            fis = url.openStream();
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(new File(StringUtil.splitPicName(urlPath)));
            bos = new BufferedOutputStream(fos);

            while ((bis.read(temp)) != -1) {
                bos.write(temp);
            }
        } catch (IOException e) {
            System.out.println("����IO�쳣");
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                System.out.println("IO���رճ����쳣");
            }
        }
    }
}
