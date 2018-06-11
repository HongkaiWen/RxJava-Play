package com.github.hongkaiwen;

import com.github.hongkaiwen.domain.Student;
import com.github.hongkaiwen.service.DemoService;
import com.github.hongkaiwen.service.DemoService2;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

/**
 * @author hongkai
 * @create 2018-06-08 12:43 PM
 **/
public class W {

    public static void main(String args[]){

        Observable.just("").subscribe();

        DemoService2 demoService2 = new DemoService2();
        DemoService demoService = new DemoService();

        Observable<Student> todoObservable = Observable.create(emitter -> {
            try {
                List<Student> todos = demoService.listStudent();
                for (Student todo : todos) {
                    emitter.onNext(todo);
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        todoObservable.subscribe(System.out::println, Throwable::printStackTrace);


        long start = System.currentTimeMillis();



        demoService2.callRemoteA("init").subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(t -> demoService2.callRemoteB(t).subscribe(demoService2::insert));
        System.out.println(System.currentTimeMillis() - start);



        String a = demoService.callRemoteA("init");
        String b = demoService.callRemoteB(a);
        demoService.insert(b);
        System.out.println(System.currentTimeMillis() - start);
    }

}
