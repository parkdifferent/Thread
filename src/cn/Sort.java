package cn;

import java.applet.Applet;
import java.util.*;

/**
 * Created by tianf on 2016/8/17.
 */
public class Sort {
    public static void main( String[] args) {
        int[] a = new int[]{1,9,4,6,7,2,9,6,1};
        for(int i = 0 ; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        List<Integer> b = new ArrayList<Integer>();
        for( int k =0; k< a.length;k++) {
           // System.out.print(a[k]+"  ");
            for(int i = 0; i <a.length;i++) {
                boolean isdiff = true;
                if(isdiff && a[i] != a[i+1]) {
                    b.add(a[i]);
                }
            }
        }
    }
}
