package ObjectCreateProcess;

public class SubClass extends SuperClass {
    int num = 8;
    SubClass(){
        super();
        System.out.println("sub cons run...."+ num);
    }

    void show(){
        System.out.println("sub show run....." + num);
    }
}
