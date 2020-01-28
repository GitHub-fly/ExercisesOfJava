package exercises.multithreading;

import exercises.util.FileUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xunmi
 * @ClassName ThreadPool
 * @Description ѧϰ�̳߳صĻ���ʹ�÷����������̳߳أ�����IO����Զ��ͼƬ
 * @Date 2020/1/28
 * @Version 1.0
 **/
public class ThreadPool {

    public static void main(String[] args) {
        /**
         * ����һ�������á��̶��߳������̳߳�
         */
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            // ���̷߳��뵽�̳߳���
            pool.execute(new DownLoad());
        }
        // �ر��̳߳�
        pool.shutdown();
    }
}

class DownLoad implements Runnable {
    /**
     * ָ��10�ű�����ͼƬ
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
