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
        String[] titles = new String[]{"Datum", "Termin", "Erledigt"};

        model = new DefaultTableModel(titles, 0);

        JTable table = new JTable(model);

        sqlKalender = new sqlKalender();
        frame = new JFrame("Demo");
        content = frame.getContentPane();
        content.add(new JScrollPane(table), BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        amendData();
        frame.setLocationRelativeTo(null);
    }


    public static Vector<String> createDataVector(String[] schedule, int count) {
        Vector<String> vector = new Vector<>(3);
        vector.addAll(Arrays.asList(schedule).subList(count, 3 +  count));
        return vector;
    }

    void amendData() {
        int size = model.getColumnCount();
        int filler = 0;
        for (int i = 0; i < sqlKalender.rowCount(); i++) {
            model.addRow(createDataVector(sqlKalender.allDates(), filler));
            filler += 3;
        }
    }
}








