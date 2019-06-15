import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class Label_1_2_noti_buy {
    private static DefaultTableModel tableModel;   //表格模型对象
    private static JTable table;
    private static JTextField aTextField;
    private static JTextField bTextField;

    public static JPanel noti(JPanel jp2){

        JPanel whole_frame = new JPanel();
        whole_frame.setLayout(null);
        //whole_frame.setBounds(0,0,1200,900);


        JPanel tick_boxs = new JPanel();
        tick_boxs.setLayout(null);

        for (int i = 0; i < 100; i++) {
            Checkbox cb = createCheckbox("选项"+(i+1));
            cb.setBounds(0,18*i,25,18);
            if(i>=1) {
                tick_boxs.add(cb);
            }
        }
        tick_boxs.setBackground(Color.white);
        tick_boxs.setBounds(0,0,25,1000);
        whole_frame.add(tick_boxs);


        String[] columnNames = {"姓名","性别","购药次数","药名","号主+号码","上次买药时间","身份证号"};
        String [][]tableVales={{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXXX"},{"XXX1","男","第1次","凯美纳","XXX 188 8888 8888","2019年6月20号","431226XXXXXXXX4837"},}; //数据
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.getColumnModel().getColumn(1).setWidth(10080);
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
                    User_Detail_Imformation.User_Detail_Imformation(1);
                }
                int selectedRow = table.getSelectedRow(); //获得选中行索引
                Object oa = tableModel.getValueAt(selectedRow, 0);
                Object ob = tableModel.getValueAt(selectedRow, 1);


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

        //jsp.setBounds(0,0,1200,700);
        jp2.add(scrollPane1);
        //jp2.add(scrollPane);
        //JScrollPane scrollPane1 = new JScrollPane(jp2);
        //scrollPane1.setViewportView(jp2);
        getTodayInfo();
        return jp2;
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

    public static String[][] getTodayInfo(){
        String[][] Infos=null;
        String[] IDs=null;
        IDs=getTodayID();
        //System.out.println(IDs[0]);
//        System.out.println(Infos.length);
        System.out.println(IDs.length);
//        System.out.println(database.searchByID(IDs[0]).length);
        Infos=new String[IDs.length][18];
        for(int i = 1;i<IDs.length;i++){
            //System.out.println("search"+database.searchByID(IDs[i])[0][1]);
            Infos[i]=database.searchByID(IDs[i])[0];
            //String p[]=database.searchByID(IDs[i])[0];

        }
        for (int i = 0; i < Infos.length; i++) {
            for (int j = 0; j < 18; j++) {
                //String id = IDs[j];
                System.out.print(Infos[i][j]);

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
