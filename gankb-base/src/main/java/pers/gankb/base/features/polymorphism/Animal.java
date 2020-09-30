package pers.gankb.base.features.polymorphism;

/**
 * @description: 验证Java多态的父类
 * @author: Gandaif
 * @date: 2020/9/1
 */
public class Animal {
    int age = 20;
    static int legs = 2;

    public void eat() {
        System.out.println("动物在吃东西");
    }

    public void run() {
        System.out.println("动物在奔跑");
    }

    public final void fly() {
        System.out.println("动物可以飞，final不能被继承的");
    }

    public static void sleep() {
        System.out.println("动物可以睡觉，static静态的");
    }

    private void name() {
        System.out.println("动物的名字，私有的");
    }
}
