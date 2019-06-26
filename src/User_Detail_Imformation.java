
//QQ登录界面制作
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.getBoolean;
import static java.lang.Integer.parseInt;
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

    static JLabel textfield_birthdate;
    static JLabel textfield_age;

    static JScrollPane scrollPane;

    static int int_remain_height;

    static JTextField textfield_times;
    static JTextArea textare_record1;

    static String[] string_first_record;//8
    static String[] string_new_record;//8
    static String[][] string_history_record;//n 8

    static JTextArea textarea_final_record;

    static String string_state;


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
    //取消打勾

    //第二个勾的细节
    //右边面板的动态添加，以及数据库
    static String user_id_static;
    static String state_static;


    public static void User_Detail_Imformation(String state,String user_id) {
        user_id_static=user_id;
        state_static=state;
        //string_state是现在搜索到的state，state是传递的state，将要改变的state
        //this method be used three times,"waitToNoti" or "waitToBuy" will be used as state
        //waitToNoti will be used by the first page, changestate(this may be waitToNoti or waitToBuy) will be used when change the page, waitToNoti will be used for the new page
        //state will be used in this method while the checkbox is ticked, and the state will be transfer to update database
        //differeniate this method called by "create new one" or "browse the exsited one" by the user_id is null or not
        //新增 和 查看界面点出来的区别靠 user_id来区别

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

        string_state=user_detail_info[17];


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


                String times = textfield_times.getText();
                if(name.equals("")){
                    nullItems+="购药次数 ";
                }

                int y,m,d;
                Calendar cal=Calendar.getInstance();
                y=cal.get(Calendar.YEAR);
                m=cal.get(Calendar.MONTH)+1;
                d=cal.get(Calendar.DATE);

                string_first_record=new String[8];
                string_first_record[0]=null;
                string_first_record[1]=ID;//id
                string_first_record[2]=y+"";//year
                string_first_record[3]=m+"";//month
                string_first_record[4]=d+"";//day
                string_first_record[5]=times;//times
                string_first_record[6]="new";//noti_buy
                string_first_record[7]=textare_record1.getText();//record


                if(!nullItems.equals("")){//未正确填写信息
                    JOptionPane.showMessageDialog(null, "请正确填写 "+nullItems, "未补全信息", JOptionPane.ERROR_MESSAGE);
                }else if(user_id==null){//新增
                    String[] checkIdExist=database.searchByID(ID)[0];//搜索id，如无返回null
                    System.out.println("检测id是否存在"+checkIdExist[3]);

                    if(checkIdExist[3]==null){//id不存在，可以新增
                        int res=JOptionPane.showConfirmDialog(null, "点击确认后将保存新增用户并退出", "确认保存", JOptionPane.YES_NO_OPTION);
                        if(res==JOptionPane.YES_OPTION){//确认
                            System.out.println("已检测无该id存在");

                            //excute to table_name
                            database.insert(name,gender,ID,owner,phone,owner1,phone1,owner2,phone2,medical,disease_type,insurance_type,address,year,month,day);

                            //excute to table_record
                            database.insertRecord(string_first_record);

                            user_detail_imformation.dispose();
                            //System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
                        }else{//取消
                            //System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
                            return;
                        }


                    }else{//id已经存在，无法新增
                        JOptionPane.showMessageDialog(null, "该身份证已经存在"+nullItems, "无法储存", JOptionPane.ERROR_MESSAGE);
                    }

                }else if(user_id!=null){//修改
                    int res=JOptionPane.showConfirmDialog(null, "点击确认后将保存修改并退出", "确认保存", JOptionPane.YES_NO_OPTION);
                    if(res==JOptionPane.YES_OPTION){//确认
                        //edit on table_name
                        database.update(name,gender,ID,owner,phone,owner1,phone1,owner2,phone2,medical,disease_type,insurance_type,address,year,month,day,state);

                        //edit the table_record(actully its insert a new record or update if it has been inserted once)
                        string_new_record[7]=textarea_final_record.getText();
                        //第一次插入，判定第几次买药或提醒 来看唯一性
                        //相同应该是不是第一次插入？
                        //ture 为已经添加
                        //不是第一次插入，只要更新就行，根据最后一个就可以了
                        if((string_state.equals("waitToNoti")&&string_history_record[string_history_record.length - 1][6].equals("noti"))||(string_state.equals("waitToBuy")&&string_history_record[string_history_record.length - 1][6].equals("buy"))){
                            database.updateRecord(string_new_record, Integer.parseInt(string_history_record[string_history_record.length - 1][0]));

                        }else {
                            database.insertRecord(string_new_record);

                        }


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
                    Label_forForm_noti_buy.repaintIt();
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

        textfield_ID.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if(textfield_ID.getText().length()<17){//小于17位可以输数字
                    if(!(((keyChar >= '0' && keyChar <= '9')))){
                        e.consume(); //缺点，不能控制赋值黏贴的内容
                    }
                }

                if(textfield_ID.getText().length()==17){//最后一位数字或x，X
                    if(!(((keyChar >= '0' && keyChar <= '9')||keyChar == 'x'||keyChar == 'X'))){
                        e.consume(); //缺点，不能控制赋值黏贴的内容
                    }
                }
                if(textfield_ID.getText().length()==18){//超过18位不允许输入
                    e.consume();
                }
            }
        });


        JPanel ID = new JPanel();
        ID.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        ID.add(label_ID);
        ID.add(textfield_ID);
        ID.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(ID);

            JLabel label_age = new JLabel("年龄:                 ");
            textfield_age=new JLabel("  岁");
        JPanel age = new JPanel();
        age.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        age.add(label_age);
        age.add(textfield_age);
        age.setBounds(20,23+ row_number*40,3000,40);
        row_number++;
        b.add(age);

            JLabel label_birthdate = new JLabel("出生日期:          ");
            textfield_birthdate=new JLabel("    年 月 日");
        JPanel birthdate = new JPanel();
        birthdate.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        birthdate.add(label_birthdate);
        birthdate.add(textfield_birthdate);
        birthdate.setBounds(20,20+ row_number*40,3000,40);
        row_number++;
        b.add(birthdate);

        //自动设置年龄
        textfield_ID.addKeyListener(new KeyAdapter() {
            //键入某个键时调用此方法。
            public void keyTyped(KeyEvent event)
            {

                char ch=event.getKeyChar();
                if(textfield_ID.getText().length()==17){//7位开始
                    set_age_birthdate(textfield_ID.getText());
                }

            }

        });

        if(string_ID!=null){
            set_age_birthdate(textfield_ID.getText());
        }

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
        string_history_record=null;
        if(!(string_ID==null)) {
            string_history_record = database.searchRecord(string_ID);
        }

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
        title.setBounds(20,hight,3000,70);
        hight+=75;
        b.add(title);

        JLabel label_noti = new JLabel("下次提醒:     ");
        textfield_noti_time_year=new JTextField("",5);
        textfield_noti_time_month=new JTextField("",3);
        textfield_noti_time_day=new JTextField("",3);
        System.out.println("aaa"+string_noti_time_year+" "+string_state+" "+state_static);
        //设置下次提醒的年月日的text 以及不能编辑
        if(user_id_static!=null) {//不为空
            if (string_state.equals("waitToNoti")||(string_state.equals("waitToBuy")&&state_static.equals("waitToBuy"))) {//两种情况，打电话，买并且不是在打勾
                textfield_noti_time_year.setText(string_noti_time_year);
                textfield_noti_time_month.setText(string_noti_time_month);
                textfield_noti_time_day.setText(string_noti_time_day);
                textfield_noti_time_year.setEditable(false);
                textfield_noti_time_month.setEditable(false);
                textfield_noti_time_day.setEditable(false);
            }
        }

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
        textfield_times = new JTextField("",5);
        if(user_id_static!=null) {
            //if (!string_history_record[string_history_record.length - 1][6].equals("new")) {
                textfield_times.setText(string_history_record[string_history_record.length - 1][5]);
                textfield_times.setEditable(false);
            //}
        }
//        if(!string_ID.equals("")){
//            textfield_times.setText(string_history_record);
//
//        }
        JPanel times = new JPanel();
        times.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        times.add(label_times);
        times.add(textfield_times);
        times.setBounds(20,hight,3000,40);
        hight+=40;
        b.add(times);

        JLabel label_record1 = new JLabel("概况:           ");
        String overview_year="";
        String overview_month="";
        String overview_day="";
        if(!user_id_static.equals("")){
            overview_year=string_history_record[0][2];
            overview_month=string_history_record[0][3];
            overview_day=string_history_record[0][4];
        }
        String overview_time = overview_year + "年" + overview_month + "月" + overview_day + "号";
        JLabel label_record1_time = new JLabel("");
        label_record1_time.setText(overview_time);
        JPanel name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        name.add(label_record1);
        name.add(label_record1_time);
        name.setBounds(20,hight,3000,20);
        hight+=30;
        b.add(name);

        textare_record1 = new JTextArea(1,1);
        textare_record1.setBounds(95,hight,250+60,100);
        if(user_id_static!=null) {
            //if (!string_history_record[string_history_record.length - 1][6].equals("new")) {
            textare_record1.setText(string_history_record[0][7]);
            textare_record1.setEditable(false);
            //}
        }
        hight+=120;
        b.add(textare_record1);



        JPanel panel_record_repeat=new JPanel();
        //panel_record_repeat.setLayout(null);

        BoxLayout layout=new BoxLayout(panel_record_repeat, BoxLayout.Y_AXIS);
        panel_record_repeat.setLayout(layout);

        //JPanel panel_record_substitute=new JPanel();
        //string_history_record=new String[database.searchRecord(string_ID).length][8];

        int loop_times=0;
        if(user_id_static!=null) {
            int y, m, d;
            Calendar cal = Calendar.getInstance();
            y = cal.get(Calendar.YEAR);
            m = cal.get(Calendar.MONTH) + 1;
            d = cal.get(Calendar.DATE);

            string_new_record = new String[8];
            string_new_record[0] = null;//null
            string_new_record[1] = user_id_static;//id
            string_new_record[2] = y + "";//year
            string_new_record[3] = m + "";//month
            string_new_record[4] = d + "";//day
            /*
             * asdfasdf
             * */
            string_new_record[5] = string_history_record[string_history_record.length - 1][5];//times
            string_new_record[6] = "buy";//noti_buy

            string_new_record[7] = "";//record

            if (string_history_record[string_history_record.length - 1][6].equals("buy")) {
                string_new_record[5] = (Integer.parseInt(string_new_record[5]) + 1) + "";//times +1
                string_new_record[6] = "noti";
            }
            if(string_history_record[string_history_record.length - 1][6].equals("new")){
                string_new_record[6] = "noti";
            }

            int length_string_history_record=string_history_record.length;
            System.out.println("asdf"+string_new_record[5]);

            //判定是否添加新的一次进入数据库record, true 就是已经添加
            if((string_state.equals("waitToNoti")&&string_history_record[string_history_record.length - 1][6].equals("noti"))||(string_state.equals("waitToBuy")&&string_history_record[string_history_record.length - 1][6].equals("buy"))){
                length_string_history_record-=1;
                string_new_record[5] = string_history_record[string_history_record.length - 1][5];//times
                string_new_record[6] = string_history_record[string_history_record.length - 1][6];//noti_buy
                string_new_record[7]=string_history_record[string_history_record.length - 1][7];//record
            }

            for (int i = 1; i < length_string_history_record; i++) {
                int hight_of_record = 0;
                //JPanel panel_record_substitute=new JPanel();
                //panel_record_substitute
                panel_record_repeat = createJPanelOfRecord(panel_record_repeat, string_history_record[i], "");

                //panel_record_substitute.setBounds(0,0,250,120);
                //hight+=120;
                //panel_record_repeat.add(panel_record_substitute);
                //hight_of_record+=40;
                loop_times = i;
            }




            //String[] new_record={"",};
            panel_record_repeat = createJPanelOfRecord(panel_record_repeat, string_new_record, "new_record");

        }
        /*
        panel_record_repeat.add(Box.createVerticalStrut(int_remain_height));
        */
        //panel_record_repeat.add(Box.createVerticalGlue());
        panel_record_repeat.setBounds(20,hight,390,120*loop_times);

        //panel_record_repeat.setBorder(BorderStyle.None);
        //scrollPane.add(panel_record_repeat);
//        Checkbox cb=new Checkbox();
//        cb.setBounds(0,18,250,18);
//        JPanel a=new JPanel();
//        BoxLayout layout1=new BoxLayout(a, BoxLayout.Y_AXIS);
//        a.setLayout(layout1);
//        a.add(cb);

        scrollPane=new JScrollPane();
        scrollPane.setViewportView(panel_record_repeat);
        panel_record_repeat.setAutoscrolls(true);
        scrollPane.setBounds(20,hight,390,230);
        scrollPane.setBorder(null);
        //scrollPane
        //panel_record_substitute.add(panel_record_substitute)

        b.add(scrollPane);

        return b;
    }

    public static JPanel createJPanelOfRecord(JPanel panel_record_forLoop,String[] record_history, String new_record){

        int hight_create_record=0;
        JPanel panel_create_record_X = new JPanel();
        // 设置 bottomPanel 为垂直布局
        panel_create_record_X.setLayout(new BoxLayout(panel_create_record_X,BoxLayout.X_AXIS ));

        JPanel panel_create_record_textarea = new JPanel();
        // 设置 bottomPanel 为垂直布局
        panel_create_record_textarea.setLayout(new BoxLayout(panel_create_record_textarea,BoxLayout.X_AXIS ));
        //JPanel panel_record = new JPanel();
        String string_for_noti_buy=null;
        if(record_history[6].equals("buy")){
            string_for_noti_buy="买药";
        }else if(record_history[6].equals("noti")){
            string_for_noti_buy="致电";
        }
        String string_for_label_record="第"+
                record_history[5]+
                "次" +
                string_for_noti_buy +
                ":  "+
                record_history[2]+
                "年"+
                record_history[3]+
                "月"+
                record_history[4]+
                "日";

        JLabel label_record = new JLabel(string_for_label_record);
        //label_record.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextArea textarea_record = new JTextArea(3, 20);
        if(new_record.equals("")) {

            textarea_record.setText(record_history[7]);
            textarea_record.setLineWrap(true);
        }
        if(new_record.equals("new_record")){
            textarea_final_record= new JTextArea(3, 20);
            textarea_final_record.setText(record_history[7]);
            textarea_final_record.setLineWrap(true);
        }

        //panel_record.setLayout(null);
        //label_record.setBounds(0,hight_create_record+i*120,20, 40);

        //textarea_record.setBounds(100,hight_create_record+i*120+40,250,40);


        panel_create_record_X.add(label_record);
        panel_create_record_X.add(Box.createHorizontalGlue());

        panel_create_record_textarea.add(Box.createHorizontalStrut(75));
        //以下几行是判断是否最后一个textarea
        if(new_record.equals("")) {
            panel_create_record_textarea.add(textarea_record);
            int_remain_height = 230 - (textarea_record.getX() + textarea_record.getHeight()) - 90;
        }
        if(new_record.equals("new_record")) {
            panel_create_record_textarea.add(textarea_final_record);
            int_remain_height = 230 - (textarea_final_record.getX() + textarea_final_record.getHeight()) - 90;
        }

        panel_record_forLoop.add(panel_create_record_X);
        panel_record_forLoop.add(Box.createVerticalStrut(5));
        panel_record_forLoop.add(panel_create_record_textarea);
        panel_record_forLoop.add(Box.createVerticalStrut(20));

        //panel_record_forLoop.add(Box.createVerticalStrut(230-5-20-40-textarea_record.getHeight()-25));
        //panel_record_forLoop.add(Box.createVerticalStrut(230-(textarea_record.getX()+textarea_record.getHeight())-90));

//        panel_record_temporary.setBounds(100,hight_create_record+i*120+40,250,4000);
//        panel_record_forLoop.add(panel_record_temporary);
        //panel_record_forLoop.add(Box.createVerticalGlue());

        return panel_record_forLoop;
    }
    public static void set_age_birthdate(String idForAgeBirthdate){
            String string_textfield_id=textfield_ID.getText();
            String birth_year = string_textfield_id.substring(6,10);
            String birth_month = string_textfield_id.substring(10,12);
            String birth_day = string_textfield_id.substring(12,14);
            String birth_date = birth_year +"年" +birth_month+"月"+birth_day+"日";
            textfield_birthdate.setText(birth_date);

            int y,m,d;
            Calendar cal=Calendar.getInstance();
            y=cal.get(Calendar.YEAR);
            m=cal.get(Calendar.MONTH)+1;
            d=cal.get(Calendar.DATE);

            int age=y-parseInt(birth_year);

            if(parseInt(birth_month)==m){
                if(parseInt(birth_day)<d){
                    age-=1;
                }
            }else if(parseInt(birth_month)<m){
                age-=1;
            }
            textfield_age.setText(age+"");
    }
}