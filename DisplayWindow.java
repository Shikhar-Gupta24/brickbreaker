import java.awt.*;//This allows the window to work properly
import javax.swing.*;

public class DisplayWindow extends JFrame{
    private Container c;

    public DisplayWindow (String s){
        super(s);
        c = this.getContentPane();
    }

    public void addPanel(JPanel p){
        c.add(p);
    }

    public void showFrame(){
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}