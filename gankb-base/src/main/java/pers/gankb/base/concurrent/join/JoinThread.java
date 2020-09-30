package pers.gankb.base.concurrent.join;

/**
 * @description: 体验线程强制执行的快感
 * @author: Gandaif
 * @date: 2020/9/11
 */
public class JoinThread {
    public static void main2(String[] args) {
        Thread thread = new Thread(() -> {
            for (int x = 0; x < 3; x++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println("我是" + Thread.currentThread().getName() + "，x= " + x);
            }
        }, "【娇羞子线程】");

        thread.start(); // 线程启动

        for (int x = 0; x < 3; x++) {
            //System.out.println("我是[霸道总裁主线程]，我睡10秒...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
            System.out.println("我是【霸道总裁主线程】，x= " + x);
        }
    }

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread(); // 获得主线程
        Thread thread = new Thread(() -> {
            for (int x = 0; x < 3; x++) {
                if (x == 1) {
                    try {
                        System.out.println("我是" + Thread.currentThread().getName() + "，我要调用主线程的join() ");
                        mainThread.join(); // 调用主线程mainThread的join()，让其独占资源，直到主线程死亡
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println("我是" + Thread.currentThread().getName() + "，x= " + x);
            }
        }, "【娇羞子线程】");

        thread.start(); // 线程启动

        for (int x = 0; x < 3; x++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
            System.out.println("我是【霸道总裁主线程】，x= " + x);
        }
    }
}
