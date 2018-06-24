package com.github.hongkaiwen;

import com.github.hongkaiwen.pool.ThreadPoolHolder;
import com.github.hongkaiwen.remote.RemoteService;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-13 12:39 PM
 **/
public class RemotePlay {

    static RemoteService remoteService = new RemoteService();

    public static void main(String args[]){
        for(int i=0; i<100; i++){
            Flowable.fromCallable(() -> remoteService.callOrginal()).subscribeOn(Schedulers.from(ThreadPoolHolder.pool))
                    .map(result -> String.format("%d   by thread : %s", result, Thread.currentThread()))
                    .subscribe(System.out::println);
        }



//        for (int i = 0; i < 100; i++) {
//            remoteService.call()
//                    .subscribeOn(Schedulers.from(ThreadPoolHolder.pool))
//                    .map(result -> String.format("%d   by thread : %s", result, Thread.currentThread()))
//                    .subscribe(System.out::println);
//        }

        System.out.println("response...");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
