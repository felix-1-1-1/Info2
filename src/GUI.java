import javax.swing.*;

public class GUI extends JFrame{
    private JPanel panel1;
    private JButton Kalender;
    private JButton Noten;
    private JButton Stundenplan;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JTree tree1;
    private JComboBox comboBox1;

    public static void main(String[] args){
        new GUI();
    }
    public GUI()
    {
        setTitle("test");
        setSize(500,500);
        addComponents();
    }

    void addComponents()
    {
        add(panel1);
        //add(button2);
    }
}
