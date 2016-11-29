import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");


        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("meiyi");
         Object[] array=  list.toArray();

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }




        String[] sys = new String[] {"ni","hao","me"};
      List<String> syslist = Arrays.asList(sys);

        for(String s : syslist) {
            System.out.println(s);
        }



    }
}
