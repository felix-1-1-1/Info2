import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class calenderTable {
    sqlKalender sqlKalender;
    final JFrame frame;
    Container content;
    JTable table;
    DefaultTableModel model;

    public calenderTable() {
        //Termin Tabelle mit Daten instanzieren und anzeigen
        String[] titles = new String[]{"Datum", "Termin"};

        model = new DefaultTableModel(titles, 0);

        JTable table = new JTable(model);


        //Daten hinzufügen
        sqlKalender = new sqlKalender();
        frame = new JFrame("Termine");
        content = frame.getContentPane();
        content.add(new JScrollPane(table), BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        amendData();
        frame.setLocationRelativeTo(null);
    }


    public static Vector<String> createDataVector(String[] schedule, int count) {
        Vector<String> vector = new Vector<>(2);

        //überträgt String Array in Vektor
        vector.addAll(Arrays.asList(schedule).subList(count, 2 +  count));
        return vector;
    }


    //Vektor zur Tabelle hinzufügen
    void amendData() {
        int filler = 0;
        for (int i = 0; i < sqlKalender.rowCount(); i++) {
            model.addRow(createDataVector(sqlKalender.allDates(), filler));
            filler += 2;
        }
    }
    void clear()
    {
        model.setRowCount(0);
    }

}








