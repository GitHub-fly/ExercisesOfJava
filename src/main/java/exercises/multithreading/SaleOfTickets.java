package exercises.multithreading;


/**
 * @author xunmi
 * @ClassName SaleOfTickets
 * @Description ʹ�ö��߳�ģ��ര����Ʊ����
 * @Date 2020/1/27
 * @Version 1.0
 **/
public class SaleOfTickets {

    public static void main(String[] args) {

        SellTickets sell = new SellTickets();
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(sell, "����" + i);
            thread.start();
        }
    }
}

class SellTickets implements Runnable {
    /**
     * ����Ʊ������
     */
    private int total = 10000;
    /**
     * ����Ʊ�ı��
     */
    private int numberCode = total + 1;

    @Override
    public void run() {
        while (true) {
            sale();

            /**
             * �������ѡ��Ʊ����С��
             * ��ô��
             * ����������δ��������˵���ܷǳ���Ҫ����Thread.sleep(1000)��
             * ֮�����������ó�����ж��ݵ����ߣ�
             * ����̲߳��п��ܼ�����ִ�д��룬
             * ��Ȼ�����ȫ��ĳһ���̴߳�ͷִ�е�������
             *
             * ����Ҫ��ԭ�����Լ���ѡ�Ļ�����С���������仯��
             * ��Ҳ���Գ��Խ��Լ���Ʊ������Ĵ�һЩ���磺10,000
             */
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        }
    }

    /**
     * ����һ����Ʊ�ķ���������
     */
    private synchronized void sale() {
        if (total > 0) {
            System.out.println(Thread.currentThread().getName() + "�����˵�\t" + (this.numberCode - this.total) + "   ��Ʊ");
            this.total--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("��ʱ�������쳣");
            }
        } else {
            System.out.println("Ʊ������");
            System.exit(0);
        }
    }
}
