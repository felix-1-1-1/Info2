import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalenderGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;

    public KalenderGUI() {
        setTitle("Kalender");
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Zurueck){
            GUI Gui = new GUI();
            this.setVisible(false);
        }

    }
    void addComponents()
    {
        add(JPanel1);
        //add(button2);
    }
    }
