package com.github.hongkaiwen.jenkins;

import com.github.hongkaiwen.callback.JenkinsCallBack;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:43 PM
 **/
public class JenkinsClient {

    JenkinsCallBack jenkinsCallBack = new JenkinsCallBack();

    /**
     * 模拟创建jenkins job
     */
    public void createJob() {

        new Thread(() -> {
            try{
                //模拟排队
                TimeUnit.SECONDS.sleep(3);
                int  n = new Random().nextInt(50) + 1;
                //模拟排队成功
                jenkinsCallBack.buildNumber((long) n);
                //模拟构建
                TimeUnit.SECONDS.sleep(10);
                System.out.println("jenkins: create jenkins job success");

                int i = new Random().nextInt(1) + 1;

                //模拟随机结果
                jenkinsCallBack.buildResult(i/2 == 0);
                System.out.println("jenkins: send build result ok. ");
            }catch(Exception e){

            }

        }).start();
    }

}
