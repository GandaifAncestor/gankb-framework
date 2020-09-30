package pers.gankb.base.concurrent.producerandconsumer.numbers;

/**
 * @description: 数字加减（生产者、消费者）案例-主线程类
 * @author: Gandaif
 * @date: 2020/9/18
 */
public class NumMainThread {

    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        Runnable addThread = new AddNumbersThread(numbers);
        Runnable subThread = new SubNumbersThread(numbers);

        new Thread(addThread, "加法线程A").start();
        new Thread(addThread, "加法线程B").start();
        new Thread(subThread, "减法线程C").start();
        new Thread(subThread, "减法线程D").start();
    }
}
