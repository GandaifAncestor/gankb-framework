package pers.gankb.base.concurrent;


/**
 * @description: 一个超级简单的线程主体类
 * @author: Gandaif
 * @date: 2020/9/8
 */
public class SimpleThread extends Thread {
    private String threadName;

    public SimpleThread (String threadName) {
        this.threadName = threadName;
    }

    /**
     * Java里面提供有一个java.lang.Thread的程序类，那么一个类只要继承了此类就表示这个类为我们线程的主体类，
     * 但是并不是说这个类就可以实现多线程处理，因为还需要覆写Thread类中提供的一个run()方法（public void run()），
     * 而这个方法就属于线程的主方法。
     *
     * 多线程要执行的功能都应该在run()方法中进行定义
     */
    @Override
    public void run() { // 线程主体方法
        // 在run方法中实现自己的逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + this.threadName + "运行，i = " + i + " ... 时间：" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        /**
         * 通过此时的调用你可以发现，虽然调用了start()方法，但是最终执行的是run()方法，并且所有的线程对象都是交替执行的。
         */
        new SimpleThread("A").start();
        new SimpleThread("B").start();
        new SimpleThread("C").start();
    }
}
