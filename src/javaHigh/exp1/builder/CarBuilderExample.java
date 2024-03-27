package javaHigh.exp1.builder;

/**
 * @author guiyi
 * @Date 2024/3/13 16:13:35
 * @ClassName javaHigh.exp2.CarBuilderExample
 * @function -->
 */
// 汽车类
class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String color;

    // 私有构造方法，仅允许通过 Builder 创建 Car 对象
    private Car(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
    }

    // 建造者类
    public static class Builder {
        private final String make;
        private final String model;
        private final int year;
        private String color;

        // 构造方法，传入必要参数
        public Builder(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        // 设置可选参数
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        // 构建 Car 对象
        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" + "make='" + make + '\'' + ", model='" + model + '\'' + ", year=" + year + ", color='" + color + '\'' + '}';
    }
}

// 示例使用
public class CarBuilderExample {
    public static void main(String[] args) {
        // 使用建造者创建汽车对象
        Car car = new Car.Builder("Toyota", "Camry", 2022)
                .color("Red")
                .build();

        // 输出汽车信息
        System.out.println(car);
    }
}

