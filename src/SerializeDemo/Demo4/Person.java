package SerializeDemo.Demo4;

import java.io.Serializable;

public class Person extends Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String gender;

    public Person(String height, String weight, String name, String gender) {
        super(height, weight);
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String humanToString(){
        return super.toString();
    }
}
