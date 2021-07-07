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
        sqlkalender.dummy(50);
        sqlnoten.dummy(80);
        sqlstundenplan.dummy();
        }

        }
    public void addComponents()
    {
        add(JPanel1);
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
