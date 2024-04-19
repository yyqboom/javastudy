package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    //维护一个目标对象
    private Object target;
    //构造器，传入目标对象
    public CglibProxy(Object target) {
        this.target = target;
    }
    public Object getProxy(Object o) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(o.getClass().getInterfaces());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式---开始");
        Object returnVal = methodProxy.invokeSuper(o, objects);
        System.out.println("Cglib代理模式---提交");
        return returnVal;
    }
}
