package Collection.TreeSetDemo.DemoTwo;

import java.util.Comparator;

public class CompareByNameLen implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;

        int temp = p1.getName().length() - p2.getName().length();
        return temp == 0 ? p1.getAge() - p2.getAge() : temp;
    }
}
