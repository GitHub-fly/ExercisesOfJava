package exercises.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xunmi
 * @ClassName StringUtil
 * @Description �ַ�����صĹ�����
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class StringUtil {

    /**
     * ��ȡָ��url·��������ͼƬ������
     * @param urlPath ָ��������ͼƬ·��
     * @return ��ͼƬ������
     */
    public static String splitPicName(String urlPath) {
        return urlPath.substring(urlPath.lastIndexOf("/") + 1 );
    }

    /**
     * ��ȡ��ǰϵͳʱ��
     * ��ʽ�� 2020-01-29 15:13:16
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}
