package com.github.hongkaiwen.pkgreceive;

import com.github.hongkaiwen.callback.ReleaseCallback;
import com.github.hongkaiwen.docker.DockerClient;
import com.github.hongkaiwen.k8s.K8sClient;
import com.github.hongkaiwen.pool.ThreadPoolHolder;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 6:58 PM
 **/
public class PackageReceiver {

    DockerClient dockerClient = new DockerClient();
    K8sClient k8sClient = new K8sClient();
    ReleaseCallback releaseCallback = new ReleaseCallback();

    public void receive() {
        System.out.println("received. ");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("(received) extract ok. ");
        releaseCallback.releaseCallBack("package is ok. ");

        Flowable.just(new DeployVo()).subscribeOn(Schedulers.from(ThreadPoolHolder.pool)).subscribe(this::deploy);
    }

    public void deploy(DeployVo deployVo){
        try{
            dockerClient.build();
            releaseCallback.releaseCallBack("docker build is ok. ");
            k8sClient.deploy();
            releaseCallback.releaseCallBack("deploy ok. ");
        } catch(Exception e){

        }
    }

}

class DeployVo{

}
