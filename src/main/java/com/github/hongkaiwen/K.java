package com.github.hongkaiwen;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * @author hongkai
 * @create 2018-06-13 7:42 PM
 **/
public class K {

    public static void main(String args[]){
        Maybe<Integer> filter = Single.just(1).filter(t -> t > 0);

        System.out.println( filter.filter(t -> t > 2).blockingGet());
        System.out.println(filter.blockingGet());
    }

}
