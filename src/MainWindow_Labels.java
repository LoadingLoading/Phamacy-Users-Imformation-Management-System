import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class MainWindow_Labels {
    private static DefaultTableModel tableModel;   //表格模型对象
    private static JTable table;
    private static JTextField aTextField;
    private static JTextField bTextField;
    public static JPanel whole_frame;
    public static JPanel tick_boxs;
    public static String[][] getTableVales;

    public static JPanel noti_buy(JPanel jp2,String noti_buy,String[] search_infos){
        /**
         *
         *
         *                     search_infos[0]=name;
         *                     search_infos[1]=gender;
         *                     search_infos[2]=ID;
         *                     search_infos[3]=phone;
         *                     search_infos[4]=medical;
         *                     search_infos[5]=disease_type;
         *                     search_infos[6]=insurance_type;
         *                     search_infos[7]=address;
         */


        whole_frame = new JPanel();

        whole_frame.setLayout(null);
        //whole_frame.setBounds(0,0,1200,900);



        String[] columnNames=null;
        if(noti_buy.equals("noti")){
            String[] columnNamesForNoti = {"姓名","性别","购药次数","药名","号主+号码","上次买药时间","身份证号"};
            columnNames=columnNamesForNoti;
        }else if(noti_buy.equals("buy")){
            String[] columnNamesForBuy = {"离已致电天数","姓名","性别","购药次数","药名","号主+号码","上次买药时间","身份证号"};
            columnNames=columnNamesForBuy;
        }else if(noti_buy.equals("search")){
            String[] columnNamesForNoti = {"姓名","性别","购药次数","药名","号主+号码","上次买药时间","身份证号"};
            columnNames=columnNamesForNoti;
        }

        getTableVales=null;
        String[][] tableVales=null;


        if(noti_buy.equals("noti")) {
            getTableVales = getTodayInfo();
            tableVales = new String[isNull(getTableVales)][7];
            for (int i = 0; i < isNull(getTableVales); i++) {
                tableVales[i][0] = getTableVales[i][1];
                tableVales[i][1] = getTableVales[i][2];

                //getTableVales[i][3]是身份证id，用这个搜索record，得到的就是record，最后一个的次数就是：购药次数
                String[][] string_history_record=Database.searchRecord(getTableVales[i][3]);
                tableVales[i][2] =  "致电后为第"+string_history_record[string_history_record.length-1][5]+"次买药";

                tableVales[i][3] = getTableVales[i][10];
                tableVales[i][4] = getTableVales[i][4] + " " + getTableVales[i][5];

                String date_last_bought="";
                if(string_history_record.length<=2){
                    date_last_bought="上次购药时间未记录";
                }else{
                    date_last_bought=string_history_record[string_history_record.length-2][2]+"年"+
                            string_history_record[string_history_record.length-2][3]+"月"+
                            string_history_record[string_history_record.length-2][4]+"日";
                }
                tableVales[i][5] =date_last_bought;

                tableVales[i][6] = getTableVales[i][3];
            }
        }else if(noti_buy.equals("buy")){
            getTableVales = Database.searchByState("waitToBuy");
            tableVales = new String[isNull(getTableVales)][8];
            for (int i = 0; i <isNull( getTableVales); i++) {

                int days_to_noti=0;
                String[][] string_history_record=Database.searchRecord(getTableVales[i][3]);
                if(string_history_record[string_history_record.length-1][6].equals("noti")){
                    System.out.println("使用上一次的");
                    days_to_noti=getDays(string_history_record[string_history_record.length-1][2],string_history_record[string_history_record.length-1][3],string_history_record[string_history_record.length-1][4]);
                }else{
                    days_to_noti=getDays(string_history_record[string_history_record.length-2][2],string_history_record[string_history_record.length-2][3],string_history_record[string_history_record.length-2][4]);
                }
                tableVales[i][0] =days_to_noti+ "天";

                tableVales[i][1] = getTableVales[i][1];
                tableVales[i][2] = getTableVales[i][2];

                //getTableVales[i][3]是身份证id，用这个搜索record，得到的就是record，最后一个的次数就是：购药次数
                //String[][] string_history_record=Database.searchRecord(getTableVales[i][3]);
                tableVales[i][3] =  "第"+string_history_record[string_history_record.length-1][5]+"次买药";

                tableVales[i][4] = getTableVales[i][10];
                tableVales[i][5] = getTableVales[i][4] + " " + getTableVales[i][5];

                //如果少于三个数组，则说明上次未记录，第一个是添加时的数组，第二个是上次打电话的数组，第三个是现在正在记录的数组
                //如果未打开详细信息，则不会创建第三个数组，则需要小雨等于三
                String date_last_bought="";
                if(string_history_record.length<=3){
                    date_last_bought="上次购药时间未记录";
                }else{
                    date_last_bought=string_history_record[string_history_record.length-3][2]+"年"+
                            string_history_record[string_history_record.length-3][3]+"月"+
                            string_history_record[string_history_record.length-3][4]+"日";
                }
                tableVales[i][6] = date_last_bought;

                tableVales[i][7] = getTableVales[i][3];
            }
        }else if(noti_buy.equals("search")&&search_infos!=null){
            /**
             *
             *                     输入的
             *                     search_infos[0]=name;
             *                     search_infos[1]=gender;
             *                     search_infos[2]=ID;
             *                     search_infos[3]=phone;
             *                     search_infos[4]=medical;
             *                     search_infos[5]=disease_type;
             *                     search_infos[6]=insurance_type;
             *                     search_infos[7]=address;
             */

            /**
             *
             *                     从数据库输出回来的的
             *                     getTableVales[0]=number;
             *                     getTableVales[1]=name;
             *                     getTableVales[2]=gender;
             *                     getTableVales[3]=id;
             *                     getTableVales[4]=owner0;
             *                     getTableVales[5]=phone0;
             *                     getTableVales[6]=owner1;
             *                     getTableVales[7]=phone1;
             *                     getTableVales[8]=owner2;
             *                     getTableVales[9]=phone2;
             *                     getTableVales[10]=medicine;
             *                     getTableVales[11]=desease;
             *                     getTableVales[12]= insurance_type
             *                     getTableVales[13]=address;
             *                     getTableVales[14]=year;
             *                     getTableVales[15]=month;
             *                     getTableVales[16]=day;
             *                     getTableVales[17]=state;
             */
            //记得进行id的数字检测
            getTableVales = Database.searchByAll(search_infos);
            tableVales = new String[isNull(getTableVales)][7];
            for (int i = 0; i < isNull(getTableVales); i++) {
                tableVales[i][0] = getTableVales[i][1];
                tableVales[i][1] = getTableVales[i][2];

                //getTableVales[i][3]是身份证id，用这个搜索record，得到的就是record，最后一个的次数就是：购药次数
                String[][] string_history_record=Database.searchRecord(getTableVales[i][3]);
                tableVales[i][2] =  "致电后为第"+string_history_record[string_history_record.length-1][5]+"次买药";

                tableVales[i][3] = getTableVales[i][10];
                tableVales[i][4] = getTableVales[i][4] + " " + getTableVales[i][5];

                String date_last_bought="";
                if(string_history_record.length<=2){
                    date_last_bought="上次购药时间未记录";
                }else{
                    date_last_bought=string_history_record[string_history_record.length-2][2]+"年"+
                            string_history_record[string_history_record.length-2][3]+"月"+
                            string_history_record[string_history_record.length-2][4]+"日";
                }
                tableVales[i][5] =date_last_bought;

                tableVales[i][6] = getTableVales[i][3];
            }

            //getTableVales = Database.searchByAll(search_infos);

        }
//在table初始化后添加动态tickbox
        tick_boxs = new JPanel();
        tick_boxs.setLayout(null);
        int wide_of_tickbox=25;
        if(isNull(getTableVales)>=9){
            wide_of_tickbox=31;
        }else if(isNull(getTableVales)>=99){
            wide_of_tickbox=37;
        }else if(isNull(getTableVales)>=999){
            wide_of_tickbox=43;
        }
        //if(!noti_buy.equals("search")) {
        for (int i = 0; i < isNull(getTableVales); i++) {
            Checkbox cb = createCheckbox(i + 1 + "", noti_buy);
            cb.setBounds(0, 18 * i + 22, wide_of_tickbox, 18);
            tick_boxs.add(cb);
            System.out.println("_________________刷新_____________");
            if (getTableVales[i][isNull(getTableVales[i]) - 1].equals("waitToBuy")) {
                cb.setState(true);
            }
            if (getTableVales[i][isNull(getTableVales[i]) - 1].equals("waitToNoti")) {
                cb.setState(false);
            }
            if (noti_buy.equals("buy")) {//如果在今日买药界面，则相反
                cb.setState(!cb.getState());
            }
            if(noti_buy.equals("search")){
                cb.setEnabled(false);
            }
//            if(i>=1) {
//                tick_boxs.add(cb);
//            }
            //cb.setState();
        }
        //}



        //tick_boxs

        tick_boxs.setBackground(Color.white);
        tick_boxs.setBounds(0,0,wide_of_tickbox,1000);
        whole_frame.add(tick_boxs);
        //添加tickbox完毕，继续table

        //String [][]tableVales={{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXX4837"},}; //数据
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //table.getSelectedRow();
        //table.getColumnModel().getColumn(1).setWidth(10080);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        table.setRowHeight(18);


           //支持滚动
        //getContentPane().add(scrollPane,BorderLayout.CENTER);
        //jdk1.6
        //排序:
        //table.setRowSorter(new TableRowSorter(tableModel));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        //table.setCellSelectionEnabled(false);
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){

                //new SecondWindow();
                int clickTimes = e.getClickCount();
                if (clickTimes == 2) {
                    int selectedRow = table.getSelectedRow(); //获得选中行索引
                    System.out.println("表格所选身份证号为"+getTableVales[selectedRow][3]);
                    if(noti_buy.equals("buy")){//如果是第二个界面就是相反的
                        SecondWindow.User_Detail_Imformation("waitToBuy",getTableVales[selectedRow][3]);
                    }
                    if(noti_buy.equals("noti")){//如果是第二个界面就是相反的
                        SecondWindow.User_Detail_Imformation("waitToNoti",getTableVales[selectedRow][3]);
                    }
                    if(noti_buy.equals("search")){//如果是第二个界面就是相反的
                        SecondWindow.User_Detail_Imformation("waitToNoti",getTableVales[selectedRow][3]);
                    }

                }
//                if (clickTimes == 1) {
//                    int selectedRow = table.getSelectedRow(); //获得选中行索引
//                    int selectedcol=table.getSelectedColumn();
//                    //table[selectedRow][selectedcol]
//                    System.out.println("表格所选身份证号为"+getTableVales[selectedRow][3]);
//
//
//                }
                //int selectedRow = table.getSelectedRow(); //获得选中行索引
//                Object oa = tableModel.getValueAt(selectedRow, 6);
//                Object ob = tableModel.getValueAt(selectedRow, 1);
                //System.out.println("表格所选身份证号为"+tableModel.getValueAt(selectedRow, 6));


//                aTextField.setText(oa.toString());  //给文本框赋值
//                bTextField.setText(ob.toString());
            }
        });






//
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(wide_of_tickbox,0,1150,700);

        whole_frame.add(scrollPane);

        JScrollPane scrollPane1 = new JScrollPane(whole_frame);
//        scrollPane.setViewportView(whole_frame);
//        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(whole_frame);
        //final JPanel jp2 = new JPanel();
        //getContentPane().add(jp2,BorderLayout.SOUTH);
        //JScrollPane jsp=new JScrollPane(whole_frame);
        jp2.setLayout(new GridLayout(1,1));
        jp2.removeAll();
        //jsp.setBounds(0,0,1200,700);
        jp2.add(scrollPane1);

        //jp2.add(scrollPane);
        //JScrollPane scrollPane1 = new JScrollPane(jp2);
        //scrollPane1.setViewportView(jp2);
        //getTodayInfo();
//        String aaaa[][]=Database.searchByID("23323");
//        System.out.println("aaaa"+aaaa[0][0]);//结果为null
        //whole_frame.repaint();
        return jp2;
    }

    private static Checkbox createCheckbox(String label,String noti_buy) {
        Checkbox cb = new Checkbox(label);
        //cb.addItemListener(SecondWindow.jb2);
        //给Checkbox对象注册事件监听，也可以去监听其它事件，比如鼠标事件什么的
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String changeState=null;

                Checkbox cb = (Checkbox)e.getSource();
                int checkBoxSelected=parseInt(cb.getLabel())-1;
                boolean stateAfterClick=cb.getState();
                System.out.println(stateAfterClick);
                int column_table_ticked=6;
                if(noti_buy.equals("buy")){//如果是第二个界面就是相反的
                    stateAfterClick=!stateAfterClick;
                    column_table_ticked=7;
                }
                if(!stateAfterClick){
                    //本来打了勾，取消打勾
                    //点了以后会先变成false，原来是true，原来是打勾，原来是buy
                    changeState="waitToNoti";
                }else if(stateAfterClick){
                    //如果本来没有打勾，打勾是为了变成
                    //相反点
                    changeState="waitToBuy";
                }
                String waitToBuy_userId=tableModel.getValueAt(checkBoxSelected, column_table_ticked).toString();
                //int canceled=
                System.out.println("changeState是"+changeState);
                SecondWindow.User_Detail_Imformation(changeState,waitToBuy_userId);
//                if(canceled==1){
//                    cb.setState(false);
//                }
                System.out.println(waitToBuy_userId);
                System.out.println("Checkbox "+cb.getLabel()+"的选择状态："+cb.getState());
            }
        });



        return cb;
    }

    public static void repaintIt(){

//        whole_frame.invalidate();
//        whole_frame.validate();
//        whole_frame.setVisible(false);
//        whole_frame.setVisible(true);
//        whole_frame.updateUI();

        //取消打勾
        //因为改过勾勾右边的数字，导致这里出现bug
        int count = tick_boxs.getComponentCount();
        for (int i = 0; i < count; i++) {
            Component comp = tick_boxs.getComponent(i);
            if(comp instanceof Checkbox){

                String[][] getTableVales=getTodayInfo();
                System.out.println("getTableVales的长度是"+getTableVales.length);
//                String waitToBuy_userId=tableModel.getValueAt(i, 6).toString();
                if(getTableVales[i][17].equals("waitToNoti")){
                    Checkbox btn = (Checkbox)comp;
                    btn.setState(false);
                }else if(getTableVales[i][17].equals("waitToBuy")){
                    Checkbox btn = (Checkbox)comp;
                    btn.setState(true);
                }
            }

        }

        System.out.println("_________________刷新_____________1");

    }
    public static String[][] getTodayInfo(){
        String[][] Infos=null;
        String[] IDs=null;
        IDs=getTodayID();
        //System.out.println(IDs[0]);
//        System.out.println(isNull(Infos));

        /**
        * *
        * */
        System.out.println(isNull(IDs));


//        System.out.println(Database.searchByID(isNull(IDs[0])));
        Infos=new String[isNull(IDs)][18];
        for(int i = 0;i<isNull(IDs);i++){
            //System.out.println("循环了几次");
            //System.out.println("search"+Database.searchByID(IDs[i])[0][1]);
            Infos[i]= Database.searchByID(IDs[i])[0];
            //String p[]=Database.searchByID(IDs[i])[0];

        }
        for (int i = 0; i < isNull(Infos); i++) {
            System.out.println("身份证为 "+IDs[i]+" 的信息为：");
            for (int j = 0; j < 18; j++) {
                //String id = IDs[j];
                System.out.print(Infos[i][j]+" ");

            }
            System.out.println();


        }
        System.out.println("面板"+"运行到这里");

        //Infos[]=Database.searchByID(IDs);

        return Infos;
    }



    public static String[] getTodayID(){
        String[] IDs=null;
//        int y,m,d;
//        Calendar cal=Calendar.getInstance();
//        y=cal.get(Calendar.YEAR);
//        m=cal.get(Calendar.MONTH)+1;
//        d=cal.get(Calendar.DATE);
//        System.out.println("面板"+y+" "+m+" "+d);

        IDs= Database.searchByDate(getTodayDate()[0]+"",getTodayDate()[1]+"",getTodayDate()[2]+"");

        /**
         *
         */

        for(int i=0;i<isNull(IDs);i++){
            System.out.println("今天的id有： "+IDs[i]);

        }
        return IDs;
    }

    public static int[] getTodayDate() {
        int[] todayDate=new int[3];
        //todayDate=null;
        int y,m,d;
        Calendar cal=Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH)+1;
        d=cal.get(Calendar.DATE);
        todayDate[0]=y;
        todayDate[1]=m;
        todayDate[2]=d;
        System.out.println("获得今日日期"+y+" "+m+" "+d);
        return todayDate;
    }

    public static int isNull(String[] strings) {
        if(strings==null){
            return 0;
        }else{
            return strings.length;
        }

    }

    public static int isNull(String[][] strings) {
        if(strings==null){
            return 0;
        }else{
            return strings.length;
        }
    }

    public static int getDays(String y,String m, String d) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR,  Integer.parseInt(y));
        cal1.set(Calendar.MONTH,  Integer.parseInt(m)-1);
        cal1.set(Calendar.DAY_OF_MONTH,  Integer.parseInt(d));

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR,  getTodayDate()[0]);
        cal2.set(Calendar.MONTH,  getTodayDate()[1]-1);
        cal2.set(Calendar.DAY_OF_MONTH, getTodayDate()[2]);

        System.out.println("相差天数的计算，输入cal的今天是"+  getTodayDate()[0]+"年"+( getTodayDate()[1]-1)+"月"+getTodayDate()[2]+"日"+"，计算的是："+Integer.parseInt(y)+" "+ (Integer.parseInt(m)-1)+" "+Integer.parseInt(d) );

        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }


    }

}
