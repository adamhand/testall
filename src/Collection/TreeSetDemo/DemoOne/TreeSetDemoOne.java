package Collection.TreeSetDemo.DemoOne;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 是按照自然顺序来排序的，先按照年龄，然后按照名字的字典顺序
 */
public class TreeSetDemoOne {
    public static void main(String[] args) {
        Person p1 = new Person(12, "bob");
        Person p2 = new Person(13,"juliy");
        Person p3 = new Person(14,"jack");
        Person p4 = new Person(12,"rose");

        TreeSet t = new TreeSet();
        t.add(p1);
        t.add(p2);
        t.add(p3);
        t.add(p4);

        Iterator iterator = t.iterator();
        while(iterator.hasNext())
        {
            Person p = (Person) iterator.next();
            System.out.println(p.getAge()+" "+p.getName());
        }
    }
}
