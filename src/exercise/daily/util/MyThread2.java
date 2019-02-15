package exercise.daily.util;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2019/2/15 18:31
 * @version 1.0
 * @apiNote
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(1000);
                print("I am the thread2!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
