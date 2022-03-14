import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(400,600);
        setDefaultCloseOperation(3);
        setLayout(null);
        setContentPane(new MainPanel());
        setVisible(true);
    }

}
