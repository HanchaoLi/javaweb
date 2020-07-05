package com.reflect01.reflectdemo;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectionDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("proconfig.properties");
        properties.load(is);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class cls = Class.forName(className);
        Method method = cls.getMethod(methodName);

        Object obj = cls.newInstance();
        method.invoke(obj);
    }
}
