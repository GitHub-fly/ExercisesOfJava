package exercises.multithreading;

import exercises.util.NumberUtil;

import java.util.concurrent.*;

/**
 * @author xunmi
 * @ClassName PerSecondOut
 * @Description �ü̳�Thread�࣬ ʵ��Runnable�ӿڣ�   ʵ��Callable�ӿ�
 * ʵ��Java�̣߳�ʵ��ÿ��һ��������һ���� 1 ��ʼ����Ȼ��
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class PerSecondOut {
    public static void main(String[] args) {

        /**
         * 1�� ʹ�ü̳�Thread��ķ���
         */
//        ExtendsThread thread1 = new ExtendsThread();
//        thread1.start();


        /**
         * 2�� ʹ��ʵ��Runnable�ӿڵķ���
         */
//        ImplementsRunnable runnable = new ImplementsRunnable();
//        Thread thread2 = new Thread(runnable);
//        thread2.start();


        /**
         * 3�� ʹ��ʵ��Callable�ӿڵķ���
         */
        /**
         * ��
         */
//        ImplementsCallable callable = new ImplementsCallable();
//        // ִ��Callable��ʽ����ҪFutureTaskʵ�����֧�֣����ڽ�������������futureTask���Խ���Thread3�̷߳��صĽ��
//        FutureTask<Object> futureTask = new FutureTask<>(callable);
//        Thread thread3 = new Thread(futureTask);
//        thread3.start();
        /**
         * ��
         */
        // �����̳߳ض���
        ExecutorService pool = Executors.newFixedThreadPool(1);
        // �ύ����
        pool.submit(new ImplementsCallable());
        // �ر��̳߳�
        pool.shutdown();

    }
}


/**
 * ͨ���̳�Thread��ʵ�ּ�ʱ��Ч��
 */
class ExtendsThread extends Thread {

    @Override
    public void run() {
        while (true) {
            NumberUtil.printNumber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        }
    }
}

/**
 * ͨ��ʵ��Runnable�ӿ�ʵ�ּ�ʱ��Ч��
 */
class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            NumberUtil.printNumber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        }
    }

}

/**
 * ͨ��ʵ��Callable�ӿ�ʵ�ּ�ʱ��Ч��
 */
class ImplementsCallable implements Callable {

    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                NumberUtil.printNumber();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        }
    }
}