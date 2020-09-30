package pers.gankb.base.concurrent.threadpool;

/**
 * @description: 体验多线程-线程池-线程任务
 * @author: Gandaif
 * @date: 2020/9/21
 */
public class ThreadPoolTask implements Runnable {

    private Object attachData;

    public ThreadPoolTask(Object task) {
        this.attachData = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始执行任务：[" + attachData + "]任务，使用的线程池，线程名称：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        attachData = null;
    }
}
