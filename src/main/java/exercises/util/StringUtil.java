package exercises.util;

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

}
