import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CalenderGUI {
    sqlKalender sqlKalender;
    JFrame frame;
    Container content;
    JTable table;
    DefaultTableModel model;

    public CalenderGUI() {
        String[] titles = new String[]{"Datum", "Termin", "Erledigt"};

        model = new DefaultTableModel(titles, 0);

        JTable table = new JTable(model);

        sqlKalender = new sqlKalender();
        frame = new JFrame("Demo");
        content = frame.getContentPane();
        content.add(new JScrollPane(table), BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        amendData();
    }

    public static void main(String[] args) {
        CalenderGUI CalenderGUI = new CalenderGUI();
        CalenderGUI.amendData();
    }


    void amendData() {
        int size = model.getColumnCount();
        int filler = 0;
        for (int i = 0; i < sqlKalender.rowCount(); i++) {
            model.addRow(createDataVector(sqlKalender.allDates(), filler));
            filler += 3;
        }
    }


    public static Vector createDataVector(String[] schedule, int count) {
        Vector vector = new Vector(3);
        for (int i = 0; i < 3; i++)
            vector.add(schedule[i + count]);
        return vector;
    }
}








