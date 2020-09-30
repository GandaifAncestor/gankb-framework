package pers.gankb.base.concurrent.producerandconsumer.bullets;

/**
 * @description: 装填、射击---主线程
 * @author: Gandaif
 * @date: 2020/9/16
 */
public class MainThread {
    public static void main(String[] args) {
        Bullets bullets = new Bullets(5);

        new Thread(new AddBulletsThread(bullets), "装子弹线程").start();
        new Thread(new ShootBulletsThread(bullets), "射子弹线程").start();
    }
}
