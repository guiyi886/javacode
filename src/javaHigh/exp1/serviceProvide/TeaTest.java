package javaHigh.exp1.serviceProvide;

/**
 * @author guiyi
 * @Date 2024/3/13 14:49:13
 * @ClassName javaHigh.exp1.TeaTest
 * @function -->
 */
public class TeaTest {
    public static void main(String[] args) {
        // 注册绿茶服务和红茶服务
        TeaServiceProvider.registerService("Green Tea", new GreenTeaService());
        TeaServiceProvider.registerService("Black Tea", new BlackTeaService());

        // 获取绿茶服务并生产茶叶
        TeaService greenTeaService = TeaServiceProvider.getTeaService("Green Tea");
        System.out.println(greenTeaService.produceTea());

        // 获取红茶服务并生产茶叶
        TeaService blackTeaService = TeaServiceProvider.getTeaService("Black Tea");
        System.out.println(blackTeaService.produceTea());
    }
}
