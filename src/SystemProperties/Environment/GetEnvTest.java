package SystemProperties.Environment;

import java.util.Map;
import java.util.Set;

public class GetEnvTest {
    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries){
            System.out.println(entry.getKey() +"  "+entry.getValue());
        }

        System.out.println(System.getenv("JAVA_HOME"));
    }
}
