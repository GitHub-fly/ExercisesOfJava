package exercises.util;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
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
     *
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

            /**
             * �˴������޸ģ�
             * ԭ��ʹ�õ���bos.write(temp),ֻ��һ��������Write����
             * �����޸ĳ�������������write����
             */
            int length = 0;
            while ((length = bis.read(temp, 0, temp.length)) != -1) {
                bos.write(temp, 0, length);
            }
        } catch (IOException e) {
            System.out.println("����IO�쳣");
        } finally {
            try {
                bos.flush();
                bis.close();
                bos.close();
            } catch (IOException e) {
                System.out.println("IO���رճ����쳣");
            }
        }
    }

    /**
     * ��ָ������ҳ�������ɶ�ά��ͼƬ�����뵽��ǰ��·����
     * ͼƬĬ�ϴ�СΪ300 * 300
     *
     * @param urlPath     ��ҳ����
     * @param pictureName ͼƬ����·��
     */
    public static void drawQrCode(String urlPath, String pictureName) {
        // ���ɻ�������������
        QrConfig config = new QrConfig(300, 300);
        // ����ǰ��ɫ������ά�����ɫ
        config.setForeColor(Color.BLACK);
        // ���ñ���ɫ
        config.setBackColor(Color.WHITE);
        // ����log
        config.setImg("E:\\ͼ��\\��ͼ\\΢��ͷ��.jpg");
        // �߾�����
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // ���ɶ�ά�뵽�ļ���Ҳ�ɵ���
        QrCodeUtil.generate(urlPath, config, cn.hutool.core.io.FileUtil.file(System.getProperty("user.dir") + "\\" + pictureName));
        // ������̨һ����ʾ��
        System.out.println("����һ�Ŷ�ά��ͼƬ");
    }
}
