package javaHigh.expOne.exp1;

/**
 * @author guiyi
 * @Date 2024/4/16 22:16:35
 * @ClassName javaHigh.expOne.exp1.SmartWatchTest
 * @function -->
 */
public class SmartWatchTest {
    public static void main(String[] args) {
        // 测试 FitnessWatch
        FitnessWatch watch1 = new FitnessWatch.Builder()
                .brand("brand1")
                .batteryLife(48)
                .waterResistant(true)
                .addSensor("Heart Rate")
                .addSensor("Step Counter")
                .GPS(true)
                .build();

        // 创建 watch2
        FitnessWatch watch2 = new FitnessWatch.Builder()
                .brand("brand2")
                .batteryLife(88)
                .waterResistant(true)
                .addSensor("Heart Rate")
                .addSensor("Step Counter")
                .GPS(true)
                .build();

        // 打印 watch1 和 watch2
        System.out.println("FitnessWatch 1: " + watch1);
        System.out.println("FitnessWatch 2: " + watch2);
        System.out.println("FitnessWatch 1 equals FitnessWatch 2: " + watch1.equals(watch2));

        // 测试 FashionWatch
        FashionWatch watch3 = new FashionWatch.Builder()
                .brand("Apple")
                .batteryLife(24)
                .waterResistant(false)
                .addSensor("Sleep Tracker")
                .addSensor("Calorie Counter")
                .material("Stainless Steel")
                .build();

        // 使用 clone 方法创建 watch4
        FashionWatch watch4 = watch3.clone();

        // 打印 watch3 和 watch4
        System.out.println("\nFashionWatch 3: " + watch3);
        System.out.println("FashionWatch 4: " + watch4);
        System.out.println("FashionWatch 3 equals FashionWatch 4: " + watch3.equals(watch4));

        // 测试 Comparable 接口
        System.out.println("\nComparing watch1 and watch2: " + watch1.compareTo(watch2));
        System.out.println("Comparing watch3 and watch4: " + watch3.compareTo(watch4));
    }
}

