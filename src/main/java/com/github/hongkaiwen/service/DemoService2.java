package com.github.hongkaiwen.service;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-08 12:37 PM
 **/
public class DemoService2 {

    public void insert(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("insert : " + input);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Flowable<String> callRemoteA(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            return Flowable.just("remote service A response: " + input);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Flowable<String> callRemoteB(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            return Flowable.just("remote service B response: " + input);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
