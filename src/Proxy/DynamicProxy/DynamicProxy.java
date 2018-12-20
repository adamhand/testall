package Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    //被代理的对象
    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    /**
     * @param proxy：被代理的对象
     * @param method：被代理对象的方法
     * @param args：方法的参数
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * Proxy.newProxyInstance的三个参数：
     * 1. 被代理类的类加载器
     * 2. 该实现类的所有接口
     * 3. 动态代理对象
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
