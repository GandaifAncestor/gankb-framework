package pers.gankb.base.concurrent.synchronize;

/**
 * @description: 同步代码块 来实现线程安全
 * @author: Gandaif
 * @date: 2020/9/14
 */
public class TicketsSafeOneThread implements Runnable {

    private int tickets = 10; // 默认10张票

    @Override
    public void run() {
        synchronized (this) { // synchronized关键字同步代码块，每次只允许一个线程访问
            while (true) {
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
    }

    public static void main(String[] args) {
        TicketsSafeOneThread thread = new TicketsSafeOneThread();
        // 创建3个线程对象，并启动
        new Thread(thread, "票贩子A").start();
        new Thread(thread, "票贩子B").start();
        new Thread(thread, "票贩子C").start();
    }
}
