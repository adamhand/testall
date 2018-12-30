package SerializeDemo.KryoDemo;

import SerializeDemo.HessianDemo.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "male");
        Serializer serializer = new kryoSerializer(User.class);
        System.out.println(user);

        byte[] bytes = new byte[1024];
        serializer.serialize(user, bytes);

        User person = serializer.deserialize(bytes);
        System.out.println(person);
    }
}
