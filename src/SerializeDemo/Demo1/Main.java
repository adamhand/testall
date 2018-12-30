package SerializeDemo.Demo1;

import org.apache.commons.lang3.SerializationUtils;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        User user = new User("Bob", "male");
////
////        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("object.txt")));
////        oos.writeObject(user);
////        oos.close();
////        System.out.println(user);
////
////        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("object.txt")));
////        User person = (User)ois.readObject();
////
////        System.out.println(person);

        User user = new User("Bob", "male");

        byte[] bytes = SerializationUtils.serialize(user);

        User person = SerializationUtils.deserialize(bytes);
        System.out.println(person);
    }
}
