package pers.gankb.base.exception;

/**
 * @description: try{...}catch(.){...}finally{...}
 * 一、Java中使用try{...}catch(.){...}finally{...}来捕获异常、处理异常，及清理资源、释放连接和关闭管道流；
 * 二、规则：
 * 2-1）try代码块：监视代码执行过程，捕获异常，一旦发现异常则直接跳转到相应catch，如果没有catch，则直接跳到finally。（所以，如果既没有catch，也没有finally，则报错）
 * 2-2）catch代码块：可选执行代码块。如果没有发生异常，则不会执行；如果发生异常且匹配，则执行代码进行处理，或者向上抛出。
 * 2-3）finally代码块：必选执行代码块。不管有没有异常发生，都会执行，即使发生了OutOfMemoryError，也会执行。通常用于处理善后工作。
 * 三、规则：
 * 3-1）try代码块后可以跟零到多个catch代码块。
 * 3-2）多个catch代码块遵循粒度由细到粗的规则，即'具体-父类-Exception'。
 * 3-3）try代码块后只能有一个finally代码块。
 * 四、finally，如果finally没有执行，则有如下的情况：
 * 4-1）没有进入try代码块。
 * 4-2）进入了try代码块，但是发生了死锁或者死循环。
 * 4-3）进入了try代码块，但是执行了System.exit()方法。
 * 五、finally代码块，是在return语句后执行的：
 * 5-1）此时将要return的结果已经被暂存起来，等finally语句执行完后，再将之前暂存的结果返回。
 * 5-3）重要：这个return特指在catch代码块中的return语句，而正常的返回，比如没有发生catch的顺序返回（finally之后的），或者try代码块的返回，都不受此影响，因为都不执行finally）
 * 5-2）所以，在finally代码块中赋值，对返回结果没有影响。
 * 六、finally代码块中的return语句是不允许的，因为最终会执行finally代码块的return语句，对返回值造成了不可估量的影响。
 * 七、finally代码块，被专用于：清理资源、释放连接、关闭管道流等。
 * @author: Gandaif
 * @date: 2020/8/25
 */
public class TryCatchFinally {

    static int a = 10;
    static int b = 100;
    static int c = 1000;

    /**
     * finally代码块是必选执行的，不管是否发生异常（此方法为未发生异常情况）
     */
    public static void finallyExecute_1() {
        try {
            int a = 10 / 10;
            System.out.println("执行了try代码块，结果为：" + a);
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
        } finally {
            System.out.println("执行了finally代码块。");
        }
    }

    /**
     * finally代码块是必选执行的，不管是否发生异常（此方法为发生异常情况---算术异常）
     */
    public static void finallyExecute_2() {
        try {
            int b = 10 / 0;
            System.out.println("执行了try代码块，结果为：" + b);
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
        } finally {
            System.out.println("执行了finally代码块。");
        }
    }

    /**
     * 四、finally，如果finally没有执行，则有如下的情况：
     * 4-1）没有进入try代码块。
     * 4-2）进入了try代码块，但是发生了死锁或者死循环。
     * 4-3）进入了try代码块，但是执行了System.exit()方法。
     */
    public static void finallyDoNotExecute_1() {
        try {
            int b = 10 / 10;
            System.out.println("执行了try代码块，结果为：" + b);
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
        } finally {
            System.out.println("执行了finally代码块。");
        }
    }

    /**
     * 四、finally，如果finally没有执行，则有如下的情况：
     * 4-1）没有进入try代码块。
     * 4-2）进入了try代码块，但是发生了死锁或者死循环。
     * 4-3）进入了try代码块，但是执行了System.exit()方法。
     */
    public static void finallyDoNotExecute_2() {
        boolean returnFlag = true;
        if (returnFlag) {
            System.out.println("方法提前返回。");
            return;
        }
        try {
            int b = 10 / 10;
            System.out.println("执行了try代码块，结果为：" + b);
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
        } finally {
            System.out.println("执行了finally代码块。");
        }
    }

    /**
     * 五、finally代码块，是在return语句后执行的：
     * 5-1）此时将要return的结果已经被暂存起来，等finally语句执行完后，再将之前暂存的结果返回。
     * 5-2）所以，在finally代码块中赋值，对返回结果没有影响。
     * 5-3）重要：这个return特指在catch代码块中的return语句，而正常的返回，比如没有发生catch的顺序返回（finally之后的），或者try代码块的返回，都不受此影响，因为都不执行finally）
     */
    public static int finallyAssignment_1() {
        int temp = 1000;
        try {
            System.out.println("执行了try代码块，太懒了，什么都没做");
            //return temp;
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
        } finally {
            temp = 999;
            System.out.println("执行了finally代码块，此时temp为：" + temp);
        }
        System.out.println("方法返回值前夕，此时temp为：" + temp);
        return ++temp;
    }

    public static int finallyAssignment_2() {
        int temp = 1000;
        try {
            throw new Exception();
        } catch (ArithmeticException e) {
            System.out.println("发生了ArithmeticException异常" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
            return ++temp;
        } finally {
            temp = 999;
            System.out.println("执行了finally代码块，此时temp为：" + temp);
        }
        return temp;
    }

    /**
     * finally代码块中的return语句是不允许的，因为最终会执行finally代码块的return语句，对返回值造成了不可估量的影响。
     *
     * @return
     */
    public static int finallyreturn() {
        try {
            System.out.println("执行了try代码块");
            return ++a;
        } catch (Exception e) {
            System.out.println("发生了Exception异常" + e.getMessage());
            return ++b;
        } finally {
            System.out.println("执行了finally代码块。");
            return ++c;
        }
    }

    /**
     * 一个try{}后面只能有一个finally{}，否则编译出错
     */
    public static void finallyCount() {
        try {

        } finally {

        } /*finally { // 编译错误，IDE编译器提示：'finally' without 'try'

        }*/
    }

    public static void main(String[] args) {
        //finallyExecute_1();
        //finallyExecute_2();

        //finallyDoNotExecute_1();
        //finallyDoNotExecute_2();

        //int result = finallyAssignment_1();
        //int result = finallyAssignment_2();
        //System.out.println("返回值，result：" + result);

        int result = finallyreturn();
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("result:" + result);
    }

}
