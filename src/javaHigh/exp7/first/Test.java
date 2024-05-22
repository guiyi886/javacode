package javaHigh.exp7.first;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 创建 EnumMap 来存储车辆类型和对应的车辆列表
        EnumMap<Vehicle.Type, List<Vehicle>> vehicleMap = new EnumMap<>(Vehicle.Type.class);

        // 初始化 EnumMap 中的列表
        for (Vehicle.Type type : Vehicle.Type.values()) {
            vehicleMap.put(type, new ArrayList<>());
        }

        // 添加 CAR 类型车辆
        vehicleMap.get(Vehicle.Type.CAR).add(new Vehicle("AAA", Vehicle.Type.CAR));
        vehicleMap.get(Vehicle.Type.CAR).add(new Vehicle("BBB", Vehicle.Type.CAR));

        // 添加 BIKE 类型车辆
        vehicleMap.get(Vehicle.Type.BIKE).add(new Vehicle("CCC", Vehicle.Type.BIKE));
        vehicleMap.get(Vehicle.Type.BIKE).add(new Vehicle("DDD", Vehicle.Type.BIKE));

        // 打印每种类型的所有车辆
        Vehicle.show(vehicleMap);
    }
}
