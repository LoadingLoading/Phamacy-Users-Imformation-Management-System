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

    public static JPanel noti_buy(JPanel jp2,String noti_buy){

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
        }

        getTableVales=null;
        String[][] tableVales=null;

        if(noti_buy.equals("noti")) {
            getTableVales = getTodayInfo();
            tableVales = new String[getTableVales.length][7];
            for (int i = 0; i < getTableVales.length; i++) {
                tableVales[i][0] = getTableVales[i][1];
                tableVales[i][1] = getTableVales[i][2];
                tableVales[i][2] = getTableVales[i][0] + "不知道";
                tableVales[i][3] = getTableVales[i][10];
                tableVales[i][4] = getTableVales[i][4] + " " + getTableVales[i][5];
                tableVales[i][5] = getTableVales[i][0] + "不知道";
                tableVales[i][6] = getTableVales[i][3];
            }
        }else if(noti_buy.equals("buy")){
            getTableVales = database.searchByState("waitToBuy");
            tableVales = new String[getTableVales.length][8];
            for (int i = 0; i < getTableVales.length; i++) {

                tableVales[i][0] = "未实现";
                tableVales[i][1] = getTableVales[i][1];
                tableVales[i][2] = getTableVales[i][2];
                tableVales[i][3] = getTableVales[i][0] + "不知道";

                tableVales[i][4] = getTableVales[i][10];
                tableVales[i][5] = getTableVales[i][4] + " " + getTableVales[i][5];
                tableVales[i][6] = getTableVales[i][0] + "不知道";
                tableVales[i][7] = getTableVales[i][3];
            }
        }
//在table初始化后添加动态tickbox
        tick_boxs = new JPanel();
        tick_boxs.setLayout(null);

        for (int i = 0; i < getTableVales.length; i++) {
            Checkbox cb = createCheckbox(i+"",noti_buy);
            cb.setBounds(0,18*i+18,25,18);
            tick_boxs.add(cb);
            System.out.println("_________________刷新_____________");
            if(getTableVales[i][getTableVales[i].length-1].equals("waitToBuy")){
                cb.setState(true);
            }
            if(getTableVales[i][getTableVales[i].length-1].equals("waitToNoti")){
                cb.setState(false);
            }
            if(noti_buy.equals("buy")){//如果在今日买药界面，则相反
                cb.setState(!cb.getState());
            }
//            if(i>=1) {
//                tick_boxs.add(cb);
//            }
            //cb.setState();
        }



        //tick_boxs

        tick_boxs.setBackground(Color.white);
        tick_boxs.setBounds(0,0,25,1000);
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

                //new User_Detail_Imformation();
                int clickTimes = e.getClickCount();
                if (clickTimes == 2) {
                    int selectedRow = table.getSelectedRow(); //获得选中行索引
                    System.out.println("表格所选身份证号为"+getTableVales[selectedRow][3]);
                    if(noti_buy.equals("buy")){//如果是第二个界面就是相反的
                        User_Detail_Imformation.User_Detail_Imformation("waitToBuy",getTableVales[selectedRow][3]);
                    }
                    if(noti_buy.equals("noti")){//如果是第二个界面就是相反的
                        User_Detail_Imformation.User_Detail_Imformation("waitToNoti",getTableVales[selectedRow][3]);
                    }

                }
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
        scrollPane.setBounds(25,0,1150,700);

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
//        String aaaa[][]=database.searchByID("23323");
//        System.out.println("aaaa"+aaaa[0][0]);//结果为null
        //whole_frame.repaint();
        return jp2;
    }

    private static Checkbox createCheckbox(String label,String noti_buy) {
        Checkbox cb = new Checkbox(label);
        //cb.addItemListener(User_Detail_Imformation.jb2);
        //给Checkbox对象注册事件监听，也可以去监听其它事件，比如鼠标事件什么的
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String changeState=null;

                Checkbox cb = (Checkbox)e.getSource();
                int checkBoxSelected=parseInt(cb.getLabel());
                boolean stateAfterClick=cb.getState();
                int column_table_ticked=6;
                if(noti_buy.equals("buy")){//如果是第二个界面就是相反的
                    stateAfterClick=!stateAfterClick;
                    column_table_ticked=7;
                }
                if(!stateAfterClick){//如果本来没有打勾，打勾是为了变成
                    //点了以后会先变成false，原来是true，原来是打勾，原来是buy
                    changeState="waitToNoti";
                }else if(stateAfterClick){//本来打了勾，取消打勾
                    //相反点
                    changeState="waitToBuy";
                }
                String waitToBuy_userId=tableModel.getValueAt(checkBoxSelected, column_table_ticked).toString();
                //int canceled=
                User_Detail_Imformation.User_Detail_Imformation(changeState,waitToBuy_userId);
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
        int count = tick_boxs.getComponentCount();
        for (int i = 0; i < count; i++) {
            Component comp = tick_boxs.getComponent(i);
            if(comp instanceof Checkbox){

                String[][] getTableVales=getTodayInfo();
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
//        System.out.println(Infos.length);
        System.out.println(IDs.length);
//        System.out.println(database.searchByID(IDs[0]).length);
        Infos=new String[IDs.length][18];
        for(int i = 0;i<IDs.length;i++){
            //System.out.println("循环了几次");
            //System.out.println("search"+database.searchByID(IDs[i])[0][1]);
            Infos[i]=database.searchByID(IDs[i])[0];
            //String p[]=database.searchByID(IDs[i])[0];

        }
        for (int i = 0; i < Infos.length; i++) {
            System.out.println("身份证为 "+IDs[i]+" 的信息为：");
            for (int j = 0; j < 18; j++) {
                //String id = IDs[j];
                System.out.print(Infos[i][j]+" ");

            }
            System.out.println();


        }
        System.out.println("面板"+"运行到这里");

        //Infos[]=database.searchByID(IDs);

        return Infos;
    }



    public static String[] getTodayID(){
        String[] IDs=null;
        int y,m,d;
        Calendar cal=Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH)+1;
        d=cal.get(Calendar.DATE);
        System.out.println("面板"+y+" "+m+" "+d);

        IDs=database.searchByDate(y+"",m+"",d+"");
        for(int i=0;i<IDs.length;i++){
            System.out.println("面板"+"returned "+IDs[i]);

        }
        return IDs;
    }

}
