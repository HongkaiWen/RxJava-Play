package com.github.hongkaiwen.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author hongkai
 * @create 2018-06-08 1:08 PM
 **/
@Data
@Builder
@ToString
public class Student {

    private String name;

    private int age;

    private int score;
}
