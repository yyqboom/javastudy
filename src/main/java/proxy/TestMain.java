package proxy;

import proxy.base.Eat;
import proxy.base.IAction;
import proxy.base.IEcho;

public class TestMain {
    public static void main(String[] args) {
        Eat iAction = new Eat();
        iAction.action();
        iAction.echo();
        //静态
        IAction staticProxy = new StaticProxy(iAction);
        staticProxy.action();
        // 动态jdk
        Object jdkProxy = JdkProxy.getProxy(iAction);
        ((IAction)jdkProxy).action();
        ((IEcho)jdkProxy).echo();
        // 动态cglib
        CglibProxy cglibProxy = new CglibProxy(iAction);
        IAction eat = (IAction) cglibProxy.getProxy(iAction);
        eat.action();
//        eat.echo();

    }
}
