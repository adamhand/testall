package SerializeDemo.ProtostuffDemo;

import SerializeDemo.HessianDemo.User;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "male");

        System.out.println(user);

        byte[] bytes = serializer(user);

        User person = deserializer(bytes, User.class);

        System.out.println(person);
    }


//    public static byte[] serializer(User user){
//        RuntimeSchema<User> poSchema = RuntimeSchema.createFrom(User.class);
//        return ProtostuffIOUtil.toByteArray(user, poSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//
//    }
//
//
//    public static User deserializer(byte []bytes,Class<User> c) {
//        User user = null;
//        try {
//            user = c.newInstance();
//            Schema schema = RuntimeSchema.getSchema(user.getClass());
//            ProtostuffIOUtil.mergeFrom(bytes,user,schema);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }

    public static <T> byte[] serializer(T t){
        RuntimeSchema<T> poSchema = (RuntimeSchema<T>) RuntimeSchema.createFrom(t.getClass());
        return ProtostuffIOUtil.toByteArray(t, poSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    public static <T> T deserializer(byte []bytes,Class<T> c) {
        T t = null;
        try {
            t = c.newInstance();
            Schema schema = RuntimeSchema.getSchema(t.getClass());
            ProtostuffIOUtil.mergeFrom(bytes,t,schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
