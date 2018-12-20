package PersonAndCar;

import javax.swing.*;

public class Car {
    private String color;
    private int value;

    public Car(){
        color = "red";
        value = 30000;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}
