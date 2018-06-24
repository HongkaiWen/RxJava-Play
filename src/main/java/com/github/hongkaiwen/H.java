package com.github.hongkaiwen;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author hongkai
 * @create 2018-06-13 1:41 PM
 **/
public class H {

    public static void main(String args[]){
        Flowable.range(1, 2)
                .map(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);

        Flowable.range(1, 2)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);
    }

}
