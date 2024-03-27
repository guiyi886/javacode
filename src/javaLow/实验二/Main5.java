package javaLow.实验二;

import java.text.DecimalFormat;
import java.util.Arrays;

// 旅行推荐指数类
class TravelIndex {
    private String countryName;         // 国家名字
    private double countryPersonNum;    // 国家人口数
    private COVID19Status covidStatus;  // 新冠疫情现状类对象

    // 构造方法，用于初始化国家名称、人口数量和疫情数据
    public TravelIndex(String country, int personNum, COVID19Status status) {
        countryName = country;
        countryPersonNum = personNum;
        covidStatus = status;
    }

    // 计算旅行推荐指数
    public double calculateTravelIndex() {
        // 计算死亡率（死亡人数除以总人口）
        double deathRate = covidStatus.getTotalDeaths() / countryPersonNum;

        // 计算感染率（确诊人数除以总人口）
        double confirmedRate = covidStatus.getTotalConfirmedCases() / countryPersonNum;

        // 计算死亡率在感染率中的比例（死亡人数除以确诊人数）
        double deathRateInConfirmed = covidStatus.getTotalDeaths() / covidStatus.getTotalConfirmedCases();

        // 返回旅行推荐指数
        return 3 - (deathRate + confirmedRate + deathRateInConfirmed);
    }

    // 获取国家名称
    public String getCountryName() {
        return countryName;
    }
}

// 新冠疫情现状类
class COVID19Status {
    private double totalConfirmedCases; // 总感染数
    private double totalDeaths;         // 总死亡数

    // 构造方法，用于初始化累计确诊和死亡人数
    public COVID19Status(int confirmed, int deaths) {
        totalConfirmedCases = confirmed;
        totalDeaths = deaths;
    }

    // 获取累计确诊人数
    public double getTotalConfirmedCases() {
        return totalConfirmedCases;
    }

    // 获取累计死亡人数
    public double getTotalDeaths() {
        return totalDeaths;
    }
}

public class Main5 {
    public static void main(String[] args) {
        // 创建各国的疫情数据COVID19Status对象
        COVID19Status chinaStatus = new COVID19Status(100000, 4000);
        COVID19Status japanStatus = new COVID19Status(30000, 1000);
        COVID19Status singaporeStatus = new COVID19Status(5000, 50);
        COVID19Status usaStatus = new COVID19Status(5000000, 80000);
        COVID19Status ukStatus = new COVID19Status(2000000, 60000);
        COVID19Status russiaStatus = new COVID19Status(1500000, 20000);

        // 创建 TravelIndex 对象，计算旅行推荐指数
        TravelIndex chinaIndex = new TravelIndex("中国", 1400000000, chinaStatus);
        TravelIndex japanIndex = new TravelIndex("日本", 126000000, japanStatus);
        TravelIndex singaporeIndex = new TravelIndex("新加坡", 5800000, singaporeStatus);
        TravelIndex usaIndex = new TravelIndex("美国", 331000000, usaStatus);
        TravelIndex ukIndex = new TravelIndex("英国", 68000000, ukStatus);
        TravelIndex russiaIndex = new TravelIndex("俄罗斯", 146000000, russiaStatus);

        // 创建 TravelIndex 数组来存储国家的数据
        TravelIndex[] travelIndices = {chinaIndex, japanIndex, singaporeIndex, usaIndex, ukIndex, russiaIndex};

        // 对数组进行按旅行推荐指数排序（降序排序）
        Arrays.sort(travelIndices, (b, a) -> Double.compare(a.calculateTravelIndex(), b.calculateTravelIndex()));

        // 保留三位小数输出按旅行推荐指数排序后的国家名称和数值
        for (TravelIndex index : travelIndices) {
            // 创建DecimalFormat对象，指定保留三位小数的格式
            DecimalFormat decimalFormat = new DecimalFormat("0.000");

            // 使用format方法将数字格式化为字符串
            String formattedIndex = decimalFormat.format(index.calculateTravelIndex());

            System.out.println(index.getCountryName() + "的旅行推荐指数为：" + formattedIndex);
        }
    }
}
