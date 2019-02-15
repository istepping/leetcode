package exercise.daily.util;

import java.util.concurrent.Callable;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2019/2/15 19:18
 * @version 1.0
 * @apiNote
 */
public class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1000);
                print("I am the thread3!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "返回";
    }
}
