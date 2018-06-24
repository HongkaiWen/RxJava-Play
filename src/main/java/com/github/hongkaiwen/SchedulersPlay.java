package com.github.hongkaiwen;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-24 2:52 PM
 **/
public class SchedulersPlay {

    public static void main(String args[]) throws InterruptedException {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                System.out.println(Thread.currentThread() + " observable");
                Observable.interval(1, TimeUnit.SECONDS).take(1).map(String::valueOf).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(Thread.currentThread() + " emitter " + s);
                        emitter.onNext(s);
                    }
                });
            }
        });

        observable = observable.subscribeOn(Schedulers.computation());
        observable = observable.observeOn(Schedulers.io());

        observable = observable.map(s -> {
            System.out.println(Thread.currentThread() + " map " + s);
            return s + "  >>>>>";
        });

        observable = observable.observeOn(Schedulers.newThread());

        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread() + " receive " + s);
            }
        });

        TimeUnit.SECONDS.sleep(4);
    }

}
