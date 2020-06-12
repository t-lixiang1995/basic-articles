package ai.pcitc.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 我们首先生成了一个JedisPool的redis连接池，这是由于Jedis不是线程安全的，JedisPool是线程安全的。
 * 而我们的程序在主线程和订阅线程(SubThread)均需要使用Jedis，故在程序中我们使用JedisPool。
 * 
 * 由于Jedis的subcribe操作是阻塞的，故我们另起了一个线程来进行subcribe操作。 
 * 通过调用Publisher::start()方法，接受用户的输入，并publish到指定的channel。
 * 
 * @author pcitc
 *
 */
public class PubSubDemo 
{
    public static void main( String[] args )
    {
        // 替换成你的reids地址和端口
        String redisIp = "127.0.0.1";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
}