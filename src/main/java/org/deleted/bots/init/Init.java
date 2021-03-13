package org.deleted.bots.init;

import org.deleted.bots.annotation.Configuration;
import org.deleted.bots.annotation.Initialization;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/**
 * 初始化的总入口
 */
public class Init {
    public void init() throws Exception {
        Properties prop = new Properties();
        //加载配置文件中的配置属性
        prop.load(this.getClass().getResourceAsStream("/robot.properties"));
        for (String key : prop.stringPropertyNames()) {
            System.setProperty(key,prop.getProperty(key));
        }
        //初始化功能 需要在链接websocket 之前完成动作可以在此初始化
        Reflections reflections = new Reflections(prop.getProperty("package"));//扫描指定包
        Set<Class<?>> classes =  reflections.getTypesAnnotatedWith(Initialization.class);//获取使用了初始化注解的类
        for (Class<?> cls :classes){
            Object o =  cls.getDeclaredConstructor().newInstance();//通过反射创建对象
            Method method = cls.getMethod("init");//执行Initialization中的初始化方法
            method.invoke(o);
        }
        //加载配置类
        classes =  reflections.getTypesAnnotatedWith(Configuration.class);//获取使用了配置注解的类
        for (Class<?> cls :classes){
            Object o =  cls.getDeclaredConstructor().newInstance();//通过反射创建对象
            Method method = cls.getMethod("init");//执行Configuration中的初始化方法
            method.invoke(o);
        }
    }
}
