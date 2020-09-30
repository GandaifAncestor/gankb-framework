package pers.gankb.base.concurrent.producerandconsumer.first;

/**
 * @description: 体验第一个生产者-消费者模型，主线程
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class MainThread1 {

    public static void main(String[] args) {
        // 定义消息中间类
        Message1 message = new Message1();
        // 创建生产者和消费者线程，并启动
        new Thread(new Producer1(message)).start();
        new Thread(new Consumer1(message)).start();
    }
}
