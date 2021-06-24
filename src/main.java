
import com.formdev.flatlaf.*;

import javax.swing.*;



public class main {
    public static void main(String[] args)throws ClassNotFoundException, UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException {
        UIManager.setLookAndFeel(new FlatDarkLaf());
        GUI GUI = new GUI();
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sqlNoten sqlNoten = new sqlNoten();

    }
}
