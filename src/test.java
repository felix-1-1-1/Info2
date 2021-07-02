import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test {
    sqlKalender sqlKalender;
    JFrame frame;
    Container content;
    JButton buttonAddRow;
    JButton buttonRemRow;
    JButton buttonAddCol;

    public test()
    {
        String[] titles = new String[]{"Datum", "Termin", "Erledigt"};

        final DefaultTableModel model = new DefaultTableModel(titles, 0);

        JTable table = new JTable(model);

        final JButton buttonAddRow = new JButton("add row");
        final JButton buttonRemRow = new JButton("remove row");
        final JButton buttonAddCol = new JButton("add column");

        buttonRemRow.setEnabled(false);
    sqlKalender = new sqlKalender();
         frame = new JFrame( "Demo" );

         content = frame.getContentPane();

        content.add( new JScrollPane( table ), BorderLayout.CENTER );
        content.add( buttonAddRow, BorderLayout.NORTH );
        content.add( buttonRemRow, BorderLayout.SOUTH );
        content.add( buttonAddCol, BorderLayout.WEST );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );}

    public static void main( String[] args ) {
        test test = new test();
        test.prepare();
    }

    void prepare() {

        String[] titles = new String[]{"Datum", "Termin", "Erledigt"};

        final DefaultTableModel model = new DefaultTableModel(titles, 0);

        JTable table = new JTable(model);

        final JButton buttonAddRow = new JButton("add row");
        final JButton buttonRemRow = new JButton("remove row");
        final JButton buttonAddCol = new JButton("add column");

        buttonRemRow.setEnabled(false);
    }
    void amendData() {
        // Den Buttons ein paar Reaktionen geben
        buttonAddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Die Anzahl Columns (Breite) der Tabelle
                int size = model.getColumnCount();

                // einen neuen Vector mit Daten herstellen
                Vector newDatas = createDataVector(sqlKalender.allDates());

                // eine neue Row hinzufügen
                model.addRow(newDatas);


                // das Entfernen erlauben
                buttonRemRow.setEnabled(true);
            }
        });


        buttonRemRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int size = model.getRowCount();
                int index = (int) (Math.random() * size);
                model.removeRow(index);

                buttonRemRow.setEnabled(size > 1);
            }
        });
    }







    String[] copyData()
    {
        return sqlKalender.allDates();
    }


    public  static Vector createDataVector(String[] s , int k){
        Vector vector = new Vector( 3 );
        String[] dummy = s;
        for(int i = 0; i < 27; i++ )
            vector.add(dummy[i]);

        return vector;
    }
}


