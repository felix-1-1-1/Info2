import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotenGUI extends JFrame implements ActionListener {
    sqlNoten sqlNoten;
    private JButton Zurueck;
    private JPanel JPanel1;
    private JTextField NotenEingabe;
    private JComboBox FachWahl;
    private JButton Hinzufuegen;
    private JComboBox Typ;
    private JButton ergebnisseZeigen;
    private JPanel TablePanel;


    public NotenGUI() {
        setTitle("test");
        setSize(550, 200);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        Hinzufuegen.addActionListener(this);
        ergebnisseZeigen.addActionListener(this);
        sqlNoten = new sqlNoten();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    void showTable() {
        JFrame frame = new JFrame("Noten");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTable createTable() {
        String[] columnNames = {"Fach", "Notenschnitt Schriftlich", "Notenschnitt Mündlich", "Kombiniert"};
        Object[][] data = {{"Deutsch", sqlNoten.getGradesSchriftlich("Deutsch"), sqlNoten.getGradesMündlich("Deutsch"), sqlNoten.getGradesCombined("Deutsch")},
                {"Mathe", sqlNoten.getGradesSchriftlich("Mathe"), sqlNoten.getGradesMündlich("Mathe"), sqlNoten.getGradesCombined("Mathe")},
                {"Englisch", sqlNoten.getGradesSchriftlich("Englisch"), sqlNoten.getGradesMündlich("Englisch"), sqlNoten.getGradesCombined("Englisch")},
                {"P-Seminar", sqlNoten.getGradesSchriftlich("P-Seminar"), sqlNoten.getGradesMündlich("P-Seminar"), sqlNoten.getGradesCombined("P-Seminar")},
                {"W-Seminar", sqlNoten.getGradesSchriftlich("W-Seminar"), sqlNoten.getGradesMündlich("W-Seminar"), sqlNoten.getGradesCombined("W-Seminar")},
                {"Informatik", sqlNoten.getGradesSchriftlich("Informatik"), sqlNoten.getGradesMündlich("Informatik"), sqlNoten.getGradesCombined("Informatik")},
                {"Physik", sqlNoten.getGradesSchriftlich("Physik"), sqlNoten.getGradesMündlich("Physik"), sqlNoten.getGradesCombined("Physik")},
                {"Wirtschaft", sqlNoten.getGradesSchriftlich("Wirtschaft"), sqlNoten.getGradesMündlich("Wirtschaft"), sqlNoten.getGradesCombined("Wirtschaft")},
                {"Geographie", sqlNoten.getGradesSchriftlich("Geographie"), sqlNoten.getGradesMündlich("Geographie"), sqlNoten.getGradesCombined("Geographie")},
                {"Geschichte", sqlNoten.getGradesSchriftlich("Geschichte"), sqlNoten.getGradesMündlich("Geschichte"), sqlNoten.getGradesCombined("Geschichte")},
                {"Sozialkunde", sqlNoten.getGradesSchriftlich("Sozialkunde"), sqlNoten.getGradesMündlich("Sozialkunde"), sqlNoten.getGradesCombined("Sozialkunde")},
                {"Französisch", sqlNoten.getGradesSchriftlich("Französisch"), sqlNoten.getGradesMündlich("Französisch"), sqlNoten.getGradesCombined("Französisch")},
                {"Latein", sqlNoten.getGradesSchriftlich("Latein"), sqlNoten.getGradesMündlich("Latein"), sqlNoten.getGradesCombined("Latein")},
                {"Russisch", sqlNoten.getGradesSchriftlich("Russisch"), sqlNoten.getGradesMündlich("Russisch"), sqlNoten.getGradesCombined("Russisch")}, {"", "", "", ""}, {"Kombiniert:", "", "", sqlNoten.getGradesAll()}};
        JTable table = new JTable(data, columnNames);
        table.setDefaultEditor(Object.class, null);

        table.setFillsViewportHeight(true);

        return table;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Zurueck) {
            GUI Gui = new GUI();
            Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setVisible(false);
        }
        if (e.getSource() == Hinzufuegen) {
            addInput();
        }
        if (e.getSource() == ergebnisseZeigen) {
            showTable();
        }

    }

    void addInput() {
        sqlNoten.addGrade((String) FachWahl.getSelectedItem(), checkValue(), (String) Typ.getSelectedItem());
    }

    int checkValue() {
        if (Integer.parseInt(NotenEingabe.getText()) <= 15 && Integer.parseInt(NotenEingabe.getText()) >= 0) {
            return Integer.parseInt(NotenEingabe.getText());
        }
        return -1;
    }

    void addComponents() {
        add(JPanel1);
        //add(button2);
    }


}
