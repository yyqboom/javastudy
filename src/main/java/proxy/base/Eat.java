package proxy.base;

public class Eat implements IAction, IEcho{
    @Override
    public void action() {
        System.out.println("吃");
    }

    @Override
    public void echo() {
        System.out.println("饱了");
    }
}
