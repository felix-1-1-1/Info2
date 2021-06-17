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

    public static void main(String[] args)
    {
        NotenGUI notenGUI = new NotenGUI();
        notenGUI.comboBox();

    }

    public NotenGUI() {
        setTitle("test");
        setSize(500, 500);
        addComponents();
        setVisible(true);
        Zurueck.addActionListener(this);





    }

    void comboBox()
    {

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Zurueck){
            GUI Gui = new GUI();
            Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setVisible(false);
        }

    }

    void addInput()
    {
        sql.addGrade(this.FachWahl.GetItemText(this.FachWahl.SelectedItem), NotenEingabe.getText());
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
