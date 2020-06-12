package ai.pcitc.lock;

import java.util.concurrent.CountDownLatch;

public class Ticket {
    private static CountDownLatch ctl = new CountDownLatch(1);
    RedisDistributedLock lock = new RedisDistributedLock();
    /*初始库存量*/
    Integer stock = 8;


    public  void reduce(int num) {//200ms
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
        //积分增加  100ms
    }



    public void reduceByLock(int num) {
        boolean flag = false;

        synchronized (stock) {//50ms
            if ((stock - num) >= 0) {
                try {
                    ctl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stock -= num;
                flag = true;
            }
        }

        //判断当前用户是否是会员,送积分 50ms+10ms
        if (flag)
            System.out.println(Thread.currentThread().getName()
                    + "成功：卖出" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        else
            System.err.println(Thread.currentThread().getName()
                    + "失败：库存不足" + String.valueOf(num) + "张，库存剩余" + stock + "张");

    }

    public void reduceByRedisLock(int num) {
        boolean flag = false;
        try {
            lock.lock();
            if ((stock - num) >= 0) {
                try {
                    ctl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stock -= num;
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        if (flag)
            System.out.println(Thread.currentThread().getName()
                    + "成功：卖出" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        else
            System.err.println(Thread.currentThread().getName()
                    + "失败：库存不足" + String.valueOf(num) + "张，库存剩余" + stock + "张");

    }

    public static void main(String[] args) throws InterruptedException {
        final Ticket ticket = new Ticket();
        /*开启10个线程，模拟10个用户进行下单操作*/
        for (int i = 0; i < 10; i++) {
            //new Thread(() -> ticket.reduce(1), "用户" + (i + 1)).start();
            //new Thread(() -> ticket.reduceByLock(1), "用户" + (i + 1)).start();
            new Thread(() -> ticket.reduceByRedisLock(1), "用户" + (i + 1)).start();

        }
        Thread.sleep(1000L);
        ctl.countDown();

    }
}
