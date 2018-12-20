package Proxy.CGLibProxy;

import Proxy.StaticProxy.Hello;
import Proxy.StaticProxy.HelloImp;

public class main {
    public static void main(String[] args) {
        HelloImp helloImp = CGLibProxy.getInstance().getProxy(HelloImp.class);

        helloImp.say("Jack");
    }
}
