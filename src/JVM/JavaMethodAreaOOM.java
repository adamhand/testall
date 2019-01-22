package JVM;

/**
 * VM args:-XX:PermSize=10m -XX:MaxPermSize=10m
 */
public class JavaMethodAreaOOM {
    static class OOMObject{

    }

//    public static void Main(String[] args) {
//        while (true){
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setCallback(new MethodInterceptor() {
//                @Override
//                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                    return methodProxy.invokeSuper(o, args);
//                }
//            });
//            enhancer.create();
//        }
//    }
}
