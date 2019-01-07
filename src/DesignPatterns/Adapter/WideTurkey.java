package DesignPatterns.Adapter;

public class WideTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble......");
    }
}
