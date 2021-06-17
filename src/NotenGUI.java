import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotenGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;
    private JTextField NotenEingabe;
    private JComboBox FachWahl;
    private JButton Hinzufügen;
    private JComboBox Typ;
    private JButton ergebnisseZeigen;
    private JPanel TablePanel;

    sql sql;

    public static void main(String[] args)
    {
        NotenGUI notenGUI = new NotenGUI();

    }

    public NotenGUI() {
        setTitle("test");
        setSize(550, 200);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        Hinzufügen.addActionListener(this);
        ergebnisseZeigen.addActionListener(this);
        sql=new sql();






    }

    void showTable()
    {
        JFrame frame = new JFrame("Noten");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(500,350);

        frame.setVisible(true);
    }

    public  JTable createTable()
    {
        String[] columnNames = {"Fach", "Notenschnitt Schriftlich","Notenschnitt Mündlich", "Kombiniert"};
        Object[][] data = {{"Deutsch",sql.getGradesSchriftlich("Deutsch"),sql.getGradesMündlich("Deutsch"), sql.getGradesCombined("Deutsch")},
                {"Mathe",sql.getGradesSchriftlich("Mathe"),sql.getGradesMündlich("Mathe"), sql.getGradesCombined("Mathe")},
                {"Englisch",sql.getGradesSchriftlich("Englisch"),sql.getGradesMündlich("Englisch"), sql.getGradesCombined("Englisch")},
                {"P-Seminar",sql.getGradesSchriftlich("P-Seminar"),sql.getGradesMündlich("P-Seminar"), sql.getGradesCombined("P-Seminar")},
                {"W-Seminar",sql.getGradesSchriftlich("W-Seminar"),sql.getGradesMündlich("W-Seminar"), sql.getGradesCombined("W-Seminar")},
                {"Informatik",sql.getGradesSchriftlich("Informatik"),sql.getGradesMündlich("Informatik"), sql.getGradesCombined("Informatik")},
                {"Physik",sql.getGradesSchriftlich("Physik"),sql.getGradesMündlich("Physik"), sql.getGradesCombined("Physik")},
                {"Wirtschaft",sql.getGradesSchriftlich("Wirtschaft"),sql.getGradesMündlich("Wirtschaft"), sql.getGradesCombined("Wirtschaft")},
                {"Geographie",sql.getGradesSchriftlich("Geographie"),sql.getGradesMündlich("Geographie"), sql.getGradesCombined("Geographie")},
                {"Geschichte",sql.getGradesSchriftlich("Geschichte"),sql.getGradesMündlich("Geschichte"), sql.getGradesCombined("Geschichte")},
                {"Sozialkunde",sql.getGradesSchriftlich("Sozialkunde"),sql.getGradesMündlich("Sozialkunde"), sql.getGradesCombined("Sozialkunde")},
                {"Französisch",sql.getGradesSchriftlich("Französisch"),sql.getGradesMündlich("Französisch"), sql.getGradesCombined("Französisch")},
                {"Latein",sql.getGradesSchriftlich("Latein"),sql.getGradesMündlich("Latein"), sql.getGradesCombined("Latein")},
                {"Russisch",sql.getGradesSchriftlich("Russisch"),sql.getGradesMündlich("Russisch"), sql.getGradesCombined("Russisch")}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Zurueck){
            GUI Gui = new GUI();
            Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setVisible(false);
        }
        if(e.getSource() == Hinzufügen){
            addInput();
        }
        if(e.getSource() == ergebnisseZeigen)
        {showTable();}

    }

    void addInput()
    {
        sql.addGrade((String)FachWahl.getSelectedItem(), Integer.parseInt(NotenEingabe.getText()), (String)Typ.getSelectedItem());
    }

    void addComponents()
    {
        add(JPanel1);
        //add(button2);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
