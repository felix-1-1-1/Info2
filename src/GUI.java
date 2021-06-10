import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
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
        setVisible(true);
        Kalender.addActionListener(this);
        Noten.addActionListener(this);
        Stundenplan.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Kalender){
           KalenderGUI kalender = new KalenderGUI();
           this.setVisible(false);
        }
        if(e.getSource() == Noten){
            NotenGUI noten = new NotenGUI();
            this.setVisible(false);        }
        if(e.getSource() == Stundenplan) {
            StundenplanGUI stundenplan = new StundenplanGUI();
            this.setVisible(false);
        }
    }
    void addComponents()
    {
        add(panel1);
        //add(button2);
    }

}
