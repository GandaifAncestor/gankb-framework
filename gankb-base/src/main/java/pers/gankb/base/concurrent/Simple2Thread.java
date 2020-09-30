package pers.gankb.base.concurrent;

/**
 * @description: 通过实现 Runnable 接口实现多线程主体类
 * @author: Gandaif
 * @date: 2020/9/10
 */
public class Simple2Thread implements Runnable {
    private String threadName;

    public Simple2Thread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        // 在run方法中实现自己的逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + this.threadName + "运行，i = " + i + " ... 时间：" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        /**
         * 由于此时不再继承 Thread 父类了，那么对于此时的线程子类中也就不再支持有 start() 这个继承的方法，
         * 可是如果不用 start() 方法是无法进行多线程启动的。
         *
         * 在上篇文章中【Thread类】中，看源码发现，Thread 类所提供了一个构造方法：public Thread(Runnable target)
         *
         * 所以，需要通过这个构造方法启动线程:
         */
        Thread threadA = new Thread(new Simple2Thread("A"));
        threadA.start();
        new Thread(new Simple2Thread("B")).start();
        new Thread(new Simple2Thread("C")).start();
    }

    /**
     * 可以发现从JDK1.8开始，Runnable接口使用了函数式接口定义，所以也可以直接使用Lambda表达式进行线程类实现。
     * @param args
     */
    public static void main2(String[] args) {
        for (int i = 0; i < 3; i++) {
            String threadNameLocal = "对象-" + i;

            // 方法一，略显复杂
            /*Runnable runnable = () -> {
                for (int t = 0; t < 5; t++) {
                    System.out.println("线程" + threadNameLocal + "运行，t = " + t + " ... 时间：" + System.currentTimeMillis());
                }
            };
            new Thread(runnable).start();*/

            // 方法二，简洁版
            new Thread(() -> {
                for (int t = 0; t < 5; t++) {
                    System.out.println("线程" + threadNameLocal + "运行，t = " + t + " ... 时间：" + System.currentTimeMillis());
                }
            }).start();
        }
    }
}
