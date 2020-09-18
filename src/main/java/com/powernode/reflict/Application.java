package com.powernode.reflict;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ty
 * 2020/9/15
 */
public class Application {
    public static void main(String[] args) {
        /*try {
            Class aClass = Class.forName("com.powernode.reflict.User");
            Constructor constructor = aClass.getConstructor(String.class, String.class);
            User user = (User)constructor.newInstance("小宝贝", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*Class aClass = new User().getClass();
        try {
            Constructor constructor = aClass.getConstructor(null);
            User user =(User) constructor.newInstance(null);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Class<User> userClass = User.class;
        try {
            Constructor<User> constructor = userClass.getConstructor(String.class, String.class);
            User user = constructor.newInstance("小熊啊", "123");
            Field name = userClass.getDeclaredField("name");

            System.out.println(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            /*Method method = userClass.getMethod("setName", String.class);
            User user=new User();
             method.invoke(user, "小妹妹");
            System.out.println(user.getName());*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
