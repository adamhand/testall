package Thread.SynchronizedTest2;

public class Thread2 implements Runnable {
    @Override
    public void run() {
//        SynchronizedClass sClass = SynchronizedClass.getInstance();
//        sClass.method2();

//        SynchronizedClass sClass = new SynchronizedClass();
//        sClass.method2();

//        SynchronizedClass.staticMethod1();

//          SynchronizedClass.synchronizedClass.method2();

          SynchronizedClass.synchronizedClass.staticMethod1();
    }
}
