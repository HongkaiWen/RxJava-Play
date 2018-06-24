package com.github.hongkaiwen.remote;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-13 12:38 PM
 **/
public class RemoteService {

    public Flowable<Integer> call(){
        FlowableOnSubscribe<Integer> source = i -> i.onNext(callOrginal());
        return Flowable.create(source, BackpressureStrategy.BUFFER);
    }

    public Integer callOrginal(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer result = new Random().nextInt(100) + 1;
        return result;
    }

}
