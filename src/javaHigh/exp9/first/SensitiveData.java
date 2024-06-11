package javaHigh.exp9.first;


import java.util.Date;

public class SensitiveData {
    private Date date;

    // 构造函数接收一个 Date 对象作为输入，并进行保护性拷贝和日期有效性检查
    public SensitiveData(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        Date now = new Date();
        if (date.after(now)) {
            throw new IllegalArgumentException("Date cannot be in the future");
        }
        // 保护性拷贝
        this.date = new Date(date.getTime());
    }

    // 返回日期的一个保护性拷贝
    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public static void main(String[] args) {
        try {
            // 测试用例
            Date validDate = new Date(System.currentTimeMillis() - 1000); // 1秒前的时间
            SensitiveData data = new SensitiveData(validDate);
            System.out.println("Stored Date: " + data.getDate());

            // 尝试修改返回的日期对象
            Date retrievedDate = data.getDate();
            retrievedDate.setTime(System.currentTimeMillis() + 100000); // 修改为未来时间

            // 检查原始日期是否未受影响
            System.out.println("Stored Date after modification attempt: " + data.getDate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

