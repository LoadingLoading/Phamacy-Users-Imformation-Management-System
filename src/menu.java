import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu {
    public static JMenuBar menu(){
        JMenuBar jmb = new JMenuBar();
        //不能设定位置，会自动放在最上部

        //添加菜单
        JMenu menu1 = new JMenu("编辑");
        JMenu menu2 = new JMenu("管理员功能");
        JMenu menu3 = new JMenu("帮助");

        //JMenuItem item1 = new JMenuItem("新增");
        //System.out.println("准备新增了");
        Action exitAction = new AbstractAction("新增"){
            public void actionPerformed(ActionEvent e){
                //System.exit(0);
                User_Detail_Imformation.User_Detail_Imformation("waitToNoti",null);
            }
        };

        menu1.add(exitAction);
//        item1.addMouseListener(new MouseAdapter(){    //鼠标事件
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("可以新增了");
//                User_Detail_Imformation.User_Detail_Imformation(1,null);
//            }
//        });
        JMenuItem item2 = new JMenuItem("备份");

        JMenuItem item3 = new JMenuItem("删除所有数据");
        JMenuItem item4 = new JMenuItem("添加员工");
        JMenuItem item5 = new JMenuItem("管理员工");

        JMenuItem item7 = new JMenuItem("关于");
        //添加菜单项至菜单上
        //menu1.add(item1);
        menu1.add(item2);

        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);
        menu3.add(item7);
        //将菜单加入至菜单条
        jmb.add(menu1);
        jmb.add(menu2);
        jmb.add(menu3);
        return jmb;
    }
}
