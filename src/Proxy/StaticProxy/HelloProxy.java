package Proxy.StaticProxy;

//代理类
public class HelloProxy implements Hello{
    private HelloImp helloImp;

    public HelloProxy(){
        helloImp = new HelloImp();
    }

    @Override
    public void say(String name) {
        before();
        helloImp.say(name);
        after();
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
