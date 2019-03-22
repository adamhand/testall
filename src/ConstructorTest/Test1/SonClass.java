package ConstructorTest.Test1;

public class SonClass extends SuperClass {
    public SonClass(){
        this("son");
        System.out.println("son class ()");
    }

    public SonClass(String name){
        System.out.println("son class ("+name+")");
    }
}
