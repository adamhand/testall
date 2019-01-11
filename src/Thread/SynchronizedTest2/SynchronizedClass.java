package Thread.SynchronizedTest2;

public class SynchronizedClass {
    private static final SynchronizedClass instance = new SynchronizedClass();

    private SynchronizedClass(){}

    public static SynchronizedClass getInstance(){
        return instance;
    }

    /**
     * 静态对象，用来调用方法
     */
    public static SynchronizedClass synchronizedClass = new SynchronizedClass();

    public synchronized void method1(){
        for(int i = 0; i < 3; i++){
            System.out.println("method1 is running.......");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2(){
        for(int i = 0; i < 3; i++){
            System.out.println("method2 is running.......");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized void staticMethod1(){
        for(int i = 0; i < 3; i++){
            System.out.println("staticMethod1 is running.......");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized void staticMethod2(){
        for(int i = 0; i < 3; i++){
            System.out.println("staticMethod2 is running.......");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
