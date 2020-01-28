package exercises.multithreading;

import exercises.util.FileUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xunmi
 * @ClassName ThreadPool
 * @Description 学习线程池的基础使用方法。创建线程池，集合IO下载远程图片
 * @Date 2020/1/28
 * @Version 1.0
 **/
public class ThreadPool {

    public static void main(String[] args) {
        /**
         * 创建一个可重用、固定线程数的线程池
         */
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            // 将线程放入到线程池中
            pool.execute(new DownLoad());
        }
        // 关闭线程池
        pool.shutdown();
    }
}

class DownLoad implements Runnable {
    /**
     * 指定10张被下载图片
     */
    private String[] urlPaths = {"https://pic3.zhimg.com/80/v2-0262f200855e4f34d5fe0df839e0b06f_hd.jpg",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/1576836137177117.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157683613722252.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157683644265075.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/1576836442692117.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157683644272795.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157683671798927.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157683671798927.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157688830882147.png",
            "http://sunui-uniapp.oss-cn-beijing.aliyuncs.com/uniapp/157688830886870.png"
    };

    @Override
    public void run() {
        for (int i = 0; i < urlPaths.length; i++) {
            synchronized (this) {
                FileUtil.downPicture(urlPaths[i]);
            }
        }
    }
}
