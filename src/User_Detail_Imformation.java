
//QQ登录界面制作
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import static java.lang.Boolean.FALSE;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.SwingConstants.LEFT;

public class User_Detail_Imformation extends JFrame {
    static JTextField  textfield_name;
    static JComboBox combobox_gender;
    static JTextField textfield_ID;
    static JComboBox combobox_medical;


    // 北部区域
    static JLabel jl1;

    // 南部区域
    static JButton  jb1, jb2, jb3;
    static JPanel jp1;

    // 中部区域
    static JTabbedPane jtp;// 选项卡窗格
    static JPanel jp2, jp3, jp4;






//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        new User_Detail_Imformation();
//
//    }

    public static void User_Detail_Imformation(int col) {
        JFrame user_detail_imformation = new JFrame();

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



        jp2= Left();
        jp3= Right();

        jptry.setLayout(new GridLayout(1,2));
//        JScrollPane scrollpane_left = new JScrollPane();
//        scrollpane_left.add(b);
        jptry.add(jp2);
        jptry.add(jp3);



        user_detail_imformation.add(jp1, BorderLayout.SOUTH);

        user_detail_imformation.add(jtp, BorderLayout.CENTER);
//      user_detail_imformation.add(jptry, BorderLayout.CENTER);
        // 展示组件
        ImageIcon icon = new ImageIcon("images\\qq.png");
        user_detail_imformation.setIconImage(icon.getImage());// 给窗体设置图标方法
        user_detail_imformation.setSize(800, 600);
        user_detail_imformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user_detail_imformation.setTitle("查看/添加/编辑用户详细信息");
        user_detail_imformation.setLocationRelativeTo(null);
        user_detail_imformation.setVisible(true);
        user_detail_imformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        jb1.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                System.out.println("ok");


                String name = textfield_name.getText();
                String gender=null;
                if(combobox_gender.getSelectedIndex()!=-1){//-1就是没选
                    gender = combobox_gender.getSelectedItem().toString();
                }
                String ID = textfield_ID.getText();
                String medical = null;
                if(combobox_medical.getSelectedIndex()!=-1){//-1就是没选
                    medical = combobox_medical.getSelectedItem().toString();
                }

                System.out.println(name+gender+ID+medical);
                database.insert(name,gender,ID,medical);


            }
        });





    }

    public static JPanel Left(){
        JPanel b=new JPanel();
        b.setLayout(null);
        int row_number=0;

            JLabel label_title_left = new JLabel("基本信息");
            Font f = new Font("黑体",Font.PLAIN,35);
            label_title_left.setFont(f);
            label_title_left.setForeground(Color.blue);
        JPanel title = new JPanel();
        title.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        title.add(label_title_left);
        title.setBounds(20,20+row_number*40,3000,80);
        row_number=row_number+2;
        b.add(title);

            JLabel label_name = new JLabel("姓名:           ");
            textfield_name=new JTextField("",10);

        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_name);
        name.add(textfield_name);
        name.setBounds(20,20+row_number*40,3000,40);
        row_number++;
        b.add(name);

            JLabel label_gender = new JLabel("性别:           ");
            combobox_gender = new JComboBox();
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
            textfield_ID=new JTextField("431226199710074837",15);

        JPanel ID = new JPanel();
        ID.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        ID.add(label_ID);
        ID.add(textfield_ID);
        ID.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(ID);

            JLabel label_age = new JLabel("年龄:             ");
            JLabel textfield_age=new JLabel("37岁");
        JPanel age = new JPanel();
        age.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        age.add(label_age);
        age.add(textfield_age);
        age.setBounds(20,23+ row_number*40,3000,40);
        row_number++;
        b.add(age);

            JLabel label_birthdate = new JLabel("出生日期:      ");
            JLabel textfield_birthdate=new JLabel("1945年5月7日");
        JPanel birthdate = new JPanel();
        birthdate.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        birthdate.add(label_birthdate);
        birthdate.add(textfield_birthdate);
        birthdate.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(birthdate);

        //这里是电话号码，因为比较长，所以用大括号扩起来了
        {
            JLabel label_number = new JLabel("手机号:");
            Icon icon_add = new ImageIcon("Pic/pic_add.png");
            JButton button_add_owner = new JButton(null,icon_add);
            button_add_owner.setBorderPainted(FALSE);
                JPanel one_owner_number = new JPanel();
                JComboBox combobox_owner = new JComboBox();
                combobox_owner.addItem("本人");
                combobox_owner.addItem("儿子");
                combobox_owner.addItem("女儿");
                combobox_owner.setSelectedIndex(-1);
                JTextField field_number = new JTextField("",10);
                one_owner_number.add(combobox_owner);
                one_owner_number.add(field_number);

                JPanel one_owner_number1 = new JPanel();
                JComboBox combobox_owner1 = new JComboBox();
                combobox_owner1.addItem("本人");
                combobox_owner1.addItem("儿子");
                combobox_owner1.addItem("女儿");
                combobox_owner1.setSelectedIndex(-1);
                JTextField field_number1 = new JTextField("",10);
                one_owner_number1.add(combobox_owner1);
                one_owner_number1.add(field_number1);

                JPanel one_owner_number2 = new JPanel();
                JComboBox combobox_owner2 = new JComboBox();
                combobox_owner2.addItem("本人");
                combobox_owner2.addItem("儿子");
                combobox_owner2.addItem("女儿");
                combobox_owner2.setSelectedIndex(-1);
                JTextField field_number2 = new JTextField("",10);
                one_owner_number2.add(combobox_owner2);
                one_owner_number2.add(field_number2);
        JPanel number = new JPanel();
        number.setLayout(null);

        number.add(label_number);
        label_number.setBounds(0,0,60,35);
        number.add(button_add_owner);
        button_add_owner.setBounds(50,0,18,35);
        int begin_pix=-16;
        number.add(one_owner_number);
        one_owner_number.setBounds(begin_pix,0,400,35);
        number.add(one_owner_number1);
        one_owner_number1.setBounds(begin_pix,30,400,35);
        number.add(one_owner_number2);
        one_owner_number2.setBounds(begin_pix,60,400,35);

        number.setBounds(20,15+ row_number*40,3000,90);
        row_number++;
        b.add(number);
        }

            JLabel label_medical = new JLabel("药品:   ");
            Icon icon_add_medical = new ImageIcon("Pic/pic_add.png");
            JButton button_add_owner_medical = new JButton(null,icon_add_medical);
            button_add_owner_medical.setBorderPainted(FALSE);
            combobox_medical = new JComboBox();
            combobox_medical.addItem("昕维");
            combobox_medical.addItem("福可维8mg");
            combobox_medical.addItem("福可维10mg");
            combobox_medical.addItem("福可维12mg");
            combobox_medical.addItem("凯美纳");
            combobox_medical.addItem("碳酸镧");
            combobox_medical.addItem("阿瑞匹坦");
            combobox_medical.addItem("硼替佐米");
            combobox_medical.addItem("艾坦");
            combobox_medical.addItem("生白合剂");
            combobox_medical.addItem("紫杉醇");
            combobox_medical.addItem("多柔比星");
            combobox_medical.addItem("唑来膦酸");
            combobox_medical.addItem("达沙替尼");
            combobox_medical.setSelectedIndex(-1);
        JPanel medical = new JPanel();
        medical.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        medical.add(label_medical);
        medical.add(button_add_owner_medical);
        medical.add(combobox_medical);
        medical.setBounds(20,80+ row_number*40,3000,40);
        row_number++;
        b.add(medical);





        return b;
    }

    public static JPanel Right(){
        JPanel b=new JPanel();
        b.setLayout(null);
        int hight=20;

        JLabel label_title_left = new JLabel("情况记录");
        Font f = new Font("黑体",Font.PLAIN,35);
        label_title_left.setFont(f);
        label_title_left.setForeground(Color.blue);
        JPanel title = new JPanel();
        title.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        title.add(label_title_left);
        title.setBounds(20,hight,3000,80);
        hight+=100;
        b.add(title);

        JLabel label_noti = new JLabel("下次提醒:     ");
        JLabel label_noti_time=new JLabel("2019年5月30号");
        JPanel noti = new JPanel();
        noti.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        noti.add(label_noti);
        noti.add(label_noti_time);
        noti.setBounds(20,hight,3000,40);
        hight+=40;
        b.add(noti);

        JLabel label_record1 = new JLabel("概况:           ");
        JLabel label_record1_time=new JLabel("2019年5月30号");
        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_record1);
        name.add(label_record1_time);
        name.setBounds(20,hight,3000,40);
        hight+=30;
        b.add(name);

        JTextArea textare_record1 = new JTextArea(1,1);
        textare_record1.setBounds(95,hight,250,100);
        hight+=120;
        b.add(textare_record1);






        return b;
    }




}