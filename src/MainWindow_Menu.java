import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class MainWindow_Menu {
    public static JMenuBar menu(){
        JMenuBar jmb = new JMenuBar();
        //不能设定位置，会自动放在最上部

        //添加菜单
        JMenu menu3 = new JMenu("编辑");
        JMenu menu2 = new JMenu("管理员功能");
        JMenu menu1 = new JMenu("帮助");

        //SecondWindow.User_Detail_Imformation("search",null);

        //JMenuItem item1 = new JMenuItem("新增");
        //System.out.println("准备新增了");
        Action menu1choice1Action = new AbstractAction("新增"){
            public void actionPerformed(ActionEvent e){
                //System.exit(0);
                SecondWindow.User_Detail_Imformation("waitToNoti",null);
            }
        };

        menu3.add(menu1choice1Action);

        JMenuItem item8 = new JMenuItem("搜索");
        Action menu1choice3exitAction = new AbstractAction("搜索"){
            public void actionPerformed(ActionEvent e){
                SecondWindow.User_Detail_Imformation("search",null);
            }
        };
        menu3.add(menu1choice3exitAction);
//        item1.addMouseListener(new MouseAdapter(){    //鼠标事件
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("可以新增了");
//                SecondWindow.SecondWindow(1,null);
//            }
//        });
        //JMenuItem item2 = new JMenuItem("备份");
        Action menu1choice2exitAction = new AbstractAction("备份"){
            public void actionPerformed(ActionEvent e){
                Database.lock_unlock("FLUSH TABLES WITH READ LOCK;");


                Database.lock_unlock("unlock tables;");
                //System.exit(0);
                //SecondWindow.SecondWindow("waitToNoti",null);

            }
        };
        menu3.add(menu1choice2exitAction);

        JMenuItem item21 = new JMenuItem("恢复");

        JMenuItem item3 = new JMenuItem("删除所有数据");
        JMenuItem item4 = new JMenuItem("添加员工");
        JMenuItem item5 = new JMenuItem("管理员工");

        JMenuItem item7 = new JMenuItem("关于");

        //添加菜单项至菜单上
        //menu1.add(item1);
        //menu1.add(item2);
        menu3.add(item21);


        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);
        menu1.add(item7);
        //将菜单加入至菜单条
        jmb.add(menu1);
        jmb.add(menu2);
        jmb.add(menu3);

        //jmb.add(menu4);
        return jmb;
    }

    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
