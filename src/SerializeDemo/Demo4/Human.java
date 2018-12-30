package SerializeDemo.Demo4;

import java.io.Serializable;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String height;
    protected String weight;

    public Human() {
//        height = "200";
//        weight = "100";
    }

    public Human(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
