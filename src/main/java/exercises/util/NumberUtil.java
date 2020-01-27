package exercises.util;

/**
 * @author xunmi
 * @ClassName NumberUtil
 * @Description 数字相关的工具类
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class NumberUtil {

    private static int number = 1;

    /**
     * 从一开始打印一个自然数。
     */
    public static void printNumber() {
        System.out.println("自然数： " + number++);
    }

}
