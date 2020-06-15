package com.pcitc.template;

/**
 * @Author: pcitc
 * @Date: 2019-01-11
 * @Description:
 */
public class PUBG extends Game {

    @Override
    void endPlay() {
        System.out.println("结束PUBG游戏");
    }

    @Override
    void initialize() {
        System.out.println("初始化PUBG游戏");
    }

    @Override
    void startPlay() {
        System.out.println("开始PUBG游戏");
    }
}
