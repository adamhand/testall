package JVM.HeapOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true)
            list.add(new OOMObject());
    }
}
