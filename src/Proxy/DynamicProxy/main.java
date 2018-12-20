package Proxy.DynamicProxy;

import Proxy.StaticProxy.Hello;
import Proxy.StaticProxy.HelloImp;

public class main {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImp());
        Hello hello = dynamicProxy.getProxy();

        hello.say("Jack");
    }
}
