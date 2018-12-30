package SerializeDemo.FstDemo;

import SerializeDemo.HessianDemo.User;
import org.nustaq.serialization.FSTConfiguration;

public class Main {

    @SuppressWarnings("unchecked")
    private static ThreadLocal<FSTConfiguration> confs = new ThreadLocal(){
        public FSTConfiguration initialValue() {
            return FSTConfiguration.createDefaultConfiguration();
        }
    };

    private static FSTConfiguration getFST(){
        return confs.get();
    }

    public static <T> byte[] serializer(T t){
        return getFST().asByteArray(t);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializer(byte []bytes,Class<T> c) {
        return  (T)getFST().asObject(bytes);
    }

    public static void main(String[] args) {
        User user = new User("Bob", "male");
        System.out.println(user);

        byte[] bytes = serializer(user);
        User person = deserializer(bytes, User.class);

        System.out.println(person);
    }
}
