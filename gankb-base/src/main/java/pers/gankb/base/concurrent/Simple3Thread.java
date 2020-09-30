package pers.gankb.base.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @description: 通过实现 Callable 接口实现多线程主体类
 * @author: Gandaif
 * @date: 2020/9/10
 */
public class Simple3Thread implements Callable<String> {
    private String threadName;

    public Simple3Thread(String name) {
        this.threadName = name;
    }

    @Override
    public String call() throws Exception {
        // 在run方法中实现自己的逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + this.threadName + "运行，i = " + i + " ... 时间：" + System.currentTimeMillis());
        }
        return "所有线程都已经执行完毕，请指示...";
    }

    public static void main(String[] args) {
        /**
         * 这里看出，是通过 FutureTask 来实现 Callable 子类的线程创建，以及线程启动。而线程启动，必须是 Thread 类的 start() 方法。
         * 那么，FutureTask 为什么能完成这种任务，我们看它的类继承图发现，它也是 Runnable 接口的子类，并且在祖先接口 Future<T> 中获取了 Callable 接口 call() 方法的返回值。（见 Future<T> 接口的类注释）
         */
        FutureTask<String> task = new FutureTask<>(new Simple3Thread("A"));
        new Thread(task).start();
    }
}
