package cn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tianf on 2016/8/17.
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 4, 6, 7, 2, 9, 6, 1};
        List<Integer> alist = new ArrayList<Integer>();
        alist.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            if (alist.contains(x)) {
                continue;
            } else {
                alist.add(a[i]);
            }
        }
        for (Integer integer : alist) {
            System.out.print(integer + " ");
        }
    }
}
