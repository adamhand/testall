package Thread.SynchronizedTest2;

public class Thread1 implements Runnable {
    @Override
    public void run() {
//        SynchronizedClass sClass = SynchronizedClass.getInstance();
//        sClass.method1();

//        SynchronizedClass sClass = new SynchronizedClass();
//        sClass.method1();

//        SynchronizedClass.staticMethod2();

//        SynchronizedClass.synchronizedClass.method1();

        SynchronizedClass.synchronizedClass.method1();
    }
}
