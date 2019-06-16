
//QQ登录界面制作
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

public class Demo16 extends JFrame {
    //public static String[] IDs=new String[100];

    // 北部区域
    JLabel jl1;

    // 南部区域
    JButton jb1, jb2, jb3;
    JPanel jp1;

    // 中部区域
    JTabbedPane jtp;// 选项卡窗格
    JPanel jp2, jp3, jp4;

    JLabel jl2, jl3, jl4, jl5;
    // 号码输入文本框
    JTextField jtf;
    // 密码
    JPasswordField jpf;
    // 清除号码
    JButton jb4;
    // 隐身登录、记住密码
    JCheckBox jcb1, jcb2;





    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Demo16();

    }

    public Demo16() {

        // 创建组件
        jl2 = new JLabel("QQ号码", JLabel.CENTER);
        jl3 = new JLabel("QQ密码", JLabel.CENTER);
        jl4 = new JLabel("忘记密码", JLabel.CENTER);
        jl4.setFont(new Font("宋体", Font.PLAIN, 16));// 设置字体样式
        jl4.setForeground(Color.BLUE);// 设置字体颜色
        jl5 = new JLabel("<html><a href='www.qq.com'>申请密码保护</a></html>");
        // 鼠标触发变化
        jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jtf = new JTextField();
        jpf = new JPasswordField();
        jb4 = new JButton(new ImageIcon("images\\login.png"));

        jcb1 = new JCheckBox("隐身登录");
        jcb2 = new JCheckBox("记住密码");












        // 北部区域
        jl1 = new JLabel(new ImageIcon("images\\headpicture.jpg"));

        // 南部区域
        jp1 = new JPanel();
        jb1 = new JButton(new ImageIcon("images\\login.png"));
        jb2 = new JButton(new ImageIcon("images\\delete.png"));
        jb3 = new JButton(new ImageIcon("images\\register.png"));

        // 中部区域
        jtp = new JTabbedPane();
        jp2 = new JPanel();
        jp3 = new JPanel();
        //jp3.setBackground(Color.RED);// 给面板设置背景
        jp4 = new JPanel();
        jp4.setBackground(new Color(0, 0, 255));

        // 将面板添加到选项卡窗格上
        jtp.add("今日提醒", jp2);// 参数：选项卡名称，面板
        jtp.add("今日买药", jp3);
        jtp.add("查询", jp4);

        // 设置布局
        //jp2.setLayout(new GridLayout(3, 3));

        // 添加组件
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
//
//        jp2.add(jl2);
//        jp2.add(jtf);
//        jp2.add(jb4);
//        jp2.add(jl3);
//        jp2.add(jpf);
//        jp2.add(jl4);
//        jp2.add(jcb1);
//        jp2.add(jcb2);
//        jp2.add(jl5);



        jp2= Label_1_2_noti_buy.noti(jp2,"noti");
        //jp3= Label_1_2_noti_buy.noti(jp3);












//        String[] columnNames = {"姓名","性别","号主+号码","药名","预计用药时间","预计用药次数","上次备注情况"};   //列名
//        String [][]tableVales={{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"},{"XXX","男","XXX 188 8888 8888","凯美纳","2019年6月20号","第3次","无"}}; //数据
//        tableModel = new DefaultTableModel(tableVales,columnNames);
//        table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);   //支持滚动
//        //getContentPane().add(scrollPane,BorderLayout.CENTER);
//        //jdk1.6
//        //排序:
//        //table.setRowSorter(new TableRowSorter(tableModel));
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
//        table.addMouseListener(new MouseAdapter(){    //鼠标事件
//            public void mouseClicked(MouseEvent e){
//                int selectedRow = table.getSelectedRow(); //获得选中行索引
//                Object oa = tableModel.getValueAt(selectedRow, 0);
//                Object ob = tableModel.getValueAt(selectedRow, 1);
//                aTextField.setText(oa.toString());  //给文本框赋值
//                bTextField.setText(ob.toString());
//            }
//        });
//        scrollPane.setViewportView(table);
//
//        //final JPanel jp2 = new JPanel();
//        //getContentPane().add(jp2,BorderLayout.SOUTH);
//        jp2.setLayout(new GridLayout(1,1));
//        jp2.add(scrollPane);
//





        //菜单
        JMenuBar jmb=menu.menu();
        this.setJMenuBar(jmb);


        /*
        jp2.add(new JLabel("A: "));
        aTextField = new JTextField("A4",10);
        jp2.add(aTextField);
        jp2.add(new JLabel("B: "));
        bTextField = new JTextField("B4",10);
        jp2.add(bTextField);
        final JButton addButton = new JButton("添加");   //添加按钮
        addButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                String []rowValues = {aTextField.getText(),bTextField.getText()};
                tableModel.addRow(rowValues);  //添加一行
                int rowCount = table.getRowCount() +1;   //行数加上1
                aTextField.setText("A"+rowCount);
                bTextField.setText("B"+rowCount);
            }
        });
        jp2.add(addButton);

        final JButton updateButton = new JButton("修改");   //修改按钮
        updateButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!= -1)   //是否存在选中行
                {
                    //修改指定的值：
                    tableModel.setValueAt(aTextField.getText(), selectedRow, 0);
                    tableModel.setValueAt(bTextField.getText(), selectedRow, 1);
                    //table.setValueAt(arg0, arg1, arg2)
                }
            }
        });
        jp2.add(updateButton);

        final JButton delButton = new JButton("删除");
        delButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1)  //存在选中行
                {
                    tableModel.removeRow(selectedRow);  //删除行
                }
            }
        });
        jp2.add(delButton);

*/














        this.add(jp1, BorderLayout.SOUTH);
        this.add(jl1, BorderLayout.NORTH);
        this.add(jtp, BorderLayout.CENTER);

        // 展示组件
        ImageIcon icon = new ImageIcon("images\\qq.png");
        this.setIconImage(icon.getImage());// 给窗体设置图标方法
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.Update(this.getGraphics());
//        for(int i=0;i<=1000;i++) {
//            this.repaint();
//        }
        //getToday();

    }
    public static void repaintFrame(){
        //Frame.repaint();
    }


}