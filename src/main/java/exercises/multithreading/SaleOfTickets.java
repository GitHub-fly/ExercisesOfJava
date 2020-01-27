package exercises.multithreading;


/**
 * @author xunmi
 * @ClassName SaleOfTickets
 * @Description 使用多线程模拟多窗口售票程序
 * @Date 2020/1/27
 * @Version 1.0
 **/
public class SaleOfTickets {

    public static void main(String[] args) {

        SellTickets sell = new SellTickets();
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(sell, "窗口" + i);
            thread.start();
        }
    }
}

class SellTickets implements Runnable {
    /**
     * 定义票的总数
     */
    private int total = 10000;
    /**
     * 定义票的编号
     */
    private int numberCode = total + 1;

    @Override
    public void run() {
        while (true) {
            sale();

            /**
             * 如果你所选的票数很小，
             * 那么，
             * 接下来的这段代码对你来说可能非常重要，“Thread.sleep(1000)”
             * 之所以有了它让程序进行短暂的休眠，
             * 别的线程才有可能挤进来执行代码，
             * 不然会出现全是某一个线程从头执行到结束。
             *
             * 最主要的原因是自己所选的基数较小，看不出变化，
             * 你也可以尝试将自己的票数定义的大一些，如：10,000
             */
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        }
    }

    /**
     * 定义一个售票的方法并枷锁
     */
    private synchronized void sale() {
        if (total > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第\t" + (this.numberCode - this.total) + "   张票");
            this.total--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("计时器出现异常");
            }
        } else {
            System.out.println("票卖完了");
            System.exit(0);
        }
    }
}
