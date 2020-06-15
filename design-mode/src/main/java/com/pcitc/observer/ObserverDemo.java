package com.pcitc.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 *
 * @author : pcitc
 * @since : 2019年04月17日 20:10
 */

public class ObserverDemo {

    public static void main(String[] args) {
        // 被观察的对象
        MyObservable obs = new MyObservable();

        // 添加观察者
        obs.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("服务列表发生了变化1："+arg);
            }
        });

        Observer o = new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("服务列表发生了变化2：" + arg);
            }
        };
        obs.addObserver(o);

        obs.setServerList("192.168.110.1");

        obs.deleteObserver(o);
        obs.setServerList("192.168.110.2");
    }
}

/**
 * 被观察的对象 - 可用的server list
 */
class MyObservable extends Observable{

    private String serverList="";

    // 监听这个变化
    public void setServerList(String serverList){
        this.serverList = serverList;
        this.setChanged();
        this.notifyObservers(serverList);
    }
}

