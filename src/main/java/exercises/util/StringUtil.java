package exercises.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xunmi
 * @ClassName StringUtil
 * @Description 字符串相关的工具类
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class StringUtil {

    /**
     * 获取指定url路径的网络图片的名字
     * @param urlPath 指定的网络图片路径
     * @return 该图片的名字
     */
    public static String splitPicName(String urlPath) {
        return urlPath.substring(urlPath.lastIndexOf("/") + 1 );
    }

    /**
     * 获取当前系统时间
     * 格式： 2020-01-29 15:13:16
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}
