package SerializeDemo.JSONDemo;

import SerializeDemo.HessianDemo.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "male");
        System.out.println(user);
        JSON json = serializer(user);

        User person = deserializer(json, User.class);

        System.out.println(person);
    }


    public static <T> JSON serializer(T t){
        return (JSON) JSONObject.toJSON(t);
    }


    public static <T> T deserializer(JSON json,Class<T> c) {
        return JSONObject.parseObject(json.toJSONString(),c);
    }
}
