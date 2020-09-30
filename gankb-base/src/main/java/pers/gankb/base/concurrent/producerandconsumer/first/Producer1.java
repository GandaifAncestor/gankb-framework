package pers.gankb.base.concurrent.producerandconsumer.first;

/**
 * @description: 体验第一个生产者-消费者模型，生产者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Producer1 implements Runnable {

    private Message1 message;

    public Producer1(Message1 message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) { // 偶数
                this.message.setTitle("偶数_" + x);
                try {
                    Thread.sleep(2000); // 模拟网络延迟
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                this.message.setContent("双数，让人想到了阴和阳");
            } else { // 奇数
                this.message.setTitle("奇数_" + x);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("发生了 InterruptedException 异常");
                }
                this.message.setContent("单着，自由快乐");
            }
        }
    }
}
