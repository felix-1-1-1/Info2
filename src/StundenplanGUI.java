import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StundenplanGUI extends JFrame implements ActionListener {
    sqlStundenplan sqlS = new sqlStundenplan();
    private JButton Zurueck;
    private JPanel JPanel1;
    private JButton showStundenplan;
    private JTextField FachEingabe;
    private JComboBox TagWahl;
    private JButton Hinzufügen;
    private JComboBox StundenWahl;
    private JLabel FachEingeben;
    private JLabel StundeAuswählen;
    private JButton aktualisierenButton;
    private JFrame frame;

    public StundenplanGUI() {
        setTitle("Stundenplan");
        setSize(800, 150);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        showStundenplan.addActionListener(this);
        FachEingabe.addActionListener(this);
        TagWahl.addActionListener(this);
        Hinzufügen.addActionListener(this);
        StundenWahl.addActionListener(this);
        aktualisierenButton.addActionListener(this);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Zurueck) {
            GUI Gui = new GUI();
            this.setVisible(false);
        }
        if (e.getSource() == showStundenplan) {
            showTable();

        }
        if (e.getSource() == Hinzufügen) {
            addInput();
        }
        if(e.getSource()==aktualisierenButton)
        {
            frame.dispose();
            showTable();
        }

    }

    void addInput() {
        sqlS.alterTable(FachEingabe.getText(), (String) TagWahl.getSelectedItem(), Integer.parseInt((String) Objects.requireNonNull(StundenWahl.getSelectedItem())));
    }

    void addComponents() {
        add(JPanel1);
        //add(button2);
    }

    void showTable() {
         frame = new JFrame("Stundenplan");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Tabelle mit allen Studen und Tagen erstellen 11, Mo-Frgf
    public JTable createTable() {
        String[] columnNames = {"Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};
        Object[][] data = {{"1", sqlS.getSubject(1, "Montag"), sqlS.getSubject(1, "Dienstag"), sqlS.getSubject(1, "Mittwoch"), sqlS.getSubject(1, "Donnerstag"), sqlS.getSubject(1, "Freitag")},
                {"2", sqlS.getSubject(2, "Montag"), sqlS.getSubject(2, "Dienstag"), sqlS.getSubject(2, "Mittwoch"), sqlS.getSubject(2, "Donnerstag"), sqlS.getSubject(2, "Freitag")},
                {"3", sqlS.getSubject(3, "Montag"), sqlS.getSubject(3, "Dienstag"), sqlS.getSubject(3, "Mittwoch"), sqlS.getSubject(3, "Donnerstag"), sqlS.getSubject(3, "Freitag")},
                {"4", sqlS.getSubject(4, "Montag"), sqlS.getSubject(4, "Dienstag"), sqlS.getSubject(4, "Mittwoch"), sqlS.getSubject(4, "Donnerstag"), sqlS.getSubject(4, "Freitag")},
                {"5", sqlS.getSubject(5, "Montag"), sqlS.getSubject(5, "Dienstag"), sqlS.getSubject(5, "Mittwoch"), sqlS.getSubject(5, "Donnerstag"), sqlS.getSubject(5, "Freitag")},
                {"6", sqlS.getSubject(6, "Montag"), sqlS.getSubject(6, "Dienstag"), sqlS.getSubject(6, "Mittwoch"), sqlS.getSubject(6, "Donnerstag"), sqlS.getSubject(6, "Freitag")},
                {"7", sqlS.getSubject(7, "Montag"), sqlS.getSubject(7, "Dienstag"), sqlS.getSubject(7, "Mittwoch"), sqlS.getSubject(7, "Donnerstag"), sqlS.getSubject(7, "Freitag")},
                {"8", sqlS.getSubject(8, "Montag"), sqlS.getSubject(8, "Dienstag"), sqlS.getSubject(8, "Mittwoch"), sqlS.getSubject(8, "Donnerstag"), sqlS.getSubject(8, "Freitag")},
                {"9", sqlS.getSubject(9, "Montag"), sqlS.getSubject(9, "Dienstag"), sqlS.getSubject(9, "Mittwoch"), sqlS.getSubject(9, "Donnerstag"), sqlS.getSubject(9, "Freitag")},
                {"10", sqlS.getSubject(10, "Montag"), sqlS.getSubject(10, "Dienstag"), sqlS.getSubject(10, "Mittwoch"), sqlS.getSubject(10, "Donnerstag"), sqlS.getSubject(10, "Freitag")},
                {"11", sqlS.getSubject(11, "Montag"), sqlS.getSubject(11, "Dienstag"), sqlS.getSubject(11, "Mittwoch"), sqlS.getSubject(11, "Donnerstag"), sqlS.getSubject(11, "Freitag")}};
        JTable table = new JTable(data, columnNames);
        table.setDefaultEditor(Object.class, null);

        table.setFillsViewportHeight(true);

        return table;
    }
}
