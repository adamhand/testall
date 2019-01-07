package DesignPatterns.Adapter;

public class Main {
    public static void main(String[] args) {
        Turkey turkey = new WideTurkey();
        Duck duck = new TurkeyAdapter(turkey);

        duck.quack();
    }
}
