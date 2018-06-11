package com.github.hongkaiwen.callback;

import com.github.hongkaiwen.pkg.PackageService;
import com.github.hongkaiwen.push.PushService;

/**
 * @author hongkai
 * @create 2018-06-11 6:45 PM
 **/
public class JenkinsCallBack {

    PackageService packageService = new PackageService();
    PushService pushService = new PushService();

    public void buildNumber(Long buildNumber){
        System.out.println("jenkins build number is " + buildNumber);
    }

    public void buildResult(boolean success) throws InterruptedException {
        System.out.println("jenkins build success " + success);
        if(success){
            packageService.preparePkg();
            pushService.push();
        } else {
            System.out.println("jenkins is not ok, no action");
        }
    }

}
