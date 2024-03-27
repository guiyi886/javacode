package javaHigh.exp1.serviceProvide;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author guiyi
 * @Date 2024/3/13 14:44:33
 * @ClassName javaHigh.exp1.TeaServiceProvider
 * @function --> 茶叶服务提供者类
 */
public class TeaServiceProvider {
    // 私有的意味着它只能在当前类中访问，静态的意味着它属于类而不是实例。
    // 不可变的意味着一旦初始化后，它的引用不会再改变，但是它的内容可以改变（因为是一个可变对象，只是引用不可变）。
    private static final Map<String, TeaService> TEA_SERVICE_PROVIDER = new ConcurrentHashMap<>();

    // 注册茶叶服务
    public static void registerService(String teaName, TeaService teaService) {
        TEA_SERVICE_PROVIDER.put(teaName, teaService);
    }

    // 获取茶叶服务
    public static TeaService getTeaService(String teaName) {
        TeaService teaService = TEA_SERVICE_PROVIDER.get(teaName);
        if (teaService == null) {
            throw new IllegalArgumentException("No tea service registered for " + teaName);
        }
        return teaService;
    }
}
