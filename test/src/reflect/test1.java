package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;

public class test1 {
    @Test
    public void method() throws ClassNotFoundException {
        Class clazz = person.class;
        System.out.println("clazz = " + clazz);
        person p1 = new person();
        Class clazz2 = p1.getClass();
        System.out.println("clazz2 = " + clazz2);
        Class clazz3 = Class.forName("reflect.person");
        System.out.println("clazz3 = " + clazz3);
    }
    @Test
    public void method1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = person.class;
        Object object = clazz.newInstance();
        person p = (person) object;
        System.out.println("object = " + p);
    }
    @Test
    public void method2() throws Exception {
        for (int i = 0; i <100 ; i++) {
            int i2 = new Random().nextInt(3);
            String string = "";
            switch (i2){
                case 0:
                    string = "java.util.Date";
                    break;
                case 1:
                    string = "java.lang.Object";
                    break;
                case 2:
                    string = "reflect.person";
                    break;
            }
            Object re = re(string);
            System.out.println("re = " + re);
        }

    }
    public Object re(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(path);
        Object object = clazz.newInstance();
        return object;
    }
    @Test
    public void method3() throws Exception {
        Class clazz = person.class;
        Object object = clazz.newInstance();
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println("f = " + f);
        }
        System.out.println();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }
    @Test
    public void method4() throws Exception {
        Class clazz = person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            int modifiers = f.getModifiers();
            System.out.print("modifiers = " + Modifier.toString(modifiers)+"   ");
            Class type = f.getType();
            System.out.print("type = " + type.getName()+"   ");
            String name = f.getName();
            System.out.println("name = " + name+"    ");
        }
    }
    @Test
    public void method5() throws Exception {
        Class clazz = person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.print(Modifier.toString(m.getModifiers())+"    ");
            System.out.print(m.getReturnType().getName()+"   ");
            System.out.print( m.getName()+"   ");
            Class[] parameterTypes = m.getParameterTypes();
            for (Class c : parameterTypes){
                System.out.print(c.getName()+"    ");
            }
            System.out.println();
        }

    }
    @Test
    public void method6() throws Exception {
        Class clazz = person.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.print("c = " + c+"    ");
        }
        System.out.println();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            System.out.print("c = " + c+"   ");
        }
    }
    @Test
    public void method7() throws Exception {
        Class clazz = person.class;
        person p = (person) clazz.newInstance();
        Field age = clazz.getField("id");
        age.set(p, 100);
        int i = (int) age.get(p);
        System.out.println("age = " +i);

    }
    @Test
    public void method8() throws Exception {
        Class clazz = person.class;
        person p = (person) clazz.newInstance();
        Field id = clazz.getDeclaredField("age");
        id.setAccessible(true);
        id.set(p,136);
        Object object = id.get(p);
        int i = (int) object;
        System.out.println("i = " + i);
        Method show = clazz.getDeclaredMethod("show", String.class, int.class);
        show.setAccessible(true);
        Object abc = show.invoke(p, "abc", 123);
        System.out.println(abc);
        Method me = clazz.getDeclaredMethod("me");
        me.setAccessible(true);
        me.invoke(person.class);
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        constructor.setAccessible(true);
        person p2 = (person) constructor.newInstance("小六", 567);
        System.out.println("object1 = " + p2);


    }
}
