package ai.pcitc.thread;


import java.util.concurrent.CountDownLatch;

/**
 * pcitc
 */
public class Ticket {
    private static CountDownLatch ctl = new CountDownLatch(1);
    /*初始库存量*/
    Integer stock = 8;


    public synchronized void reduce(int num) {
        /*判断可用库存操作*/
        if ((stock - num) >= 0) {
            /*为了更好体现线程间的竞争，让进程等待*/
            try {
                ctl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock -= num;
            System.out.println(Thread.currentThread().getName()
                    + "成功：卖出" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        } else {
            System.err.println(Thread.currentThread().getName()
                    + "失败：库存不足" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        }

    }


    public static void main(String[] args) throws InterruptedException {
        final Ticket ticket = new Ticket();

        /*开启10个线程，模拟10个用户买电影票操作*/
        for (int i = 0; i < 10; i++) {

            new Thread(() -> ticket.reduce(1), "用户" + (i + 1)).start();
        }
        Thread.sleep(1000l);
        ctl.countDown();

    }
}

