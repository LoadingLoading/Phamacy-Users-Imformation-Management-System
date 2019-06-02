import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//1.创建名为Login的类，在该类中创建一个名为InitUI的方法，图形界面就在此方法中实现
class mainWindow {


    public static void main(String[] args){

//1.1创建一个顶级容器，也就是空白窗口，并为此窗口设置属性（窗口名称，大小，显示位置，关闭设置）

// 用JFrame创建一个名为frame的顶级容器，需要添加的包名为javax.swing.JFrame
        JFrame frame=new JFrame();
//设置窗口名称
        frame.setTitle("用户管理主界面");
//设置窗口大小
        frame.setSize(1200,700);
//设置窗口位于屏幕中央
        frame.setLocationRelativeTo(null);
//参数为3时，表示关闭窗口则程序退出
        frame.setDefaultCloseOperation(3);

//1.2设置窗体上组件的布局，此处使用流式布局FlowLayout，流式布局类似于word的布局
//用FlowLayout创建一个名为f1的对象,需要添加的包名为java.awt.FlowLayout，其中LEFT表示左对齐，CENTER表示居中对齐，RIGHT表示右对齐
        FlowLayout f1=new FlowLayout(FlowLayout.LEFT);
//frame窗口设置为f1的流式左对齐
        frame.setLayout(f1);

//1.3在窗体上添加图片，文字


        /*


//创建一个空的JLabel，它的长度宽度为110,30，因为窗口是流式左对齐，为了将”账号”一栏添加在正中间，所以左侧由空的JLabel填充
        JLabel name1=new JLabel();
//设置空JLabel长度大小，此处不能使用setSize设置大小，setSize只能设置顶级容器大小，此处用setPreferredSize，Dimension给出大小，需要添加的包名为java.awt.Dimension.
        name1.setPreferredSize(new Dimension(110,30));
//将空JLabel添加入窗口
        frame.add(name1);

//同上，此处添加的不是空JLabel，而是内容为“账号”的JLabel
        JLabel name=new JLabel("账号：");
        frame.add(name);

//JTextField在窗口上添加一个可输入可见文本的文本框，需要添加的包名为javax.swing.JTextField.
        JTextField nametext=new JTextField();
//设置文本框大小
        nametext.setPreferredSize(new Dimension(220, 30));
//添加到窗口上
        frame.add(nametext);

//同name1
        JLabel name2=new JLabel();
        name2.setPreferredSize(new Dimension(110,30));
        frame.add(name2);

//同name1
        JLabel name3=new JLabel();
        name3.setPreferredSize(new Dimension(110,30));
        frame.add(name3);

//同name
        JLabel password=new JLabel("密码：");
        frame.add(password);

//JPasswordField创建一个密码文本框，里面输入的文本是不可见的，其他同nametext
        JPasswordField passwordtext=new JPasswordField();
        passwordtext.setPreferredSize(new Dimension(220, 30));
        frame.add(passwordtext);

//同name1
        JLabel name4=new JLabel();
        name4.setPreferredSize(new Dimension(110,30));
        frame.add(name4);

//同name1
        JLabel name5=new JLabel();
        name5.setPreferredSize(new Dimension(220,30));
        frame.add(name5);
        */

//JButton创建一个可点击的按钮，按钮上可显示文本图片
        JButton bu=new JButton("用户一");

        bu.setPreferredSize(new Dimension(80,30));
        frame.add(bu);
        bu.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 启动图片浏览
                //chordsPicWindow.InitUI();
            }
        });
//设置窗口可见，此句一定要在窗口属性设置好了之后才能添加，不然无法正常显示
        frame.setVisible(true);
    }
}