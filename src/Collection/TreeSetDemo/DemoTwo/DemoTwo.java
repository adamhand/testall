package Collection.TreeSetDemo.DemoTwo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 先按照姓名长度排序，如果相同再按照年龄大小排序。
 */
public class DemoTwo {
    public static void main(String[] args) {
        Person p1 = new Person("bob",12);
        Person p2 = new Person("bobbo",14);
        Person p3 = new Person("bobbobo",15);
        Person p4 = new Person("bobboboobo",10);
        Person p5 = new Person("bob",10);

        TreeSet t = new TreeSet(new CompareByNameLen());
        t.add(p1);
        t.add(p2);
        t.add(p3);
        t.add(p4);
        t.add(p5);

        Iterator iterator = t.iterator();
        while (iterator.hasNext())
        {
            Person p = (Person) iterator.next();
            System.out.println(p.getAge()+ " "+p.getName());
        }
    }
}
