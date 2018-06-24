package com.github.hongkaiwen.service;

import com.github.hongkaiwen.dao.RxDao;
import io.reactivex.Observable;

/**
 * @author hongkai
 * @create 2018-06-24 1:22 PM
 **/
public class RxService {

    private RxDao rxDao = new RxDao();

    public void addScore4Student(String name) throws InterruptedException {
        rxDao.getByName(name)
                .map(student -> {
                    student.setScore(student.getScore() + 1);
                    return student;
                })
                .subscribe(student ->
                        rxDao.save(student).andThen(Observable.just("success saved."))
                                .subscribe(System.out::println));
    }

}
