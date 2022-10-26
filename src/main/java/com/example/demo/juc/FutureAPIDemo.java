package com.example.demo.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2022/9/30 17:44
 * @PackageName:com.example.demo.juc
 * @ClassName: FutureAPIDemo
 * @Description: TODO
 * @Version 1.0
 */
public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<String>(()->{{
            System.out.println(Thread.currentThread().getName()+ "\t -----come in");
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "task over";
        }});
        Thread t1 = new Thread(stringFutureTask, "t1");
        t1.start();
        System.out.println(Thread.currentThread().getName() + "\t------忙其他任务了");

        System.out.println(stringFutureTask.get());
    }
}

/**
 *
 * get容易导致阻塞，一般建议放在程序后面，一旦调用不见不散，非要等到结果才会离开，不管你是否完成计算，容易程序堵塞
 *假如我不愿意等待很长时间，我希望过时不候，可以自动离开
 * */
