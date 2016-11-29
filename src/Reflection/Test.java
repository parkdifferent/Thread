package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tianf on 2016/8/19.
 */
public class Test {
    public static void main(String[] args)  {
        Method[] methods= Employee.class.getMethods();
        for(Method method : methods) {
            System.out.println("method = " + method.getName());
        }

        Class aClass = Employee.class;


        Field[] fields= aClass.getFields();
        for(Field field : fields) {
            System.out.println("field = " + field.getName());
        }

        //Annotation[] annotations = aClass.getAnnotations();
        Constructor[] constructors = aClass.getConstructors();

        //Constructor constructor1 = aClass.getConstructor(new Class[]{Integer.class,String.class});

        for(Constructor constructor  : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            for(Class cla : parameterTypes) {
                System.out.println("parameterTypes = " + cla.getName());
                System.out.println("Constructor = " + constructor.getName());
            }
        }


        try {
            Constructor constructor = Employee.class.getConstructor();
            Employee employee = (Employee) constructor.newInstance();
            employee.setEno(1);
            employee.setEname("zhangsan");
            employee.toString();

        } catch (Exception ex) {
            ex.printStackTrace();

        }






    }
}
