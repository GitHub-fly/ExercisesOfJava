package exercises.util;

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

}
