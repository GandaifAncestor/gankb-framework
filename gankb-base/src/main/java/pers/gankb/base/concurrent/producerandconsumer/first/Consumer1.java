package pers.gankb.base.concurrent.producerandconsumer.first;

/**
 * @description: 体验第一个生产者-消费者模型，消费者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Consumer1 implements Runnable {

    private Message1 message;

    public Consumer1(Message1 message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            try {
                Thread.sleep(1000); // 模拟网络延迟
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
            System.out.println("消费者(" + x + ")消费：" + this.message.getTitle() + " - " + this.message.getContent());
        }
    }
}
