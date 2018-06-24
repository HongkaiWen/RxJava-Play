package com.github.hongkaiwen;

import com.github.hongkaiwen.service.RxService;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-13 1:41 PM
 **/
public class H {

    public static void main(String args[]) throws InterruptedException {
        Observable.create((ObservableOnSubscribe<String>)
                emitter -> Observable.interval(1, TimeUnit.SECONDS)
                        .take(5)
                        .map(String::valueOf)
                        .subscribe(emitter::onNext)).subscribe(System.out::println);



        RxService rxService = new RxService();

        rxService.addScore4Student("Zhangsan");



    }

}
