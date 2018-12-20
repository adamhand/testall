package ExtendsConstructor;

import javax.sound.midi.Soundbank;

public class SuperClass {
    int num;
    SuperClass(){
        num = 10;
        System.out.println("A fun run");
    }

    SuperClass(int x){
        System.out.println("B fun run "+x);
    }
}
