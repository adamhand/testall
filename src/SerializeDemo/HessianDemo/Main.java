package SerializeDemo.HessianDemo;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "male");

        System.out.println(user);

        byte[] bytes = serialize(user);

        User person = deserialize(bytes);

        System.out.println(person);
    }

    public static byte[] serialize(User user){
        ByteArrayOutputStream baos = null;
        HessianOutput ho = null;

        try {
            baos = new ByteArrayOutputStream();
            ho = new HessianOutput(baos);
            ho.writeObject(user);

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User deserialize(byte[] bytes){
        ByteArrayInputStream bais = null;
        HessianInput hi = null;

        try {
            bais = new ByteArrayInputStream(bytes);
            hi = new HessianInput(bais);

            return (User) hi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
