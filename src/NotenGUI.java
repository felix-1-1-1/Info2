import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotenGUI extends JFrame implements ActionListener{
    private JButton Zurueck;
    private JPanel JPanel1;
    private JTextField NotenEingabe;
    private JComboBox FachWahl;
    private JButton Hinzufügen;
    private JComboBox bookList;

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

        String[] comboBoxListe = {"1", "2"};
        FachWahl = new JComboBox(comboBoxListe);
        FachWahl.addActionListener(this);
        FachWahl.setSelectedIndex(0);

        String[] bookTitles = new String[] {"Effective Java", "Head First Java",
                "Thinking in Java", "Java for Dummies"};

        JComboBox<String> bookList = new JComboBox<>(bookTitles);

// add to the parent container (e.g. a JFrame):
        add(bookList);

// get the selected item:
        String selectedBook = (String) bookList.getSelectedItem();
        System.out.println("You seleted the book: " + selectedBook);



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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
