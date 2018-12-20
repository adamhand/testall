package Proxy.CGLibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {
    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy(){}

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    /**
     * @param o：目标类的实例
     * @param method：目标方法的反射对象
     * @param objects：目标方法的参数
     * @param methodProxy：代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object restult = methodProxy.invokeSuper(o, objects);
        after();
        return restult;
    }

    public static CGLibProxy getInstance(){
        return instance;
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.printf("After");
    }
}
