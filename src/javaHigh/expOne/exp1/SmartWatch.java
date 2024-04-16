package javaHigh.expOne.exp1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author guiyi
 * @Date 2024/4/16 20:44:32
 * @ClassName javaHigh.expOne.exp1.SmartWatch
 * @function -->
 */
public abstract class SmartWatch implements Comparable<SmartWatch>, Cloneable {
    private String mBrand;
    private int mBatteryLife;
    private boolean mWaterResistant;
    private ArrayList<String> mSensors;

    public SmartWatch(Builder<?> builder) {
        this.mBrand = builder.mBrand;
        this.mBatteryLife = builder.mBatteryLife;
        this.mWaterResistant = builder.mWaterResistant;
        this.mSensors = builder.mSensors;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String mBrand;
        private int mBatteryLife;
        private boolean mWaterResistant;
        private ArrayList<String> mSensors = new ArrayList<>();

        // 设置品牌
        public T brand(String brand) {
            this.mBrand = brand;
            return self();
        }

        // 设置电池寿命
        public T batteryLife(int batteryLife) {
            this.mBatteryLife = batteryLife;
            return self();
        }

        // 设置是否防水
        public T waterResistant(boolean waterResistant) {
            this.mWaterResistant = waterResistant;
            return self();
        }

        // 添加传感器
        public T addSensor(String sensor) {
            this.mSensors.add(sensor);
            return self();
        }

        protected abstract T self();

        public abstract SmartWatch build();
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "SmartWatch{" +
                "mBrand='" + mBrand + '\'' +
                ", mBatteryLife=" + mBatteryLife +
                ", mWaterResistant=" + mWaterResistant +
                ", mSensors=" + mSensors +
                '}';
    }

    @Override
    public SmartWatch clone() {
        try {
            // Object类的clone方法返回的是一个Object类型的对象
            SmartWatch cloned = (SmartWatch) super.clone();
            cloned.mSensors = new ArrayList<>(this.mSensors);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartWatch that = (SmartWatch) o;
        return mBatteryLife == that.mBatteryLife &&
                mWaterResistant == that.mWaterResistant &&
                Objects.equals(mBrand, that.mBrand) &&
                Objects.equals(mSensors, that.mSensors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mBrand, mBatteryLife, mWaterResistant, mSensors);
    }

    @Override
    public int compareTo(SmartWatch o) {
        return Integer.compare(this.mBatteryLife, o.mBatteryLife);
    }
}
