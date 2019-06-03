import javax.swing.*;

public class user_imfo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("user_imfo");
        frame.setContentPane(new user_imfo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel1;
    private JLabel name;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JCheckBox checkBox1;
}
