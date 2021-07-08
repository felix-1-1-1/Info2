import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;


public class main {
    public static void main(String[] args) throws  UnsupportedLookAndFeelException{
        //design festlegen
        UIManager.setLookAndFeel(new FlatDarkLaf());

        //Haupt GUI Klasse instanzieren
        GUI GUI = new GUI();
        //GUI sichtbar machen
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
