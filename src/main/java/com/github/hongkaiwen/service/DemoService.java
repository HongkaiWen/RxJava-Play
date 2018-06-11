package com.github.hongkaiwen.service;

import com.github.hongkaiwen.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-08 12:37 PM
 **/
public class DemoService {

    public void insert(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("insert : " + input);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String callRemoteA(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            return "remote service A response: " + input;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String callRemoteB(String input){
        try {
            TimeUnit.SECONDS.sleep(10);
            return "remote service B response: " + input;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> listStudent(){
        Student xiaoming = new Student("xiaoming", 1);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student xiaona = new Student("xiaona", 2);
        Student xiaoli = new Student("xiaoli", 3);
        List<Student> result = new ArrayList<>();
        result.add(xiaoming);
        result.add(xiaona);
        result.add(xiaoli);
        return result;
    }

}
