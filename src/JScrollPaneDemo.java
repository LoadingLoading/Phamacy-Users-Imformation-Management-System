/**
 * java swing 之JScrollPane面板
 * 在设置界面时，可能会遇到在一个较小的容器窗体中显示一个较大部分的内容，这时可以使用
 * JScrollPane面板，JscrollPane面板是带滚动条的面板，也是一种容器，但是常用于布置单个
 * 控件，并且不可以使用布局管理器。如果需要在JScrollPane面板中放置多个控件，需要将多个
 * 控件放置到JPanel 面板上，然后将JPanel面板作为一个整体控件添加到JScrollPane控件上。
 *
 * @author gao
 */


import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JScrollPaneDemo extends JFrame{
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public JScrollPaneDemo(){
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        this.setContentPane(contentPane);
        scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);
        textArea=new JTextArea();

        //scrollPane.add(textArea);

        JPanel a=new JPanel();
        BoxLayout layout=new BoxLayout(a, BoxLayout.Y_AXIS);
        a.setLayout(layout);
        //a.setLayout(null);

//
//        for (int i = 0; i < 100; i++) {
//            Checkbox cb = createCheckbox("选项"+(i+1));
//            cb.setBounds(0,18*i,250,18);
//            if(i>=1) {
//                a.add(cb);
//            }
//        }
        //a=User_Detail_Imformation.createJPanelOfRecord(a,1);


        //a.setBackground(Color.YELLOW);

        scrollPane.setViewportView(a);
        a.setAutoscrolls(true);
        //a.scrollRectToVisible(100);

        //a.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setTitle("滚动面板使用");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 250, 200);
        this.setVisible(true);
    }
    public static void main(String []args){
        JScrollPaneDemo example=new JScrollPaneDemo();
    }
    private static Checkbox createCheckbox(String label) {
        Checkbox cb = new Checkbox(label);
        //给Checkbox对象注册事件监听，也可以去监听其它事件，比如鼠标事件什么的
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Checkbox cb = (Checkbox)e.getSource();
                System.out.println("Checkbox "+cb.getLabel()+"的选择状态："+cb.getState());
            }
        });
        return cb;
    }
}