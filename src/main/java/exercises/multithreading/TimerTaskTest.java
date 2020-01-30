package exercises.multithreading;

import exercises.util.FileUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xunmi
 * @ClassName TimerTaskTest
 * @Description 了解TimerTask实现定时或周期性任务的方法，并知道其缺陷。
 * 用它来实现每隔 3 秒时间，生成一个二维码图片的功能
 * Timer 为单线程模式，若某一步出现异常，后续将无法继续进行，会终止。
 * @Date 2020/1/30
 * @Version 1.0
 **/
public class TimerTaskTest {

    public static Timer timer = null;

    public static void main(String[] args) throws InterruptedException {
        // 这里为用户线程，如果new Timer(true), 则是守护进程
        timer = new Timer();
        // 延迟1s执行，每隔3s执行一次
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
