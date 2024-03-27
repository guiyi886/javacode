package javaHigh.exp2.second;

/**
 * @author guiyi
 * @Date 2024/3/27 15:02:33
 * @ClassName javaHigh.exp2.second.Engine
 * @function -->
 */
public class Engine implements Cloneable, Comparable<Engine> {
    private int horsepower;
    private int cylinders;
    private String fuelType;

    public Engine(int horsepower, int cylinders, String fuelType) {
        this.horsepower = horsepower;
        this.cylinders = cylinders;
        this.fuelType = fuelType;
    }

    public Engine(Engine engine) {
        this.horsepower = engine.horsepower;
        this.cylinders = engine.cylinders;
        this.fuelType = engine.fuelType;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Engine other) {
        if (horsepower != other.horsepower) {
            return horsepower - other.horsepower;
        }
        return cylinders - other.cylinders;
    }
}


/*
ps:如果去掉Comparable<Engine>的<Engine>的话，那么compareTo方法就要这么写:
    @Override
    public int compareTo(Object other) {
        if (horsepower != ((Engine)other).horsepower) {
            return horsepower - ((Engine)other).horsepower;
        }
        return cylinders - ((Engine)other).cylinders;
    }
*/
