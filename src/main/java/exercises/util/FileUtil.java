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
 * @Description 文件相关的工具类
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class FileUtil {

    /**
     * 下载网络图片的方法，默认保存至当前文件所在地
     *
     * @param urlPath 给定网络图片url地址
     */
    public static void downPicture(String urlPath) {
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            System.out.println("创建URL对象出现异常");
        }
        /**
         * 创建IO流进行下载图片
         * url.openStream(): 打开于此URL，并返回一个InputStream，以便从该连接读取
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
             * 此处做了修改，
             * 原先使用的是bos.write(temp),只有一个参数的Write方法
             * 现在修改成了三个参数的write方法
             */
            int length = 0;
            while ((length = bis.read(temp, 0, temp.length)) != -1) {
                bos.write(temp, 0, length);
            }
        } catch (IOException e) {
            System.out.println("出现IO异常");
        } finally {
            try {
                bos.flush();
                bis.close();
                bos.close();
            } catch (IOException e) {
                System.out.println("IO流关闭出现异常");
            }
        }
    }

    /**
     * 将指定的网页链接生成二维码图片并存入到当前类路径下
     * 图片默认大小为300 * 300
     *
     * @param urlPath     网页链接
     * @param pictureName 图片存入路径
     */
    public static void drawQrCode(String urlPath, String pictureName) {
        // 生成基本参数定义类
        QrConfig config = new QrConfig(300, 300);
        // 设置前景色，即二维码的颜色
        config.setForeColor(Color.BLACK);
        // 设置背景色
        config.setBackColor(Color.WHITE);
        // 设置log
        config.setImg("E:\\图库\\杂图\\微信头像.jpg");
        // 高纠错级别
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // 生成二维码到文件，也可到流
        QrCodeUtil.generate(urlPath, config, cn.hutool.core.io.FileUtil.file(System.getProperty("user.dir") + "\\" + pictureName));
        // 给控制台一个提示。
        System.out.println("生成一张二维码图片");
    }
}
