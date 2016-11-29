package Inheritance;

/**
 * Created by tianf on 2016/8/23.
 */
public class MySubclass extends MyClass {

    public static void main(String[] args) {
        MySubclass subclass = new MySubclass();

        MyNestedClass nested =  subclass.new MyNestedClass();
    }
}
