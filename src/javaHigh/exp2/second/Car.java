package javaHigh.exp2.second;

/**
 * @author guiyi
 * @Date 2024/3/27 14:59:32
 * @ClassName javaHigh.exp2.second.Car
 * @function -->
 */
public class Car implements Cloneable {
    private String licensePlate;
    private String model;
    private String color;
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public Car(String licensePlate, String model, String color, Engine engine) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public Car(Car car) {
        this.licensePlate = car.licensePlate;
        this.model = car.model;
        this.color = car.color;
        this.engine = new Engine(car.engine);
    }

    @Override
    public Car clone() {
        try {
            Car cloned = (Car) super.clone();

            // 深拷贝Engine对象
            cloned.engine = this.engine.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int compareTo(Car other) {
        return this.engine.compareTo(other.engine);
    }
}

/*
在Java中，引用、浅拷贝和深拷贝是涉及对象复制和对象引用的概念。

引用： 在Java中，对象的引用是指向对象的指针或地址。当你创建一个对象时，实际上是在内存中分配了一块存储空间，并返回了对该空间的引用。
这个引用可以存储在变量中，称为对象引用。通过引用，你可以操作对象的属性和调用方法。

浅拷贝： 浅拷贝是一种对象复制方式，它创建一个新对象，但是只复制原始对象中的基本类型字段和对象引用。
也就是说，新对象中的对象引用仍然指向原始对象中相同的对象。如果原始对象中的字段是基本类型，则复制的值与原始对象相同。
但如果原始对象中的字段是引用类型，则复制的是引用，而不是引用指向的对象。这意味着，浅拷贝创建的新对象与原始对象共享一部分数据。

深拷贝： 深拷贝也是一种对象复制方式，它创建一个新对象，并且递归地复制原始对象中的所有字段，包括基本类型字段和对象引用字段。
换句话说，深拷贝创建的新对象与原始对象完全独立，它们之间没有任何共享的数据。
如果原始对象中的字段是引用类型，则深拷贝会复制引用指向的对象，而不是仅复制引用本身。

在使用浅拷贝和深拷贝时，需要根据需求和对象结构来选择适当的复制方式。
通常，当对象包含嵌套的引用类型字段时，深拷贝更适合，因为它能够完整复制对象的所有内容，而不会共享任何数据。
*/
