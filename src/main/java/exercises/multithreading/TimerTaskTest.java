package exercises.multithreading;

import exercises.util.FileUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xunmi
 * @ClassName TimerTaskTest
 * @Description �˽�TimerTaskʵ�ֶ�ʱ������������ķ�������֪����ȱ�ݡ�
 * ������ʵ��ÿ�� 3 ��ʱ�䣬����һ����ά��ͼƬ�Ĺ���
 * Timer Ϊ���߳�ģʽ����ĳһ�������쳣���������޷��������У�����ֹ��
 * @Date 2020/1/30
 * @Version 1.0
 **/
public class TimerTaskTest {

    public static Timer timer = null;

    public static void main(String[] args) throws InterruptedException {
        // ����Ϊ�û��̣߳����new Timer(true), �����ػ�����
        timer = new Timer();
        // �ӳ�1sִ�У�ÿ��3sִ��һ��
        timer.schedule(new DrawQrCodeThread(), 1000, 3000);
    }
}

class DrawQrCodeThread extends TimerTask {
    private static int index = 1;

    @Override
    public void run() {
        FileUtil.drawQrCode("https://github.com/GitHub-fly/ExercisesOfJava", "test" + index++ + ".jpg");
    }
}
