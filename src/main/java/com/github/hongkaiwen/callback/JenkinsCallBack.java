package com.github.hongkaiwen.callback;

import com.github.hongkaiwen.pkg.PackageService;
import com.github.hongkaiwen.pool.ThreadPoolHolder;
import com.github.hongkaiwen.push.PushService;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:45 PM
 **/
public class JenkinsCallBack {

    PackageService packageService = new PackageService();
    PushService pushService = new PushService();

    public void buildNumber(Long buildNumber){
        Flowable.just(buildNumber)
                .subscribeOn(Schedulers.from(ThreadPoolHolder.pool))
                .subscribe(this::updateBuildNumber);
    }

    public void updateBuildNumber(Long buildNumber){
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("jenkins in building ...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("update build number to " + buildNumber);
    }

    public void buildResult(boolean success){
        Flowable.just(success)
                .subscribeOn(Schedulers.from(ThreadPoolHolder.pool))
                .subscribe(this::afterJenkinsBuild);
    }

    public void afterJenkinsBuild(boolean success){
        System.out.println("jenkins build result is " + success);
        if(success){
            packageService.preparePkg();
            pushService.push();
        } else {
            System.out.println("jenkins is not ok, no action");
        }
    }

}
