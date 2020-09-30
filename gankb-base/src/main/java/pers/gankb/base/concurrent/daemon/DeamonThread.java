package pers.gankb.base.concurrent.daemon;

/**
 * @description: 体验一个简单的守护线程
 * @author: Gandaif
 * @date: 2020/9/17
 */
public class DeamonThread {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> { // 用户线程，完成核心的业务处理
            for (int x = 0; x < 10; x++) {
                try {
                    Thread.sleep(100); // 模拟网络延时
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + " - 正在执行，x=" + x);
            }
        }, "用户线程");

        Thread daemonThread = new Thread(() -> {
            for (int x = 0; x < Integer.MAX_VALUE; x++) {
                try {
                    Thread.sleep(100); // 模拟网络延时
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + " - 正在执行，x=" + x);
            }
        }, "守护线程");

        daemonThread.setDaemon(true); // 设置为守护线程

        userThread.start(); // 启动用户线程
        daemonThread.start(); // 启动守护线程
    }
}
