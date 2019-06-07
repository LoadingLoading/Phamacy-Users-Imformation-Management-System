import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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


        String[] columnNames = {"姓名","性别","号主+号码","药名","预计用药时间","预计用药次数","上次备注情况"};
        String [][]tableVales={{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},}; //数据
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
        scrollPane.setBounds(25,0,1200,700);

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
}
