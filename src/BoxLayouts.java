
import java.awt.*;

import javax.swing.*;

public class BoxLayouts extends JFrame {

    private JButton btn1 = new JButton("Button1");
    private JButton btn2 = new JButton("Button2");
    private JButton btn3 = new JButton("Button3 what a fine day");
    private JButton btn4 = new JButton("Button4 what a fine da");
    private JButton btn5 = new JButton("Button5 what a fine d");
    private JButton btn6 = new JButton("Button6 what a fines");

    BoxLayouts() {
        super();
        initComponent();
    }

    private void initComponent() {
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

            JPanel name = new JPanel();

            JLabel label_null = new JLabel("");
            JLabel label_name = new JLabel("姓名：");
            JTextField textfield_name=new JTextField("",10);


            name.add(label_null);
            name.add(label_name);
            name.add(textfield_name);


        //container.add(name);
        container.add(btn2);
        container.add(btn3);
        container.add(btn4);
        container.add(btn5);
        container.add(btn6);
    }

    public static void main(String[] args) {
        BoxLayouts frame = new BoxLayouts();
        frame.pack();
        frame.setVisible(true);

    }
}