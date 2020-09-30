package pers.gankb.base.concurrent.producerandconsumer.second;

/**
 * @description: 体验第二个生产者-消费者模型（解决数据同步）生产者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Producer2 implements Runnable {

    private Message2 message;

    public Producer2(Message2 message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) { // 偶数
                this.message.set("偶数_" + x, "双数，让人想到了阴和阳");
            } else { // 奇数
                this.message.set("奇数_" + x, "单着，自由快乐");
            }
        }
    }
}
