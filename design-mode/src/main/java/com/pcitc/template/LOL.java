package com.pcitc.template;

/**
 * @Author: pcitc
 * @Date: 2019-01-11
 * @Description:
 */
public class LOL extends Game {

    @Override
    void endPlay() {
        System.out.println("结束LOL游戏");
    }

    @Override
    void initialize() {
        System.out.println("初始化LOL游戏");
    }

    @Override
    void startPlay() {
        System.out.println("开始LOL游戏");
    }
}