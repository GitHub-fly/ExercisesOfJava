package exercises.multithreading;

import exercises.util.StringUtil;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xunmi
 * @ClassName ScheduledThreadPoolExecutor
 * @Description ѧϰʹ��ScheduledThreadPoolExecutor��ʵ�ֶ�ʱ�����Ե������˽������Timer������
 * ������ʵ��ÿ�����ϰ˵����������Ϣ�Ȱ񡣿���̨��ģ���ӡ����������ȡ�������ݡ�
 * @Date 2020/1/31
 * @Version 1.0
 **/
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        printDate("19:29:00");
    }


    /**
     * ��ָ��ʱ�䣬��ӡ������Ϣ�Ȱ�����
     * @param setTime   ָ������ʱ�䣬�磺��08:00:00��
     */
    public static void printDate(String setTime) {
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String currentDate = StringUtil.getCurrentDate().substring(11);
                if (setTime.equals(currentDate)) {
                    System.out.println("������Ϣ�Ȱ�:" + "\n\t" +
                            "1. ���͹�״�����������ֹյ�" + "\n\t" +
                            "2. ɽ���״η��׻���Ȭ��" + "\n\t" +
                            "3. \"���ǹ�ͬ�ĵ����ǲ���������ͬ��\"");
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
