package javaHigh.exp2.second;

/**
 * @author guiyi
 * @Date 2024/3/27 14:59:40
 * @ClassName javaHigh.exp2.second.CarTest
 * @function -->
 */
public class CarTest {
    public static void main(String[] args) {
        // 创建 Engine 对象
        Engine engine1 = new Engine(200, 6, "Gasoline");
        Engine engine2 = new Engine(200, 8, "Gasoline");

        // 使用构造方法创建一个 Car 对象
        Car car1 = new Car("ABC123", "model1", "Blue", engine1);

        // 克隆 Car 对象
        Car car2 = car1.clone();

        // 验证 car1 和 car2 是否是不同的对象
        System.out.println("car1 和 car2 是否是不同的对象？ " + (car1 != car2));

        // 验证 car1 和 car2 是否具有相同的值
        System.out.println("car1 和 car2 是否相等？ " + car1.equals(car2));
        boolean engineEquals = car1.getEngine() == car2.getEngine();
        System.out.println("car1 和 car2 的engine是否是同一个？ " + engineEquals);

        // 基于引擎性能比较 car1 和 car3
        Car car3 = new Car("ABC123", "model1", "Blue", engine2);
        int comparison = car1.compareTo(car3);
        System.out.println("car1 的引擎性能相比于 car3： " + comparison);

        // 使用复制构造器创建一个新的 Car 对象
        Car car4 = new Car(car1);

        // 验证 car1 和 car3 是否具有相同的值
        System.out.println("car1 和 car3 是否相等？ " + car1.equals(car4));
    }
}

