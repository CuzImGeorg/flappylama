import javax.swing.*;

public class MainFrame extends JFrame {
    MainPanel p;

    public MainFrame() {
         p = new MainPanel();
        setSize(400,650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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



    public MainPanel getP() {
        return p;
    }
}
