package cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianf on 2016/8/10.
 */
public class HashMapTest {

   // HashMap<String,String> hashMap=new HashMap();

    public static void main(String[] args) {
        System.out.println(Object[].class);

        HashMap<String,String> hashMap=new HashMap();

        ArrayList<String> arrayList=new ArrayList<String>();

        LinkedList<String> linkedList=new LinkedList<String>();

        HashSet<String> hashSet=new HashSet<String>();

        ThreadLocal<String> threadLocal=new ThreadLocal<String>();

        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap();

        TreeMap<String,String> treeMap=new TreeMap<String, String>();

        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<String, String>();

        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

        TreeSet<String> treeSet=new TreeSet<String>();

        Hashtable<String,String> hashtable=new Hashtable<String, String>();       //线程安全

        String str=new String();

        StringBuilder stringBuilder=new StringBuilder();

        StringBuffer stringBuffer=new StringBuffer();        //线程安全

        Stack<Integer> stack=new Stack<Integer>();

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();

        File file=new File("D:\\my.txt");
        //InputStream inputStream=new FileInputStream();

        System.out.print(arrayList.size());


        //ConcurrentHashMap
         // Comparator
        //  Iterator
       // treeMap

    }


}
