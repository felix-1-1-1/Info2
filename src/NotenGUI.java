import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotenGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;
    private JTextField NotenEingabe;
    private JComboBox FachWahl;
    private JButton Hinzufügen;

    sql sql = new sql();

    public NotenGUI() {
        setTitle("test");
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        FachWahl.addActionListener(this);
        FachWahl.setSelectedIndex(16);
        String comboBoxListe[] = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};
        JComboBox FachWahl = new JComboBox(comboBoxListe);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Zurueck){
            GUI Gui = new GUI();
            this.setVisible(false);
        }

    }

    /*void addInput()
    {
        sql.addGrade(this.FachWahl.GetItemText(this.FachWahl.SelectedItem), NotenEingabe.getText());
    }
*/
    void addComponents()
    {
        add(JPanel1);
        //add(button2);
    }
}
