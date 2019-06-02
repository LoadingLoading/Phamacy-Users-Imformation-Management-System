import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Label_1_2_noti_buy {
    private static DefaultTableModel tableModel;   //表格模型对象
    private static JTable table;
    private static JTextField aTextField;
    private static JTextField bTextField;

    public static JPanel noti(JPanel jp2){
        String[] columnNames = {"姓名","性别","号主+号码","药名","预计用药时间","预计用药次数","上次备注情况"};   //列名
        String [][]tableVales={{"XXX1","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"}}; //数据
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);   //支持滚动
        //getContentPane().add(scrollPane,BorderLayout.CENTER);
        //jdk1.6
        //排序:
        //table.setRowSorter(new TableRowSorter(tableModel));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行索引
                Object oa = tableModel.getValueAt(selectedRow, 0);
                Object ob = tableModel.getValueAt(selectedRow, 1);
                aTextField.setText(oa.toString());  //给文本框赋值
                bTextField.setText(ob.toString());
            }
        });
        scrollPane.setViewportView(table);

        //final JPanel jp2 = new JPanel();
        //getContentPane().add(jp2,BorderLayout.SOUTH);
        jp2.setLayout(new GridLayout(1,1));
        jp2.add(scrollPane);
        return jp2;
    }
}
