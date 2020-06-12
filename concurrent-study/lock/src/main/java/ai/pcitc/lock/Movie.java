package ai.pcitc.lock;

import java.util.concurrent.CountDownLatch;

public class Movie {
    private final CountDownLatch ctl = new CountDownLatch(1);
    //复仇者联盟3
    private Integer avengers3Tickets = 20;

    //侏罗纪世界2
    private Integer jurassic2Tickets = 100;

    public  void showAvengers3() throws InterruptedException {
        synchronized(avengers3Tickets) {
            System.out.println("复仇者联盟3剩余票量:" + avengers3Tickets);
//        showJurassic2();
            ctl.await();
            //准备购买
        }
    }


    public   void showJurassic2() throws InterruptedException {
        synchronized(jurassic2Tickets) {
            System.out.println("侏罗纪世界2剩余票量:" + jurassic2Tickets);
            ctl.await();
            //准备购买
        }
    }


    public static void main(String[] args) {
        final Movie movie = new Movie();
        new Thread(() -> {
            try {
                movie.showAvengers3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "用户A").start();

        new Thread(() -> {
            try {
                movie.showJurassic2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "用户B").start();
        try {
            Thread.sleep(1000000000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
