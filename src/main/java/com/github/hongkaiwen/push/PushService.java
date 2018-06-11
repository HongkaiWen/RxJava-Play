package com.github.hongkaiwen.push;

import com.github.hongkaiwen.pkgreceive.PackageReceiver;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:56 PM
 **/
public class PushService {

    PackageReceiver packageReceiver = new PackageReceiver();

    public void push() {
        System.out.println("before push. ");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("push ok. ");
        packageReceiver.receive();
    }

}
