package pers.gankb.base.concurrent.stop;

/**
 * @description: 柔和地停止线程
 * @author: Gandaif
 * @date: 2020/9/17
 */
public class StopThread {
    public static boolean flag = true; // 定义一个全局开关

    public static void main(String[] args) {
        new Thread(() -> {
            long num = 0;
            while (flag) {
                try {
                    Thread.sleep(50); // 模拟网络延迟
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + " - 正在执行，num=" + num++);
            }
        }, "执行线程").start();

        try {
            Thread.sleep(200); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }

        flag = false;
        System.out.println(Thread.currentThread().getName() + " - 结束正在执行的子线程");
    }
}
