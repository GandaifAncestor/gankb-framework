package pers.gankb.base.concurrent.producerandconsumer.third;

/**
 * @description: 体验第三个生产者-消费者模型（解决数据同步）消费者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Consumer3 implements Runnable {

    private Message3 message;

    public Consumer3(Message3 message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println("消费者(" + x + ")消费：" + this.message.get());
        }
    }
}
