package pers.gankb.base.concurrent.producerandconsumer.second;

/**
 * @description: 体验第二个生产者-消费者模型（解决数据同步）中间消息实体类
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Message2 {

    private String title; // 标题
    private String content; // 内容

    /**
     * 使用 synchronized 关键字定义同步方法，对信息的设置做同步
     * @param title
     * @param content
     */
    public synchronized void set(String title, String content) {
        this.title = title;
        try {
            Thread.sleep(2000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }
        this.content = content;
    }

    /**
     * 使用 synchronized 关键字定义同步方法，对信息的获取做同步
     * @return
     */
    public synchronized String get() {
        try {
            Thread.sleep(1000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }
        return this.title + " - " + this.content;
    }
}
