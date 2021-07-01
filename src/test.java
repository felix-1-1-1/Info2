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

public class test{
    sqlKalender sqlKalender;
    public test()
    {
    sqlKalender = new sqlKalender();}

    public static void main( String[] args ) {
        test test = new test();
        test.prepare();
    }

    void prepare()
    {

        // Die Namen der Columns
        String[] titles = new String[]{ "Datum", "Termin", "Erledigt" };

        // Das Model das wir verwenden werden. Hier setzten wir gleich die
        // Titel, aber es ist später immer noch möglich weitere Columns oder
        // Rows hinzuzufügen.
        final DefaultTableModel model = new DefaultTableModel( titles, 0 );

        // Das JTable initialisieren
        JTable table = new JTable( model );

        // Buttons, damit das alles schöner aussieht.
        final JButton buttonAddRow = new JButton( "add row" );
        final JButton buttonRemRow = new JButton( "remove row" );
        final JButton buttonAddCol = new JButton( "add column" );

        buttonRemRow.setEnabled( false );

        // Den Buttons ein paar Reaktionen geben
        buttonAddRow.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Die Anzahl Columns (Breite) der Tabelle
                int size = model.getColumnCount();

                // einen neuen Vector mit Daten herstellen
                Vector newDatas = createDataVector(sqlKalender.allDates());

                // eine neue Row hinzufügen
                model.addRow( newDatas );


                // das Entfernen erlauben
                buttonRemRow.setEnabled( true );
            }
        });


        buttonRemRow.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int size = model.getRowCount();
                int index = (int)(Math.random() * size);
                model.removeRow( index );

                buttonRemRow.setEnabled( size > 1 );
            }
        });

        JFrame frame = new JFrame( "Demo" );

        Container content = frame.getContentPane();

        content.add( new JScrollPane( table ), BorderLayout.CENTER );
        content.add( buttonAddRow, BorderLayout.NORTH );
        content.add( buttonRemRow, BorderLayout.SOUTH );
        content.add( buttonAddCol, BorderLayout.WEST );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }




    String[] copyData()
    {
        return sqlKalender.allDates();
    }

    public  static Vector createDataVector(String[] s ){
        Vector vector = new Vector( 3 );
        String[] dummy = s;
        for( int i = 0; i < 3; i++ )
            vector.add(dummy[i]);

        return vector;
    }}


