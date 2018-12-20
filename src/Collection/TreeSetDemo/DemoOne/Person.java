package Collection.TreeSetDemo.DemoOne;

public class Person implements Comparable {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;

        int tem = this.age - p.age;
        return tem == 0 ? this.name.compareTo(p.name) : tem;
    }
}
