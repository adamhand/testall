package ExtendsConstructor;

public class SubClass extends SuperClass {
    int num;

    SubClass(){
        System.out.println("C fun run");
    }

    SubClass(int x){
        this();
        System.out.println("D fun run "+ x);
    }
}
