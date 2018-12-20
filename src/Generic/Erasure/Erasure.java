package Generic.Erasure;

import java.util.ArrayList;
import java.util.List;

public class Erasure <T extends String>{
    T object;

    public Erasure(T object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Erasure<String> erasure = new Erasure<String>("hello");

        List<String> list = new ArrayList<>();
        list.add("1213");
    }
}
