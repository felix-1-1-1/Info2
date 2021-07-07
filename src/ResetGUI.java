import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ResetGUI extends JFrame implements ActionListener
{
    private JButton bestätigenButton;
    private JComboBox comboBox1;
    private JPanel JPanel1;
    private JButton zurückButton;
    private JButton dummyButton;
    private JComboBox dummyBox2;
    sqlNoten sqlnoten = new sqlNoten();
    sqlKalender sqlkalender = new sqlKalender();
    sqlStundenplan sqlstundenplan = new sqlStundenplan();


    public ResetGUI()
    {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        bestätigenButton.addActionListener(this);
        zurückButton.addActionListener(this);
        dummyButton.addActionListener(this);
        setTitle("Datenbank leeren");
        setSize(500, 200);
        addComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bestätigenButton)
        {
                   resetDatabase((String)comboBox1.getSelectedItem());
        }
        if (e.getSource() == zurückButton) {
            GUI Gui = new GUI();
            Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setVisible(false);
        }
        if (e.getSource() == dummyButton) {
        dummy((String)dummyBox2.getSelectedItem());
        }

        }
    public void addComponents()
    {
        add(JPanel1);
    }
    public void dummy(String x)
    {
        switch (x)
        {
            case "für Alle":
                sqlkalender.dummy(25);
                sqlnoten.dummy(80);
                sqlstundenplan.dummy();
                break;
            case"für Noten":
                sqlnoten.dummy(80);
                break;
            case"für Stundenplan":
                sqlstundenplan.dummy();
                break;
            case"für Kalender":
                sqlkalender.dummy(25);
                break;
        }
    }
    public void resetDatabase(String data)
    {
        switch (data)
        {
            case "Alles zurücksetzen":
                sqlnoten.resetData();
                sqlstundenplan.resetData();
                sqlkalender.resetData();
                break;
            case"Noten zurücksetzen":
                sqlnoten.resetData();
                break;
            case"Stundenplan zurücksetzen":
                sqlstundenplan.resetData();
                break;
            case"Kalender zurücksetzen":
                sqlkalender.resetData();
                break;
        }
    }




}
