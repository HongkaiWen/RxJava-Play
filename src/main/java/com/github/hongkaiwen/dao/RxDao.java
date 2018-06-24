package com.github.hongkaiwen.dao;

import com.github.hongkaiwen.domain.Student;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-24 1:53 PM
 **/
@Slf4j
public class RxDao {


    /**
     * 根据姓名查询学生
     *
     * @param name
     * @return
     * @throws InterruptedException
     */
    public Maybe<Student> getByName(String name) throws InterruptedException {
        //模拟延迟
        TimeUnit.SECONDS.sleep(3);

        return Maybe.create(maybeEmitter -> {
            if ("Zhangsan".equals(name)) {
                maybeEmitter.onSuccess(Student.builder().name("Zhangsan").age(15).score(90).build());
            } else if ("Lisi".equals(name)) {
                maybeEmitter.onError(new RuntimeException("Lisi is not found"));
            }
        });
    }

    /**
     * 保存学生信息
     *
     * @param student
     * @return
     * @throws InterruptedException
     */
    public Completable save(Student student) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        log.info("saved student: {}", student);
        return Completable.complete();
    }

}
