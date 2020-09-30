package pers.gankb.base.concurrent.producerandconsumer.third;

/**
 * @description: 体验第三个生产者-消费者模型（解决数据同步）中间消息实体类
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Message3 {

    private String title; // 标题
    private String content; // 内容

    /**
     * flag == true; 允许生产，但是不允许消费
     * flag == false; 允许消费，但是不允许生产
     */
    private boolean flag = true; // 开关，控制生产和消费

    /**
     * 使用 synchronized 关键字定义同步方法，对信息的设置做同步
     * 改进后，在此方法中就要去判断是否要等待消费：
     * 是-则先不生产，等待消费完成；
     * 否-则先生产，然后通知消费者消费。
     * @param title
     * @param content
     */
    public synchronized void set(String title, String content) {
        /**
         * 1、判断是否要等待消费
         */
        if (!flag) { // flag == false; 允许消费，但是不允许生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        /**
         * 2、生产
         */
        this.title = title;
        try {
            Thread.sleep(2000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }
        this.content = content;

        /**
         * 3、生产完成，通知消费者消费
         */
        this.flag = false; // 消费开关打开
        super.notify(); // 唤醒等待的消费者线程
    }

    /**
     * 使用 synchronized 关键字定义同步方法，对信息的获取做同步
     * 改进后，在此方法中就要去判断是否要等待生产：
     * 是-则先不消费，先等待生产者生产完成；
     * 否-则先消费，然后通知生产者生产。
     * @return
     */
    public synchronized String get() {
        /**
         * 1、判断是否要等待生产者生产
         */
        if (flag) { // flag == true; 允许生产，但是不允许消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        /**
         * 2、消费
         */
        try {
            Thread.sleep(1000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }

        /**
         * 3、消费完消息后，一定要通知生产者生产消息，所以借用了 try {...} finally {...}
         */
        try {
            return this.title + " - " + this.content;
        } finally { // 不管如何，都要执行
            this.flag = true; // 生产开关打开
            super.notify(); // 唤醒等待的消费者线程
        }
    }
}
