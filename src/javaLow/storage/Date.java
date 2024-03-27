package javaLow.storage;

/**
 * 表示日期的类
 */
public class Date {
    private int year;   // 年份
    private int month;  // 月份
    private int day;    // 天数
    private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 每月的天数

    /**
     * 默认构造函数，初始化为1970年1月1日
     */
    public Date() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    /**
     * 构造函数，根据给定的年、月、日初始化日期
     * 如果日期不合法，则默认为1970年1月1日
     *
     * @param y 年份
     * @param m 月份
     * @param d 天数
     */
    public Date(int y, int m, int d) {
        if (isValid(y, m, d)) {
            this.year = y;
            this.month = m;
            this.day = d;
        } else {
            this.year = 1970;
            this.month = 1;
            this.day = 1;
        }
    }

    /**
     * 判断是否为闰年
     *
     * @param y 年份
     * @return 如果是闰年，返回true，否则返回false
     */
    public boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
     * 判断日期是否合法
     *
     * @param y 年份
     * @param m 月份
     * @param d 天数
     * @return 如果日期合法，返回true，否则返回false
     */
    public boolean isValid(int y, int m, int d) {
        if (y < 1970 || m < 1 || m > 12) return false;
        if (isLeap(y) && m == 2) {
            return d >= 0 && d <= days[m] + 1;
        } else {
            return d >= 0 && d <= days[m];
        }
    }

    /**
     * 增加指定天数后的日期
     *
     * @param ds 要增加的天数
     * @return 增加后的日期对象
     */
    public Date incDays(int ds) {
        if (ds < 0) return decDays(-ds);
        if (ds == 0) return this;

        int newy, newm, newd, curDays;
        newd = this.day + ds;
        newm = this.month;
        newy = this.year;
        while (newd > daysInMonth(newy, newm)) {
            newd -= daysInMonth(newy, newm);
            newm++;
            if (newm > 12) {
                newm = 1;
                newy++;
            }
        }
        return new Date(newy, newm, newd);
    }

    /**
     * 减少指定天数后的日期
     *
     * @param ds 要减少的天数
     * @return 减少后的日期对象
     */
    public Date decDays(int ds) {
        if (ds < 0) return incDays(-ds);
        if (ds == 0) return this;

        int newy, newm, newd;
        newd = this.day - ds;
        newm = this.month;
        newy = this.year;
        while (newd <= 0) {
            newm--;
            if (newm <= 0) {
                newm = 12;
                newy--;
            }
            newd += daysInMonth(newy, newm);
        }
        return new Date(newy, newm, newd);
    }

    /**
     * 获取指定年月的天数
     *
     * @param year  年份
     * @param month 月份
     * @return 该月的天数
     */
    private int daysInMonth(int year, int month) {
        if (month == 2 && isLeap(year)) {
            return days[month - 1] + 1;
        } else {
            return days[month - 1];
        }
    }

    /**
     * 主方法，用于测试
     *
     * @param args 传入的命令行参数
     */
    public static void main(String[] args) {
        Date d = new Date(2020, 11, 23);
        Date d1 = d.incDays(-3650);
        Date d2 = d1.decDays(-3650);
        Date d3 = d2.incDays(1);
        Date d4 = d1.incDays(3650);
        System.out.println(d.day);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
    }
}
