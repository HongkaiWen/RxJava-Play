package com.github.hongkaiwen.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hongkai
 * @create 2018-06-11 7:13 PM
 **/
public class ThreadPoolHolder {

    public static ThreadPoolExecutor pool =
            new ThreadPoolExecutor(300,
                    300,
                    0L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(100000));

}
