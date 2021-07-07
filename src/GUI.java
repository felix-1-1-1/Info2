import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton Kalender;
    private JButton Noten;
    private JButton Stundenplan;
    private JButton ResetButton;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JTree tree1;
    private JComboBox comboBox1;


    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Schulplaner");
        setSize(300, 300);
        addComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        Kalender.addActionListener(this);
        Noten.addActionListener(this);
        Stundenplan.addActionListener(this);
        ResetButton.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Kalender) {
            KalenderGUI kalender = new KalenderGUI();
            this.setVisible(false);
        }
        if (e.getSource() == Noten) {
            NotenGUI noten = new NotenGUI();
            noten.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(false);
        }
        if (e.getSource() == Stundenplan) {
            StundenplanGUI stundenplan = new StundenplanGUI();
            this.setVisible(false);
        }
        if(e.getSource() == ResetButton)
        {
            ResetGUI reset = new ResetGUI();
            this.setVisible(false);
        }
    }

    void addComponents() {
        add(panel1);
        //add(button2);
    }

}
