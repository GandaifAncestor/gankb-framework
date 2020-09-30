package pers.gankb.base.concurrent.producerandconsumer.second;

/**
 * @description: 体验第二个生产者-消费者模型（解决数据同步）主线程
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class MainThread2 {

    public static void main(String[] args) {
        // 定义消息中间类
        Message2 message = new Message2();
        // 创建生产者和消费者线程，并启动
        new Thread(new Producer2(message)).start();
        new Thread(new Consumer2(message)).start();
    }
}
