package SerializeDemo.Demo2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Bob", "male");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Object1.txt")));
        oos.writeObject(user);
        oos.close();
        System.out.println(user);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Object1.txt")));
        User person =  (User)ois.readObject();
        System.out.println(person);
    }
}
