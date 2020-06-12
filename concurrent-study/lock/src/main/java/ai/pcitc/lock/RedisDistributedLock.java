package ai.pcitc.lock;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RedisDistributedLock implements Lock {

    //锁信息的上那个下文,保存当前锁的持有人id
    private ThreadLocal<String> lockContext = new ThreadLocal<>();

    //默认锁的超时时间
    private long time = 100;

    private Thread exclusiveOwnerThread;

    public RedisDistributedLock() {
    }

    public void lock() {
        while (!tryLock()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean tryLock() {
        return tryLock(time, TimeUnit.MILLISECONDS);
    }


    public boolean tryLock(long time, TimeUnit unit) {
        String id = UUID.randomUUID().toString();//为每个锁的持有人分配唯一的id
        Thread t = Thread.currentThread();
        Jedis jedis = RedisClient.getClient();

        if ("OK".equals(jedis.set("lock", id,"NX","PX",unit.toMillis(time)))) {//加锁并设置锁的有效期
            lockContext.set(id);//记录锁的持有人id
            setExclusiveOwnerThread(t);//记录当前线程
            return true;
        }else if(exclusiveOwnerThread == t){//当前线程已经获得了锁,可重入
            return true;
        }
        return false;
    }

    public void unlock() {
        String script = null;
        try {
            Jedis jedis = RedisClient.getClient();
            script = inputStream2String(getClass().getResourceAsStream("/redis.script"));
            if(lockContext.get() == null){
                return;
            }
            jedis.eval(script, Arrays.asList("lock"), Arrays.asList(lockContext.get()));//删除锁
            lockContext.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public void lockInterruptibly() throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        while (!tryLock()) {
            Thread.sleep(100);
        }
    }

    private String inputStream2String(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    private final void setExclusiveOwnerThread(Thread t) {
        exclusiveOwnerThread = t;
    }

}
