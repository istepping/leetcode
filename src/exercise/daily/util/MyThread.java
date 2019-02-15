package exercise.daily.util;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2019/2/15 15:48
 * @version 1.0
 * @apiNote
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(1000);
                print("I am the new thread!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
