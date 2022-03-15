import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        MainPanel p = new MainPanel();
        setSize(400,650);
        setDefaultCloseOperation(3);
        setLayout(null);
        setContentPane(p);
        addKeyListener(p);

        setVisible(true);
    }

}
