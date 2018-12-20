package Proxy.StaticProxy;

//业务具体实现类
public class HelloImp implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello" + name);
    }
}
