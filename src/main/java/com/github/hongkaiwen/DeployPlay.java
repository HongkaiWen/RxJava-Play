package com.github.hongkaiwen;

import com.github.hongkaiwen.jenkins.JenkinsClient;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:47 PM
 **/
public class DeployPlay {

    static JenkinsClient jenkinsClient = new JenkinsClient();

    public static void main(String args[]) throws InterruptedException {
        jenkinsClient.createJob();
        System.out.println("start deploy... running in backend... ");
        System.out.println("jenkins in queuing ...");
        TimeUnit.SECONDS.sleep(60);
    }


}
