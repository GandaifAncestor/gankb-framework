package pers.gankb.base.concurrent.sleep;

/**
 * @description: 体验线程休眠
 * @author: Gandaif
 * @date: 2020/9/10
 */
public class SleepThread {
    public static void main2(String[] args) {
        /**
         * 1、利用了 Thread(ThreadGroup group, String name) 构造方法。
         * 2、采用了 Lambda 方式实现线程主体类
         */
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 准备先睡个10秒，i=" + i);
                    Thread.sleep(10000); // 先睡个10秒
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + "睡醒了，i=" + i);
            }
        }, "线程_睡神").start();
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 准备先睡个10秒，i=" + i);
                    Thread.sleep(10000); // 先睡个10秒
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + " 睡醒了，i=" + i);
            }
        };
        /**
         * 开启多个线程
         */
        for (int t = 0; t < 3; t++) {
            new Thread(runnable, "线程_睡神_" + t).start();
        }
    }
}
