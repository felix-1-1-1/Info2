import javax.swing.*;

public class GUI extends JFrame{
    private JPanel panel1;
    private JSlider slider1;


    public static void main(String[] args){
        new GUI();
    }
    public GUI()
    {
        setTitle("test");
        setSize(400,500);
        addComponents();
    }

    void addComponents()
    {
        add(slider1);
    }
}
