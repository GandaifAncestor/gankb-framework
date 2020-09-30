package pers.gankb.base.java8;

/**
 * @description: Java8 新特性 Lambda表达式的特性
 * @author: Gandaif
 * @date: 2020/9/7
 */
public class LambdaFeature {

    private static final int num1 = 1; // 外层变量

    public static void main(String[] args) {
        final int num2 = 2; // 外层变量
        int num3 = 2; // 外层变量

        /**
         * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
         * 也可以直接在 lambda 表达式中访问外层的局部变量，lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
         *
         * 也就是说，在 lambda 表达式中访问外层的局部变量，要么是 final 修饰的，要么不能在后面修改。
         */
        Convert<String, Integer> print = (param) -> System.out.println(String.valueOf(param + num1));
        print.convert(10);

        Convert<String, Integer> print2 = (param) -> System.out.println(String.valueOf(param + num2));
        print.convert(10);

        Convert<String, Integer> print3 = (param) -> System.out.println(String.valueOf(param + num3));
        print.convert(10);

        // num3 = 3; //也就是说，在 lambda 表达式中访问外层的局部变量，要么是 final 修饰的，要么不能在后面修改。
    }

    /**
     * Java类内部可以定义接口，作用可以看做是对类功能的补充。
     * 类里面包括两部分：一部分是固定的，一部分是可以变化的，而可变化的这部分可以定义为一个接口。
     * 接口从一定程度上说，也是一种特殊的抽象类。
     * @param <T1>
     * @param <T2>
     */
    public interface Convert<T1, T2> {
        void convert(int i);
    }
}
