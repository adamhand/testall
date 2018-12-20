package Thread.EmployerTest;

public class Main {
    public static void main(String[] args) {

        Employer my = new Employer();
        Thread t1 = new Thread(my, "前门");

        Thread t2 = new Thread(my, "后门");
        t1.start();// 同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
        // new Thread(my, "E").start();
        t2.start();
        if (t1.isAlive()||t2.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("前门总计:"+Employer.getFront()+"人\t后门总计:"+Employer.getBack()+"人\t总计："+(100-Employer.getCount())+"人");
    }
}
