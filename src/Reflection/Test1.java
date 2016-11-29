package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tianf on 2016/8/19.
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Employee employee = new Employee(1,"zhangsan");
        Object object = employee ;
        Field[] fields=object.getClass().getDeclaredFields();

        for(Field field : fields) {
            System.out.println(field);
        }

        Method method = object.getClass().getMethod("hello", String.class);
        Object returnValue = method.invoke(object, "lisi");
        System.out.print(returnValue.toString());

    }

}
