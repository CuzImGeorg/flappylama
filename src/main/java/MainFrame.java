import javax.swing.*;

public class MainFrame extends JFrame {
    MainPanel p;
    public MainFrame() {
         p = new MainPanel();
        setSize(400,650);
        setDefaultCloseOperation(3);
        setLayout(null);
        setContentPane(p);
        addKeyListener(p);

        setVisible(true);
    }

    public void restart() {
        p = new MainPanel();
        setContentPane(p);
    }

    public MainPanel getP() {
        return p;
    }
}
