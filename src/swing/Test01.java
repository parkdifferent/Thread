package swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tianf on 2016/8/23.
 */
public class Test01 {

    public static void main(String[] args) {
        //声明列名数组
        String[] columnNames = { "姓名", "性别", "年龄", "籍贯", "婚否" };
        //声明数据二维数组
        Object[][] data = {
                { "赵刚", "男", new Integer(18), "北京", new Boolean(false) },
                { "钱霞", "女", new Integer(28), "北京", new Boolean(true) },
                { "孙大伟", "男", new Integer(32), "上海", new Boolean(false) },
                { "李民", "男", new Integer(30), "南京", new Boolean(true) },
                { "周丽丽", "女", new Integer(34),"重庆",new Boolean(false) } };
        //创建JTable对象t
        final JTable t = new JTable(data, columnNames);
        //设置JTable对象的可视区，超出部分会用下面的滚动条来显示
        t.setPreferredScrollableViewportSize(new Dimension(800, 140));
        //定义一个容器
        JPanel p = new JPanel();
        //在容器中加入表格和滚动条
        p.add(t);
        JScrollPane s = new JScrollPane(t);
        p.add(s);
        //设置容器为透明的
        p.setOpaque(true);
        //以下代码在前几个Java Swing教程中已经讲过，这里不重复！
        JFrame f = new JFrame("JTable测试！");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(p,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}
