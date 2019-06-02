
//QQ登录界面制作
import java.awt.*;
import javax.swing.*;

import static java.lang.Boolean.FALSE;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.SwingConstants.LEFT;

public class User_Detail_Imformation extends JFrame {

    // 北部区域
    JLabel jl1;

    // 南部区域
    JButton jb1, jb2, jb3;
    JPanel jp1;

    // 中部区域
    JTabbedPane jtp;// 选项卡窗格
    JPanel jp2, jp3, jp4;






    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new User_Detail_Imformation();

    }

    public User_Detail_Imformation() {

        // 南部区域
        jp1 = new JPanel();
        jb1 = new JButton("确定");
        jb2 = new JButton("取消");


        // 中部区域
        jtp = new JTabbedPane();
        jp2 = new JPanel();
        jp3 = new JPanel();
        //jp3.setBackground(Color.RED);// 给面板设置背景
        jp4 = new JPanel();
        jp4.setBackground(new Color(0, 0, 255));

        JPanel jptry=new JPanel();
        // 将面板添加到选项卡窗格上
        jtp.add("用户信息", jptry);// 参数：选项卡名称，面板


        // 设置布局
        //jp2.setLayout(new GridLayout(3, 3));

        // 添加组件
        jp1.add(jb1);
        jp1.add(jb2);



        jp2= Leftttt();
        jp3= Left();

        jptry.setLayout(new GridLayout(1,2));
//        JScrollPane scrollpane_left = new JScrollPane();
//        scrollpane_left.add(b);
        jptry.add(jp2);
        jptry.add(jp3);



        this.add(jp1, BorderLayout.SOUTH);

        this.add(jtp, BorderLayout.CENTER);
//      this.add(jptry, BorderLayout.CENTER);
        // 展示组件
        ImageIcon icon = new ImageIcon("images\\qq.png");
        this.setIconImage(icon.getImage());// 给窗体设置图标方法
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("查看/添加/编辑用户详细信息");
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JPanel Leftttt(){
        JPanel b=new JPanel();
        b.setLayout(null);
        int row_number=0;


            JLabel label_name = new JLabel("姓名:           ");
            JTextField textfield_name=new JTextField("",10);
        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_name);
        name.add(textfield_name);
        name.setBounds(20,20+row_number*40,3000,40);
        row_number++;
        b.add(name);

            JLabel label_gender = new JLabel("性别:           ");
            JComboBox combobox_gender = new JComboBox();
            combobox_gender.addItem("男");
            combobox_gender.addItem("女");
            combobox_gender.setSelectedIndex(-1);
        JPanel gender = new JPanel();
        gender.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        gender.add(label_gender);
        gender.add(combobox_gender);
        gender.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(gender);

            JLabel label_ID = new JLabel("身份证号:     ");
            JTextField textfield_ID=new JTextField("431226199710074837",15);
        JPanel ID = new JPanel();
        ID.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        ID.add(label_ID);
        ID.add(textfield_ID);
        ID.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(ID);

            JLabel label_number = new JLabel("手机号:");
            Icon icon_add = new ImageIcon("Pic/pic_add.png");
            JButton button_add_number_owner = new JButton(null,icon_add);
            button_add_number_owner.setBorderPainted(FALSE);

                JPanel panel_onwer_number = new JPanel();
                //panel_onwer_number.setLayout(new FlowLayout(FlowLayout.,0,0));
        JPanel number = new JPanel();
        number.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        number.add(label_number);
        number.add(button_add_number_owner);
        number.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(number);





        return b;
    }

    public JPanel Lefttt(){

        JPanel a =new JPanel();
        //a.setLayout(new GridLayout(4,1));
        a.setLayout(new BoxLayout(a,BoxLayout.Y_AXIS));


        // 沿X轴放置

        JPanel pane1 = new JPanel();

        pane1.setLayout(new BoxLayout(pane1, BoxLayout.X_AXIS));
        pane1.add(new JButton("btn11"));

        pane1.add(new JButton("btn12"));

        pane1.add(new JButton("btn13"));

        pane1.add(new JButton("btn14"));

        a.add(pane1);

        // 沿y轴放置

        JPanel pane2 = new JPanel();

        pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));

        pane2.add(new JButton("btn21"));

        pane2.add(new JButton("btn22"));

        pane2.add(new JButton("btn23"));

        pane2.add(new JButton("btn24"));

        a.add(pane2);

        //与容器的ComponentOrientation相同的放置

        JPanel pane3 = new JPanel();

        pane3.setLayout(new BoxLayout(pane3, BoxLayout.LINE_AXIS));

        pane3.add(new JButton("btn31"));

        pane3.add(new JButton("btn32"));

        pane3.add(new JButton("btn33"));

        pane3.add(new JButton("btn34"));

        a.add(pane3);

        //与容器的ComponentOrientation相反的放置

        JPanel pane4 = new JPanel();

        pane4.setLayout(new BoxLayout(pane4, BoxLayout.PAGE_AXIS));

        pane4.add(new JButton("btn41"));

        pane4.add(new JButton("btn42"));

        pane4.add(new JButton("btn43"));

        pane4.add(new JButton("btn44"));

        a.add(pane4);

        return a;
    }


    public JPanel Leftt(){
//        JFrame jf = new JFrame("测试窗口");
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton btn04 = new JButton("Button04");
        JButton btn05 = new JButton("Button05");

        // 创建第一个水平箱容器
        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEADING,10,0));

        JLabel label_null = new JLabel("");
        JLabel label_name = new JLabel("姓名：");
        JTextField textfield_name=new JTextField("",10);


        name.add(label_null);
        name.add(label_name);
        name.add(textfield_name);
        name.setAlignmentY(Component.LEFT_ALIGNMENT );

        // 创建第二水平箱容器
        Box hBox02 = Box.createHorizontalBox();
        btn04.setAlignmentY(Component.LEFT_ALIGNMENT );
        btn05.setAlignmentY(Component.LEFT_ALIGNMENT );
        hBox02.add(btn04);
        //btn04.setAlignmentY(Component.LEFT_ALIGNMENT );
        //hBox02.add(Box.createHorizontalGlue()); // 添加一个水平方向胶状的不可见组件，撑满剩余水平空间
        hBox02.add(btn05);


        hBox02.setAlignmentY(Component.LEFT_ALIGNMENT );

        // 创建一个垂直箱容器，放置上面两个水平箱（Box组合嵌套）
        Box vBox = Box.createVerticalBox();

        //vBox.setLayout(new BoxLayout(vBox, BoxLayout.X_AXIS));
        vBox.setAlignmentY(Component.LEFT_ALIGNMENT );
        //vBox.add(name);
        vBox.add(hBox02);

        // 把垂直箱容器作为内容面板设置到窗口
//        jf.setContentPane(vBox);
//
//        jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);

        JPanel returned=new JPanel();
        returned.add(vBox);
        return returned;

    }

    public JPanel Left(){
        JPanel left = new JPanel();
        left.setLayout(new FlowLayout(FlowLayout.LEADING,10,0));


            JLabel label_null = new JLabel("");
            label_null.setBounds(100,100,0,0);
            JLabel label_name = new JLabel("姓名：");
            JTextField textfield_name=new JTextField("",10);
            JLabel label_null_long = new JLabel("                                                                                                ");
            JPanel panel_null = new JPanel();
            panel_null.setLayout(new GridLayout(1,1));
            panel_null.add(label_null);

        JButton c=new JButton("                                                     "
                +"                    ");
        c.setContentAreaFilled(false);
        c.setBorderPainted(false);
        c.setEnabled(false);


        Component hGlue = Box.createHorizontalGlue();

        left.add(label_null);
        left.add(label_name);
        left.add(textfield_name);
        left.add(hGlue);
        //left.add(label_null_long);
        //left.add(panel_null);
        //left.add(c);

            JLabel label_gender = new JLabel("性别：");
            //label_gender.setHorizontalTextPosition(label_name.BOTTOM);
            label_gender.setVerticalAlignment(1);
            //label_gender.setal
        left.add(label_gender);








        return left;
    }
}