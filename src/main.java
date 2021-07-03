import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;


public class main {
    public static void main(String[] args) throws  UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatDarkLaf());
        GUI GUI = new GUI();
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sqlNoten sqlNoten = new sqlNoten();

    }
}
