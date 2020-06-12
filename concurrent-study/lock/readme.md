1.里面有redis实现分布式锁的功能
2.Redis为我们提供了publish/subscribe(发布/订阅)功能。我们可以对某个channel(频道)进行subscribe(订阅)，当有人在这个channel上publish(发布)消息时，redis就会通知我们，这样我们可以收到别人发布的消息。 作为Java的redis客户端，Jedis提供了publish/subscribe的接口。
3.卖票同步数据（未使用锁，synchronized，分布式锁）
