import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(400,650);
        setDefaultCloseOperation(3);
        setLayout(null);
        setContentPane(new MainPanel());
        setVisible(true);
    }

}
