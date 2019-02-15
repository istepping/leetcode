package exercise.daily;

import exercise.daily.util.MyThread;
import exercise.daily.util.MyThread2;
import exercise.daily.util.MyThread3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2019/2/15 15:46
 * @version 1.0
 * @apiNote Java 线程问题
 */
public class Solution190215 {
    private void test1(){
        ExecutorService ex= Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            ex.submit(() -> {
                System.out.print("I am test1");
                System.out.print("I am test1");
            });
        }
        ex.shutdown();//正在运行的线程运行完,线程池就关闭
    }
    private void test2(){
        ExecutorService ex= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            ex.submit(() -> System.out.print("I am test 2"));
        }
        ex.shutdown();
    }
    private void test3(){
        ExecutorService ex= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            ex.submit(() -> System.out.print("I am test 3"));
        }
        ex.shutdown();
    }
    public static void main(String[] args){
        //方法一
        MyThread myThread=new MyThread();
        myThread.start();
        //方法二
        new Thread(new MyThread2()).start();
        Callable<String> callable=new MyThread3();
        //方法三
        FutureTask<String> futureTask=new FutureTask<>(callable);
        new Thread(futureTask).start();
        //方法四
        Solution190215 solution190215=new Solution190215();
        solution190215.test1();
        solution190215.test2();
        solution190215.test3();
        //主线程
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(1000);
                print("I am the main thread!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
