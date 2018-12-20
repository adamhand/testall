package PersonAndCar;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Person p = new Person(car);

        p.show();
    }
}
