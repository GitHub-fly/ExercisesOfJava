package exercises.multithreading;

import exercises.util.StringUtil;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xunmi
 * @ClassName ScheduledThreadPoolExecutor
 * @Description 学习使用ScheduledThreadPoolExecutor来实现定时周期性的任务，了解其比起Timer的优势
 * 用它来实现每天早上八点输出当日信息热榜。控制台先模拟打印，进阶是爬取网络数据。
 * @Date 2020/1/31
 * @Version 1.0
 **/
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        printDate("19:29:00");
    }


    /**
     * 在指定时间，打印当日信息热榜数据
     * @param setTime   指定具体时间，如：“08:00:00”
     */
    public static void printDate(String setTime) {
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(1);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String currentDate = StringUtil.getCurrentDate().substring(11);
                if (setTime.equals(currentDate)) {
                    System.out.println("当日信息热榜:" + "\n\t" +
                            "1. 新型冠状病毒传播出现拐点" + "\n\t" +
                            "2. 山西首次肺炎患者痊愈" + "\n\t" +
                            "3. \"我们共同的敌人是病毒，不是同胞\"");
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
