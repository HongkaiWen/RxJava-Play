package com.github.hongkaiwen.docker;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:42 PM
 **/
public class DockerClient {

    public void build() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        System.out.println("docker build .");
    }

}
