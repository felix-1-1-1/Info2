import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StundenplanGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;
    private JButton showStundenplan;

    public StundenplanGUI() {
        setTitle("test");
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);
        showStundenplan.addActionListener(this);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Zurueck){
            GUI Gui = new GUI();
            this.setVisible(false);
        }
        if(e.getSource() == showStundenplan){
            showTable();
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
        Object[][] data = {{"1","2","3","4","5","6"}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }
}
