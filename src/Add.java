import javax.swing.*;
import java.awt.*;

public class Add extends JFrame{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Add();


    }

    public Add() {

        JFrame frame=new JFrame("登录对话框");//设置标题栏文字
        TextField id=new TextField(15);//设置用户名输入的文本域
        TextField pw=new TextField(15);//设置用密码输入的文本域
        JButton loginButton=new JButton("登录");//实例化按钮对象设置登录按钮
        JButton cancelButton=new JButton("取消");//实例化按钮对象设置取消按钮
        pw.setEchoChar('*');//隐藏输入的密码只能看到输入密码的位数
        frame.setLayout(new GridLayout(3,2));//setLayout()方法设置窗体布局格式
        //以下是一次添加各个组件
        frame.add(new JLabel("用户名:",JLabel.CENTER));
        frame.add(id);
        frame.add(new JLabel("密码:",JLabel.CENTER));
        frame.add(pw);
        frame.add(loginButton);
        frame.add(cancelButton);
        frame.pack();//frame.pack()这个方法的作用就是根据窗口里面的布局及组件的preferedSize(优先尺寸)来确定frame的最佳大小
        frame.setVisible(true);//JFrame实例化以后是没有大小、不可见的。所以，要设置为true可见

    }
}
