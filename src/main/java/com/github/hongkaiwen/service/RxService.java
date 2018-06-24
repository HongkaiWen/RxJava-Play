package com.github.hongkaiwen.service;

import com.github.hongkaiwen.dao.RxDao;
import com.github.hongkaiwen.domain.Student;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-24 1:22 PM
 **/
public class RxService {

    private RxDao rxDao = new RxDao();

    public void studentScoreCaculate(String name) throws InterruptedException {
        rxDao.getByName(name)
                .subscribeOn(Schedulers.io())
                .flatMap(student -> caculateScore(student))
                .subscribe(student ->
                        rxDao.save(student).andThen(Observable.just("success saved."))
                                .subscribe(System.out::println));
    }

    /**
     * 学生成绩计算
     *
     * @param student
     * @return
     * @throws InterruptedException
     */
    private Maybe<Student> caculateScore(Student student) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        student.setScore(100);
        return Maybe.just(student);
    }

}
