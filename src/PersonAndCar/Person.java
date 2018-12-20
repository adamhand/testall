package PersonAndCar;

import javax.sound.midi.Soundbank;

public class Person {
    private int age;
    private String name;
    private Car car;

    public Person(Car car){
        this.car = car;
    }

    public void show(){
        System.out.println(car.getColor()+"...."+car.getValue());
    }
}
