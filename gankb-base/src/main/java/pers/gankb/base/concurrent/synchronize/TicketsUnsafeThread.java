package pers.gankb.base.concurrent.synchronize;

/**
 * @description: 利用卖票的例子来体验线程同步问题的提出与关键点
 * @author: Gandaif
 * @date: 2020/9/14
 */
public class TicketsUnsafeThread implements Runnable {

    private int tickets = 10; // 只有10张票

    @Override
    public void run() {
        while(true) {
            if (this.tickets > 0) {
                try {
                    Thread.sleep(1000); // 睡眠1秒，模拟网络延迟
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.tickets--);
            } else {
                System.out.println("***** 票已经卖光了，明天再来吧 *****");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TicketsUnsafeThread thread = new TicketsUnsafeThread();
        // 创建3个线程对象，并启动
        new Thread(thread, "票贩子A").start();
        new Thread(thread, "票贩子B").start();
        new Thread(thread, "票贩子C").start();
    }
}
