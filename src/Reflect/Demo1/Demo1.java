package Reflect.Demo1;

import SerializeDemo.HessianDemo.User;

public class Demo1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = User.class;
        User user = (User) clazz.newInstance();
    }
}
