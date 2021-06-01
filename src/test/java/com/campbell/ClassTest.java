package com.campbell;

import com.campbell.entity.Person;
import org.junit.jupiter.api.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author Campbell
 * @date 2020/8/2
 */
public class ClassTest extends BaseTest {

    @Test
    public void classLoaderTest() {
        ClassLoader cld = String.class.getClassLoader();
        System.out.println(cld);

        ClassLoader loader = DNSNameService.class.getClassLoader();
        System.out.println(loader);

        ClassLoader classLoader = Person.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }

    @Test
    public void classTest() throws Exception {
        Person person = new Person();
        Class c1 = person.getClass();
        System.out.println(c1);
        Class c2 = Person.class;
        System.out.println(c2);
        Class c3 = Class.forName("com.campbell.entity.Person");
        System.out.println(c3);
    }

    @Test
    public void constructorTest() throws Exception {
        Class cla = Class.forName("com.campbell.entity.Person");
        Constructor[] constructors = cla.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Constructor constructor1 = cla.getConstructor();
        Object object1 = constructor1.newInstance();
        System.out.println(object1);

        Constructor constructor2 = cla.getConstructor(String.class, Integer.class);
        Object object2 = constructor2.newInstance("张三", 20);
        System.out.println(object2);

        Object object3 = cla.newInstance();
        System.out.println(object3);
    }

    @Test
    public void methodTest() throws Exception {
        Class cla = Class.forName("com.campbell.entity.Person");
        Object object = cla.newInstance();

        Method[] methods = cla.getMethods();
        System.out.println(Arrays.toString(methods));

        Method method1 = cla.getMethod("work");
        method1.invoke(object);

        Method method2 = cla.getMethod("setName", String.class);
        method2.invoke(object, "张三");

        Method method3 = cla.getMethod("getName");
        Object name = method3.invoke(object);
        System.out.println(name);
    }

    @Test
    public void test() throws Exception {
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("reflect.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        Class cla = Class.forName(properties.getProperty("className"));
        Object object = cla.newInstance();
        Method method = cla.getMethod(properties.getProperty("methodName"), String.class);
        method.invoke(object, "张三");
        System.out.println(object);
    }

}
