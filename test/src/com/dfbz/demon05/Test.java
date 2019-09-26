package com.dfbz.demon05;


import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        Student stu = (Student) createObject();
        System.out.println(stu);
    }

    public static Object createObject() {
        try {
            Properties p = new Properties();
            p.load(Test.class.getResourceAsStream("/stu.properties"));
            String className =p.getProperty("class");
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            Set<String> names = p.stringPropertyNames();
            for (String name : names) {
                if (name.equals("class"))
                    continue;
                String value = p.getProperty(name);
                Field f = c.getDeclaredField(name);
                f.setAccessible(true);
                Class typeClass = f.getType();
                if(typeClass == int.class){
                    f.setInt(obj, Integer.parseInt(value));
                } else {
                    f.set(obj, value);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


class Student{
    private String className;
    private String name;
    private Integer age;
    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}