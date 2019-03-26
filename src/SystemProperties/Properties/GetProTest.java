package SystemProperties.Properties;

import java.util.Properties;

public class GetProTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (String property : properties.stringPropertyNames()){
            System.out.println(property+"  "+properties.get(property));
        }

        System.out.println(System.getProperty("java.version"));

        System.setProperty("jdbc.Driver", "hahahahah");
        System.out.println(System.getProperty("jdbc.Driver"));
    }
}
