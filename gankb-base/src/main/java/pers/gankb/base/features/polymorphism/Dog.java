package pers.gankb.base.features.polymorphism;

/**
 * @description: 验证Java多态的子类
 * @author: Gandaif
 * @date: 2020/9/1
 */
public class Dog extends Animal {

    int age = 30;
    static int legs = 4;
    private String name = "狗狗";

    public void eat() {
        System.out.println("动物在吃东西，现在是狗狗在吃东西");
    }

    // final类型的方法不能被子类覆写
    /*public final void fly() {
        System.out.println("动物可以飞，final不能被继承的");
    }*/

    public static void sleep() {
        System.out.println("动物可以睡觉，static静态的，现在是狗狗在睡觉");
    }

    public static void main(String[] args) {
        /*多态存在的三个前提：
        1、有继承关系　　
        2、子类重写父类方法　　
        3、父类引用指向子类对象*/
        Animal animal = new Dog();
        animal.eat();
        animal.sleep();
        animal.run();
        animal.fly();

        System.out.println(animal.age);
        System.out.println(animal.legs);
        //System.out.println(animal.name);

        Dog dog = (Dog) animal;
        dog.eat();
        dog.sleep();
        dog.run();
        dog.fly();

        System.out.println(dog.age);
        System.out.println(dog.legs);
        System.out.println(dog.name);
    }
}
