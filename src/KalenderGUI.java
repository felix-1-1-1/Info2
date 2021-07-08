import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalenderGUI extends JFrame implements ActionListener {
    private JButton Zurueck;
    private JPanel JPanel1;
    private JButton kalenderZeigenButton;
    private JTextField datumFeld;
    private JButton hinzufügenButton;
    private JTextField terminFeld;
    private JButton aktualisierenButton;
    calenderTable calenderTable;
    sqlKalender sqlKalender;

    public KalenderGUI() {
        setTitle("Kalender");
        setSize(600,150);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        kalenderZeigenButton.addActionListener(this);
        hinzufügenButton.addActionListener(this);
        aktualisierenButton.addActionListener(this);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        sqlKalender = new sqlKalender();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Zurueck) {
            GUI Gui = new GUI();
            this.setVisible(false);
        }
        if (e.getSource() == kalenderZeigenButton) {

             calenderTable = new calenderTable();
        }
        if(e.getSource()==hinzufügenButton)
        {addSchedule();}
        if(e.getSource() == aktualisierenButton)
        {
            calenderTable.clear();
            calenderTable.amendData();}
    }

    void addComponents() {
        add(JPanel1);
        //add(button2);
    }


    //Input nutzen um Datenbank zu verändern
    void addSchedule()
    {
        sqlKalender.addDate(datumFeld.getText(), terminFeld.getText());
    }
}
