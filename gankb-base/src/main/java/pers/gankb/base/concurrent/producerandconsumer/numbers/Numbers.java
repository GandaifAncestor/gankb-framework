package pers.gankb.base.concurrent.producerandconsumer.numbers;

/**
 * @description: 数字加减（生产者、消费者）案例：
 * 1、生产者做加法，消费者做减法；
 * 2、中间实体类/中间操作类
 * @author: Gandaif
 * @date: 2020/9/17
 */
public class Numbers {

    private int num = 0; // 需要做加减的数据

    /**
     * flag = true，生产者做加法操作，而消费者不能做减法只能等待
     * flag = false，消费者做减法，而生产者不能做加法需要等待
     */
    private boolean flag = true; // 开关标志，控制生产者和消费者的加减动作

    public synchronized void addNumbers() {
        if (!flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        try {
            Thread.sleep(1000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }

        this.num++;
        System.out.println(Thread.currentThread().getName() + " - 加1 number=" + this.num);

        this.flag = false;
        super.notifyAll();
    }

    public synchronized void subNumbers() {
        if (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        try {
            Thread.sleep(1000); // 模拟网络延迟
        } catch (InterruptedException e) {
            System.out.println("发生了 InterruptedException 异常");
        }

        try {
            this.num--;
            System.out.println(Thread.currentThread().getName() + " - 减1 number=" + this.num);
        } finally {
            this.flag = true;
            super.notifyAll();
        }
    }

}
