
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author zys59三仙半（QQ：597882752）<br>
 * 创建时间：2015年8月25日 上午8:52:12
 */
public class TestCheckbox extends JFrame {
    private static final long serialVersionUID = 6260099466070549892L;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestCheckbox frame = new TestCheckbox();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TestCheckbox() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //动态生成Checkbox
        for (int i = 0; i < 100; i++) {
            Checkbox cb = createCheckbox("选项"+(i+1));
            add(cb);
        }
    }
    //这个方法用于动态的生成Checkbox
    private Checkbox createCheckbox(String label) {
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
