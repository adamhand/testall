package ConstructorTest.Test1;

public class SuperClass {
    private String name;
    public SuperClass(){
        this("super");
        System.out.println("super class ()");
    }

    public SuperClass(String name){
        this.name = name;
        System.out.println("super class ("+name+")");
    }
}
