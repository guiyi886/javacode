package javaHigh.exp7.first;

import java.util.EnumMap;
import java.util.List;

public class Vehicle {
    public enum Type {
        CAR, BIKE
    }

    private String model;
    private Type type;

    public Vehicle(String model, Type type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", type=" + type +
                '}';
    }

    public static void show(EnumMap<Type, List<Vehicle>> map) {
        for (Type t : Type.values()) {
            List<Vehicle> vehicles = map.get(t);

            if (vehicles != null) {
                System.out.println(t + ":");
                for (Vehicle v : vehicles) {
                    System.out.println(v);
                }
            }
        }
    }

}
