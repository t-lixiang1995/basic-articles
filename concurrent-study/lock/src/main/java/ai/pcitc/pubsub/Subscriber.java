package ai.pcitc.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * Jedis定义了抽象类JedisPubSub，在这个类中，定义publish/subsribe的回调方法。
 * 通过继承JedisPubSub类并重新实现这些回调方法，当publish/subsribe事件发生时，我们可以定制自己的处理逻辑。
 * @author pcitc
 *
 */
public class Subscriber extends JedisPubSub {
    public Subscriber() {
    }

    public void onMessage(String channel, String message) {
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }

    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d", 
                channel, subscribedChannels));
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d", 
                channel, subscribedChannels));

    }
}