package pers.gankb.base.concurrent.producerandconsumer.third;

/**
 * @description: 体验第三个生产者-消费者模型（解决数据同步）主线程类
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class MainThread3 {
    public static void main(String[] args) {
        // 定义消息中间类
        Message3 message = new Message3();
        // 创建生产者和消费者线程，并启动
        new Thread(new Producer3(message)).start();
        new Thread(new Consumer3(message)).start();
    }
}
