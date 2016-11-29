package swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tianf on 2016/8/23.
 */
public class frameTest {
public static void Main(String args[]){
        //创建JFrame对象，JFrame用来在屏幕上显示一个Windows窗口。
        JFrame frame = new JFrame("第一个JFrame");
        // 建立一个文本输入域对象，由于文本输入域是JComponent的子类，可以采用以
        // 下方法定义。
        JComponent comp = new JTextArea();
        // 将上面建立的文本输入域加入到frame对象
        // 默认情况下，frame的内容面板（容器）采用BorderLayout布局，
        // 这里是将文本输入域放入BorderLayout布局的Center部位。
        // 有关BorderLayout布局的内容，请查阅
        //   http://gyfinjava.blog.com.cn/archives/2007/2161340.shtml
        frame.getContentPane().add(comp, BorderLayout.CENTER);
        // 设置其高度和宽度分别为：288像素和188像素
        frame.setSize(288,188);
        // 显示该Frame
        frame.setVisible(true);
        }
        }
