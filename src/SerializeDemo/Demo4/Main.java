package SerializeDemo.Demo4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("180", "60", "Bob", "male");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Object3.txt")));
        oos.writeObject(p);
        oos.close();
        System.out.println(p.humanToString());
        System.out.println(p);

        System.out.println();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Object3.txt")));
        Person p1 = (Person) ois.readObject();
        ois.close();
        System.out.println(p1.humanToString());
        System.out.println(p1);
    }
}
