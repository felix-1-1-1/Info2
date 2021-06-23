import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StundenplanGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;
    sqlStundenplan sqlS = new sqlStundenplan();

    public StundenplanGUI() {
        setTitle("test");
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        showTable();


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

    void showTable()
    {
        JFrame frame = new JFrame("Noten");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setSize(500,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public  JTable createTable()
    {
        String[] columnNames = {"Stunde", "Montag", "Dienstag","Mittwoch", "Donnerstag", "Freitag"};
        Object[][] data = {{"1",sqlS.getSubject(1,"Montag"),sqlS.getSubject(1,"Dienstag"),sqlS.getSubject(1,"Mittwoch"),sqlS.getSubject(1,"Donnerstag"),sqlS.getSubject(1,"Freitag")}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }
}
