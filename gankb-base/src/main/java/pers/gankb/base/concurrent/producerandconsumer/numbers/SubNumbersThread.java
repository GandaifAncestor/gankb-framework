package pers.gankb.base.concurrent.producerandconsumer.numbers;

/**
 * @description: 数字加减（生产者、消费者）案例-消费者
 * @author: Gandaif
 * @date: 2020/9/18
 */
public class SubNumbersThread implements Runnable {

    private Numbers numbers;

    public SubNumbersThread(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            this.numbers.subNumbers();
        }
    }
}
