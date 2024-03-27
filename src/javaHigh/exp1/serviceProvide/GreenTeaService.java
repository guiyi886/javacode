package javaHigh.exp1.serviceProvide;

/**
 * @author guiyi
 * @Date 2024/3/13 14:41:00
 * @ClassName javaHigh.exp1.GreenTeaService
 * @function --> 绿茶服务类
 */
public class GreenTeaService implements TeaService {
    @Override
    public String produceTea() {
        return "Green Tea";
    }
}
