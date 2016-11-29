package Inheritance;

import java.lang.reflect.Method;

/**
 * Created by tianf on 2016/8/23.
 */
public class Test1 {
    public static void main(String[] args) {
        Car car = new Car();

        car.setLicensePlate("123");
        car.updateLicensePlate("abc");

        System.out.println("license plate: "
                + car.getLicensePlate());

        Level level= Level.HIGH;
        System.out.println(level.getLevelCode());


        Method[] methods = Car.class.getMethods();

        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }


    }
}
