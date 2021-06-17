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
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        Hinzufügen.addActionListener(this);
        ergebnisseZeigen.addActionListener(this);
        sql=new sql();






    }

    void showTable()
    {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public  JTable createTable()
    {
        String[] columnNames = {"Fach", "Notenschnitt Schriftlich","Notenschnitt Mündlich", "Kombiniert"};
        Object[][] data = {{"Deutsch",sql.getGradesSchriftlich("Deutsch"),sql.getGradesMündlich("Deutsch"), sql}};
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
