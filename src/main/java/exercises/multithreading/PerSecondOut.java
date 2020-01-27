package exercises.multithreading;

import exercises.util.NumberUtil;

import java.util.concurrent.*;

/**
 * @author xunmi
 * @ClassName PerSecondOut
 * @Description 用继承Thread类， 实现Runnable接口，   实现Callable接口
 * 实现Java线程，实现每隔一秒递增输出一个从 1 开始的自然数
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class PerSecondOut {
    public static void main(String[] args) {

        /**
         * 1、 使用继承Thread类的方法
         */
//        ExtendsThread thread1 = new ExtendsThread();
//        thread1.start();


        /**
         * 2、 使用实现Runnable接口的方法
         */
//        ImplementsRunnable runnable = new ImplementsRunnable();
//        Thread thread2 = new Thread(runnable);
//        thread2.start();


        /**
         * 3、 使用实现Callable接口的方法
         */
        /**
         * ①
         */
//        ImplementsCallable callable = new ImplementsCallable();
//        // 执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果，即futureTask可以接收Thread3线程返回的结果
//        FutureTask<Object> futureTask = new FutureTask<>(callable);
//        Thread thread3 = new Thread(futureTask);
//        thread3.start();
        /**
         * ②
         */
        // 创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(1);
        // 提交任务
        pool.submit(new ImplementsCallable());
        // 关闭线程池
        pool.shutdown();

    }
}


/**
 * 通过继承Thread类实现计时器效果
 */
class ExtendsThread extends Thread {

    @Override
    public void run() {
        while (true) {
            NumberUtil.printNumber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }
}

/**
 * 通过实现Runnable接口实现计时器效果
 */
class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            NumberUtil.printNumber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }

}

/**
 * 通过实现Callable接口实现计时器效果
 */
class ImplementsCallable implements Callable {

    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                NumberUtil.printNumber();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }
}