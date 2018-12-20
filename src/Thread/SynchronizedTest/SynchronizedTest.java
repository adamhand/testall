package Thread.SynchronizedTest;


public class SynchronizedTest {

    public synchronized void test() {
    }

    public synchronized static void test1() {
    }

    public void test2() {
        synchronized (SynchronizedTest.class) {
            synchronized (this) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
