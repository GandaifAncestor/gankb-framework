package pers.gankb.base.concurrent.producerandconsumer.bullets;

/**
 * @description: 子弹装填线程-生产者
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class AddBulletsThread implements Runnable {

    private Bullets bullets;

    public AddBulletsThread(Bullets bullets) {
        this.bullets = bullets;
    }

    @Override
    public void run() {
        while (true) {
            this.bullets.addBullets();
            try {
                Thread.sleep(1000); // 模拟网络延时
            } catch (InterruptedException e) {
                System.out.println("发生了 InterruptedException 异常");
            }
        }
    }
}
