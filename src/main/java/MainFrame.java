import javax.swing.*;

public class MainFrame extends JFrame {
    MainPanel p;
    ResourceLoader rl;
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
        removeKeyListener(p);
        remove(p);
       p =  new MainPanel();


        setContentPane(p);
        addKeyListener(p);
        setVisible(false);
        setVisible(true);



    }

    public ResourceLoader getRl() {
        return rl;
    }

    public MainPanel getP() {
        return p;
    }
}
