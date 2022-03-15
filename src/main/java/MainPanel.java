import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPanel extends JPanel {
    private ArrayList<Balken> drawingBalken;
    private Roere r;
    public MainPanel() {
        setSize(400,600);

        drawingBalken = new ArrayList<>();
        r = new Roere();
        for (int i = 0; i <11; i++) {
            drawingBalken.add(new Balken(i*40));
        }
        drawingBalken.forEach(aMovingObject::start);
        r.start();
        update();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void update() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> updateUI(), 1,1, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawingBalken.forEach((b) -> b.draw(g));
        r.draw(g);

    }
}
