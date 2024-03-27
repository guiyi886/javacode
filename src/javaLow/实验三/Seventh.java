package javaLow.实验三;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// 国家类
class Country implements Comparable<Country> {
    String name;
    long GDP2020;
    long COVID19;

    public Country(String name, long GDP2020, long COVID19) {
        this.name = name;
        this.GDP2020 = GDP2020;
        this.COVID19 = COVID19;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15d %-15d", name, GDP2020, COVID19);
    }

    @Override
    public int compareTo(Country c) {
        return Long.compare(this.COVID19, c.COVID19);
    }
}

// Comparator接口实现，按COVID19从小到大排序
class COVID19Comparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
        return Long.compare(c1.COVID19, c2.COVID19);
    }

}

public class Seventh {
    public static void main(String[] args) {
        // 创建一个 TreeMap，并通过 Comparable 接口实现进行排序
        Map<Country, String> countryInfoMapByComparable = new TreeMap<>();

        // 添加国家信息
        countryInfoMapByComparable.put(new Country("美国", 20932750, 44918565), "");
        countryInfoMapByComparable.put(new Country("中华人民共和国", 14722837, 124924), "");
        countryInfoMapByComparable.put(new Country("日本", 5048688, 1706675), "");
        countryInfoMapByComparable.put(new Country("德国", 3803014, 4284354), "");
        countryInfoMapByComparable.put(new Country("英国", 2710970, 8006660), "");
        countryInfoMapByComparable.put(new Country("印度", 2708770, 33893002), "");
        countryInfoMapByComparable.put(new Country("法国", 2598907, 7038701), "");
        countryInfoMapByComparable.put(new Country("意大利", 1884935, 4689341), "");
        countryInfoMapByComparable.put(new Country("加拿大", 1643408, 1647142), "");
        countryInfoMapByComparable.put(new Country("韩国", 1630871, 323379), "");

        // 输出按COVID19从小到大排序的国家信息
        System.out.println("\n按COVID19从小到大排序的国家信息（通过Comparable接口实现）：");
        for (Map.Entry<Country, String> entry : countryInfoMapByComparable.entrySet()) {
            System.out.println(entry.getKey());
        }

        // 创建一个 TreeMap，并通过 COVID19Comparator 对象进行排序
        Map<Country, String> countryInfoMapByComparator = new TreeMap<>(new COVID19Comparator());

        // 添加国家信息
        countryInfoMapByComparator.put(new Country("美国", 20932750, 44918565), "");
        countryInfoMapByComparator.put(new Country("中华人民共和国", 14722837, 124924), "");
        countryInfoMapByComparator.put(new Country("日本", 5048688, 1706675), "");
        countryInfoMapByComparator.put(new Country("德国", 3803014, 4284354), "");
        countryInfoMapByComparator.put(new Country("英国", 2710970, 8006660), "");
        countryInfoMapByComparator.put(new Country("印度", 2708770, 33893002), "");
        countryInfoMapByComparator.put(new Country("法国", 2598907, 7038701), "");
        countryInfoMapByComparator.put(new Country("意大利", 1884935, 4689341), "");
        countryInfoMapByComparator.put(new Country("加拿大", 1643408, 1647142), "");
        countryInfoMapByComparator.put(new Country("韩国", 1630871, 323379), "");

        // 输出按COVID19从小到大排序的国家信息
        System.out.println("按COVID19从小到大排序的国家信息（通过Comparator接口实现）：");
        for (Map.Entry<Country, String> entry : countryInfoMapByComparator.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
