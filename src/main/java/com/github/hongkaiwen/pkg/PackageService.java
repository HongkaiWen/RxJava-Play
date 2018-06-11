package com.github.hongkaiwen.pkg;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:55 PM
 **/
public class PackageService {

    public void preparePkg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("package prepare ok.");
    }

}
