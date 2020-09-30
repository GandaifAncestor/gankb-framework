package pers.gankb.base.concurrent.producerandconsumer.bullets;

/**
 * @description: 子弹实体类
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class Bullets {

    private int bullets; // 子弹数量

    public Bullets(int bullets) {
        this.bullets = bullets;
    }

    /**
     * 向枪膛填装子弹
     */
    public synchronized void addBullets() {
        /**
         * 枪膛的子弹满，则不填装子弹，等待射击线程射击
         */
        while (this.bullets >= 20) {
            try {
                super.wait();
                System.out.println(Thread.currentThread().getName() + " - 等待射击线程射击...");
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        /**
         * 填装子弹一粒，然后唤醒射击线程射击
         */
        this.bullets++;
        super.notifyAll();
        System.out.println(Thread.currentThread().getName() + " - 唤醒射击...");
    }

    public synchronized void shootBullets() {
        /**
         * 枪膛已经没有子弹，则不射击，等待填装线程填子弹
         */
        while (this.bullets < 1) {
            try {
                super.wait();
                System.out.println(Thread.currentThread().getName() + " - 等待填装线程填子弹...");
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }

        /**
         * 射击，然后唤醒填装子弹
         */
        this.bullets--;
        super.notifyAll();
        System.out.println(Thread.currentThread().getName() + " - 唤醒填装子弹...");
    }
}
