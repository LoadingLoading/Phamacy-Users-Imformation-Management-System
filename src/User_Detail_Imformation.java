
//QQ登录界面制作
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.getBoolean;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.SOUTH;

public class User_Detail_Imformation extends JFrame {
    static JTextField  textfield_name;
    static JComboBox combobox_gender;
    static JTextField textfield_ID;
    static JComboBox combobox_owner;
    static JTextField field_number;
    static JComboBox combobox_owner1;
    static JTextField field_number1;
    static JComboBox combobox_owner2;
    static JTextField field_number2;

    static String string_name;
    static String string_gender;
    static String string_ID;
    static String string_owner;
    static String string_number;
    static String string_owner1;
    static String string_number1;
    static String string_owner2;
    static String string_number2;

    static JComboBox combobox_medical;
    static JComboBox combobox_disease_type;
    static JComboBox combobox_insurance_type;
    static JTextField  textfield_address;

    static String string_medical;
    static String string_disease_type;
    static String string_insurance_type;
    static String string_address;

    static JTextField textfield_noti_time_year;
    static JTextField textfield_noti_time_month;
    static JTextField textfield_noti_time_day;

    static String string_noti_time_year;
    static String string_noti_time_month;
    static String string_noti_time_day;



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
    //刚刚完成：id的约束，修改以及添加的区别化
    //id的自动生成，第二个表格数据库的创建，动态界面，滚屏？下一步两个打勾，第二个界面的显示，以及取消提醒，搜索功能，管理员功能，添加一个文档储存基本信息 （打包成exe用来debug）如数据库账号密码，添加的小加号，账号管理功能，说明界面，其他未知的用户需求
    //already_bought有三种状态 watiToNoti：等待被提醒 waitToBuy:等待买药 notBuyAnymore:不再提醒

    public static void User_Detail_Imformation(String state,String user_id) {
        int isCanceled=0;
        String[] user_detail_info=new String[18];

        //通过表格点击传递的id得到该用户的详细信息，储存在static的变量里，供给面板信息用
        user_detail_info=database.searchByID(user_id)[0];
            for(int i=0;i<18;i++){
            System.out.println(i+" "+user_detail_info[i]);
        }
        string_name=user_detail_info[1];
        string_gender=user_detail_info[2];
        string_ID=user_detail_info[3];
        string_owner=user_detail_info[4];
        string_number=user_detail_info[5];
        string_owner1=user_detail_info[6];
        string_number1=user_detail_info[7];
        string_owner2=user_detail_info[8];
        string_number2=user_detail_info[9];

        string_medical=user_detail_info[10];
        string_disease_type=user_detail_info[11];
        string_insurance_type=user_detail_info[12];
        string_address=user_detail_info[13];

        string_noti_time_year=user_detail_info[14];
        string_noti_time_month=user_detail_info[15];
        string_noti_time_day=user_detail_info[16];


        //以下为布局
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
        user_detail_imformation.setSize(900, 700);
        user_detail_imformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user_detail_imformation.setTitle("查看/添加/编辑用户详细信息");
        user_detail_imformation.setLocationRelativeTo(null);
        user_detail_imformation.setVisible(true);
        user_detail_imformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        //以下为点击确认以后，检测符合条件，再insert
        jb1.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){


                System.out.println("ok");

                String nullItems="";


                String name = textfield_name.getText();
                if(name.equals("")){
                    nullItems+="姓名 ";
                }

                String gender=null;
                if(combobox_gender.getSelectedIndex()!=-1){//-1就是没选
                    gender = combobox_gender.getSelectedItem().toString();
                }else{
                    nullItems+="性别 ";
                }

                String ID = textfield_ID.getText();
                if(ID.equals("")){
                    nullItems+="身份证 ";
                }

                String owner = null;
                if(combobox_owner.getSelectedIndex()!=-1){//-1就是没选
                    owner = combobox_owner.getSelectedItem().toString();
                }else{
                    nullItems+="手机号归属人 ";
                }
                String phone = field_number.getText();
                if(phone.equals("")){
                    nullItems+="手机号 ";
                }

                String owner1 = null;
                if(combobox_owner1.getSelectedIndex()!=-1){//-1就是没选
                    owner1 = combobox_owner1.getSelectedItem().toString();
                }
                String phone1 = field_number1.getText();


                String owner2 = null;
                if(combobox_owner2.getSelectedIndex()!=-1){//-1就是没选
                    owner2 = combobox_owner2.getSelectedItem().toString();
                }
                String phone2 = field_number2.getText();

                String medical = null;
                if(combobox_medical.getSelectedIndex()!=-1){//-1就是没选
                    medical = combobox_medical.getSelectedItem().toString();
                }else{
                    nullItems+="药品类型 ";
                }

                String disease_type = null;
                if(combobox_disease_type.getSelectedIndex()!=-1){//-1就是没选
                    disease_type = combobox_disease_type.getSelectedItem().toString();
                }else{
                    nullItems+="疾病类型 ";
                }

                String insurance_type = null;
                if(combobox_insurance_type.getSelectedIndex()!=-1){//-1就是没选
                    insurance_type = combobox_insurance_type.getSelectedItem().toString();
                }else{
                    nullItems+="医保类型 ";
                }

                String address = textfield_address.getText();
                if(address.equals("")){
                    nullItems+="手机号 ";
                }

                String year = textfield_noti_time_year.getText();
                if(year.equals("")){
                    nullItems+="提醒年份 ";
                }else if(!year.matches("\\d{4}")){
                    nullItems+="年份的正确形式 ";
                }

                String month = textfield_noti_time_month.getText();
                if(month.equals("")){
                    nullItems+="提醒月份 ";
                }else if(!(month.matches("\\d{2}")||month.matches("\\d{1}"))){
                    nullItems+="月份的正确形式 ";
                }

                String day = textfield_noti_time_day.getText();
                if(day.equals("")){
                    nullItems+="提醒日子 ";
                }else if(!(month.matches("\\d{2}")||month.matches("\\d{1}"))){
                    nullItems+="日子的正确形式 ";
                }



                if(!nullItems.equals("")){
                    JOptionPane.showMessageDialog(null, "请正确填写 "+nullItems, "未补全信息", JOptionPane.ERROR_MESSAGE);
                }else if(user_id==null){//新增
                    String[] checkIdExist=database.searchByID(ID)[0];//搜索id，如无返回null
                    System.out.println("检测id是否存在"+checkIdExist[3]);
                    if(checkIdExist[3]==null){//id不存在，可以新增

                        int res=JOptionPane.showConfirmDialog(null, "点击确认后将保存新增用户并退出", "确认保存", JOptionPane.YES_NO_OPTION);
                        if(res==JOptionPane.YES_OPTION){//确认
                            System.out.println("已检测无该id存在");
                            //System.out.println(name+gender+ID+medical);
                            database.insert(name,gender,ID,owner,phone,owner1,phone1,owner2,phone2,medical,disease_type,insurance_type,address,year,month,day);
                            user_detail_imformation.dispose();



                            //System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
                        }else{//取消
                            //System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
                            return;
                        }


                    }else{
                        JOptionPane.showMessageDialog(null, "该身份证已经存在"+nullItems, "无法储存", JOptionPane.ERROR_MESSAGE);
                    }

                }else if(user_id!=null){//修改
                    int res=JOptionPane.showConfirmDialog(null, "点击确认后将保存修改并退出", "确认保存", JOptionPane.YES_NO_OPTION);
                    if(res==JOptionPane.YES_OPTION){//确认
                        database.update(name,gender,ID,owner,phone,owner1,phone1,owner2,phone2,medical,disease_type,insurance_type,address,year,month,day,state);
                        user_detail_imformation.dispose();



                        System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
                    }else{//取消
                        System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
                        //return;
                    }

                }






            }
        });

        jb2.addMouseListener(new MouseAdapter(){    //取消并推出
            public void mouseClicked(MouseEvent e){
                String show_alert;
                if(user_id==null){
                    show_alert="点击确认后将放弃所有已输入新增信息，确定吗";
                }else{
                    show_alert="点击确认后将放弃更改所有已输入信息，确定吗";
                }


                int res=JOptionPane.showConfirmDialog(null, show_alert, "取消并推出", JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){//确认推出
                    //System.out.println("已检测无该id存在");
                    //return 1;
                    //Demo16.main();
                    Label_1_2_noti_buy.repaintIt();
                    //lablerepaintIt
                    user_detail_imformation.dispose();




                    //System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
                }else{//取消推出
                    //System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
                    return;
                }

            }
        });
        //return 1;

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

            JLabel label_name = new JLabel("姓名:               ");
            textfield_name=new JTextField(string_name,10);

        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_name);
        name.add(textfield_name);
        name.setBounds(20,20+row_number*40,3000,40);
        row_number++;
        b.add(name);

            JLabel label_gender = new JLabel("性别:               ");
            combobox_gender = new JComboBox();
            combobox_gender.addItem("男");
            combobox_gender.addItem("女");
            combobox_gender.setSelectedItem(string_gender);
            //combobox_gender.setSelectedIndex(-1);

        JPanel gender = new JPanel();
        gender.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        gender.add(label_gender);
        gender.add(combobox_gender);
        gender.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(gender);

            JLabel label_ID = new JLabel("身份证号:         ");
            textfield_ID=new JTextField(string_ID,15);
            if(string_ID!=null){
                textfield_ID.setEditable(false);
            }

        JPanel ID = new JPanel();
        ID.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        ID.add(label_ID);
        ID.add(textfield_ID);
        ID.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(ID);

            JLabel label_age = new JLabel("年龄:                 ");
            JLabel textfield_age=new JLabel("36");
        JPanel age = new JPanel();
        age.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        age.add(label_age);
        age.add(textfield_age);
        age.setBounds(20,23+ row_number*40,3000,40);
        row_number++;
        b.add(age);

            JLabel label_birthdate = new JLabel("出生日期:          ");
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
            JLabel label_number = new JLabel("手机号:    ");
            Icon icon_add = new ImageIcon("Pic/pic_add.png");
            JButton button_add_owner = new JButton(null,icon_add);
            button_add_owner.setBorderPainted(FALSE);
                JPanel one_owner_number = new JPanel();
                combobox_owner = new JComboBox();
                combobox_owner.addItem("本人");
                combobox_owner.addItem("儿子");
                combobox_owner.addItem("女儿");
                combobox_owner.setSelectedItem(string_owner);
                field_number = new JTextField(string_number,10);
                one_owner_number.add(combobox_owner);
                one_owner_number.add(field_number);

                JPanel one_owner_number1 = new JPanel();
                combobox_owner1 = new JComboBox();
                combobox_owner1.addItem("本人");
                combobox_owner1.addItem("儿子");
                combobox_owner1.addItem("女儿");
                combobox_owner1.setSelectedItem(string_owner1);
                field_number1 = new JTextField(string_number,10);
                one_owner_number1.add(combobox_owner1);
                one_owner_number1.add(field_number1);

                JPanel one_owner_number2 = new JPanel();
                combobox_owner2 = new JComboBox();
                combobox_owner2.addItem("本人");
                combobox_owner2.addItem("儿子");
                combobox_owner2.addItem("女儿");
                combobox_owner2.setSelectedItem(string_owner2);
                field_number2 = new JTextField(string_number2,10);
                one_owner_number2.add(combobox_owner2);
                one_owner_number2.add(field_number2);
        JPanel number = new JPanel();
        number.setLayout(null);

        number.add(label_number);
        label_number.setBounds(0,0,60,35);
        number.add(button_add_owner);
        button_add_owner.setBounds(70,0,18,35);
        int begin_pix=0;
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

            JLabel label_medical = new JLabel("药品类型: ");
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
            combobox_medical.setSelectedItem(string_medical);
        JPanel medical = new JPanel();
        medical.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        medical.add(label_medical);
        medical.add(button_add_owner_medical);
        medical.add(combobox_medical);
        medical.setBounds(20,80+ row_number*40,3000,40);
        row_number++;
        b.add(medical);

            JLabel label_disease_type = new JLabel("疾病类型: ");
            Icon icon_add_disease_type = new ImageIcon("Pic/pic_add.png");
            JButton button_add_disease_type = new JButton(null,icon_add_disease_type);
            button_add_disease_type.setBorderPainted(FALSE);
            combobox_disease_type = new JComboBox();
            combobox_disease_type.addItem("肺癌");
            combobox_disease_type.addItem("胃癌");
            combobox_disease_type.addItem("肝癌");
            combobox_disease_type.addItem("鼻咽癌");
            combobox_disease_type.addItem("肠癌");
            combobox_disease_type.setSelectedItem(string_medical);
        JPanel disease_type = new JPanel();
        disease_type.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        disease_type.add(label_disease_type);
        disease_type.add(button_add_disease_type);
        disease_type.add(combobox_disease_type);
        disease_type.setBounds(20,80+ row_number*40,3000,40);
        row_number++;
        b.add(disease_type);

            JLabel label_insurance_type = new JLabel("保险类型: ");
            Icon icon_add_insurance_type = new ImageIcon("Pic/pic_add.png");
            JButton button_add_insurance_type = new JButton(null,icon_add_insurance_type);
            button_add_insurance_type.setBorderPainted(FALSE);
            combobox_insurance_type = new JComboBox();
            combobox_insurance_type.addItem("无");
            combobox_insurance_type.addItem("职工医保");
            combobox_insurance_type.addItem("居民/农合");
            combobox_insurance_type.addItem("铁路医保");
            combobox_insurance_type.setSelectedItem(string_insurance_type);
        JPanel insurance_type = new JPanel();
        insurance_type.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        insurance_type.add(label_insurance_type);
        insurance_type.add(button_add_insurance_type);
        insurance_type.add(combobox_insurance_type);
        insurance_type.setBounds(20,80+ row_number*40,3000,40);
        row_number++;
        b.add(insurance_type);

            JLabel label_address = new JLabel("家庭住址:         ");
            textfield_address=new JTextField(string_address,25);
        JPanel address  = new JPanel();
        address.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        address.add(label_address);
        address.add(textfield_address);
        address.setBounds(20,80+ row_number*40,3000,40);
        row_number++;
        b.add(address);





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
        textfield_noti_time_year=new JTextField("",5);
        textfield_noti_time_month=new JTextField("",3);
        textfield_noti_time_day=new JTextField("",3);

        JLabel label_noti_time_year=new JLabel("年");
        JLabel label_noti_time_month=new JLabel("月");
        JLabel label_noti_time_day=new JLabel("日");
        JPanel noti = new JPanel();

        noti.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        noti.add(label_noti);
        noti.add(textfield_noti_time_year);
        noti.add(label_noti_time_year);
        noti.add(textfield_noti_time_month);
        noti.add(label_noti_time_month);
        noti.add(textfield_noti_time_day);
        noti.add(label_noti_time_day);
        //oti.add();

        noti.setBounds(20,hight,3000,40);
        hight+=40;
        b.add(noti);

        JLabel label_times = new JLabel("购药次数:     ");
        JTextField textfield_times= new JTextField("",5);
        JPanel times = new JPanel();
        times.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        times.add(label_times);
        times.add(textfield_times);
        times.setBounds(20,hight,3000,40);
        hight+=40;
        b.add(times);

        JLabel label_record1 = new JLabel("概况:           ");
        JLabel label_record1_time=new JLabel("2019年5月30号");
        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_record1);
        name.add(label_record1_time);
        name.setBounds(20,hight,3000,20);
        hight+=30;
        b.add(name);

        JTextArea textare_record1 = new JTextArea(1,1);
        textare_record1.setBounds(95,hight,250,100);
        hight+=120;
        b.add(textare_record1);






        return b;
    }




}