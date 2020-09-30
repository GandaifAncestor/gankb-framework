package pers.gankb.base.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 体验多线程-线程池-线程池
 * @author: Gandaif
 * @date: 2020/9/21
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();

        System.out.println("======== 创建一个线程池 开始 ========");
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 6, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));

        // 创建线程任务并提交到线程池中
        for (int x = 0; x <= 10; x++) {
            try {
                String task = "task=" + x;
                System.out.println("创建线程任务并提交到线程池中：" + task);

                // 创建线程任务并提交到线程池中
                threadPool.execute(new ThreadPoolTask(task));

                try {
                    Thread.sleep(100); // 模拟网络延时
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            // 等待所有线程执行完毕当前任务
            threadPool.shutdown();

            boolean flag = true;

            do {
                // 等待所有线程执行完毕当前任务结束
                flag = !threadPool.awaitTermination(2, TimeUnit.SECONDS);
            } while (flag);

            if (!flag) {
                System.out.println("所有线程执行完毕");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("======== 创建一个线程池 结束 ========");
            System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
