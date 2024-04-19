package proxy;

import java.lang.reflect.Proxy;

public class JdkProxy {
    public static Object getProxy(Object o) {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), (p, m, args) -> {
            System.out.println("jdk动态代理开始");
            Object result = m.invoke(o, args);
            System.out.println("jdk动态代理结束");
            return result;
        });
    }
}
