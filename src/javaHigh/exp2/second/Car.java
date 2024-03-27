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
