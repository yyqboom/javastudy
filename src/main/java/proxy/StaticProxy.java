package proxy;

import proxy.base.IAction;

public class StaticProxy implements IAction {
    private IAction iAction;

    public StaticProxy(IAction iAction) {
        this.iAction = iAction;
    }
    @Override
    public void action() {
        System.out.println("静态代理前");
        this.iAction.action();
        System.out.println("静态代理后");
    }
}
