import javax.swing.*;

public class main {
    public static void main(String[] args)throws ClassNotFoundException, UnsupportedLookAndFeelException, IllegalAccessException, InstantiationException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI GUI = new GUI();
        GUI.setVisible(true);
    }
}
