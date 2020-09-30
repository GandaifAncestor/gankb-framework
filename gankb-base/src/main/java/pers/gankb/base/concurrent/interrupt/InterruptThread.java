package pers.gankb.base.concurrent.interrupt;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * @description: 体验线程被打断的感觉
 * @author: Gandaif
 * @date: 2020/9/10
 */
public class InterruptThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("我是线程睡神，我这会儿先睡10秒，别打扰我。");
            try {
                Thread.sleep(10000);
                System.out.println("我是线程睡神，我睡醒了，要去维护世界和平。");
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        });
        thread.start(); // 线程睡神 启动

        try {
            Thread.sleep(2000); // 主线程main睡了2秒
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }

        if (thread.isInterrupted() == false) { // thread对象即上面我们创建的线程对象睡神
            System.out.println("我骚扰一下线程睡神，打断它的睡眠，不会挨打吧");
            thread.interrupt(); // 执行中断方法
        }
    }
}
