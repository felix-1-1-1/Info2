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

    sql sql;

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
        Hinzufügen.addActionListener(this);
        sql=new sql();





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
        if(e.getSource() == Hinzufügen){
            addInput();
        }

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
