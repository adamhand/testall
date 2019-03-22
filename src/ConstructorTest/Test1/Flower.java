package ConstructorTest.Test1;

/**
 * Java编程思想上的一个例子的扩展
 */
public class Flower extends SuperFlower {
    int petalCount = 0;
    String s = "init value";

    Flower(int petais){
        this(new soutClass());
        petalCount = petais;
        System.out.println("Constructor W/ int arg only. petalCount= "+ petalCount);
    }

    Flower(String s, int petals){
        this(petals);
        this.s = s;
        System.out.println("string & int args");
    }

    Flower(){
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    Flower(soutClass sc){

    }

    void printPetalCount(){
        System.out.println("petalCount = "+ petalCount + " s = "+s);
    }

    public static void main(String[] args) {
        Flower f = new Flower();
        f.printPetalCount();
    }

    private static class soutClass {
        soutClass(){
            System.out.println("i am sout class");
        }
    }
}
