package pers.gankb.base.concurrent.producerandconsumer.bullets;

/**
 * @description: 射击子弹线程-消费者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class ShootBulletsThread implements Runnable {

    private Bullets bullets;

    public ShootBulletsThread(Bullets bullets) {
        this.bullets = bullets;
    }

    @Override
    public void run() {
        while (true) {
            this.bullets.shootBullets();
            try {
                Thread.sleep(1000); // 模拟网络延时
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }
    }
}
