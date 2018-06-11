package com.github.hongkaiwen;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

import java.util.stream.Stream;

/**
 * @author hongkai
 * @create 2018-06-06 10:42 PM
 **/
public class Play {


    public static void main(String args[]) throws InterruptedException {
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);

        Flowable.just("hi").subscribe(System.out::println);



        Thread.sleep(2000);
    }

}
