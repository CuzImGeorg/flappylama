import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPanel extends JPanel implements KeyListener{
    private boolean run = false;
    private animal lama;
    private ArrayList<Balken> drawingBalken;
    private ArrayList<Roere> drawingRoere;

    private Logo logo;
    public MainPanel() {
        setSize(400,600);
        lama = new animal();
        logo = new Logo();
        drawingBalken = new ArrayList<>();
        drawingRoere = new ArrayList<>();

        for (int i = 0; i <11; i++) {
            drawingBalken.add(new Balken(i*40));
        }


        addKeyListener(this);
        update();

    }

    public void start() {
        drawingBalken.forEach(aMovingObject::start);

        lama.start();
        logo.start();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(lama.isDead()) ses.shutdown();
            drawingRoere.add(new Roere());
            drawingRoere.forEach(run ? aMovingObject::start : null);
            drawingRoere.removeIf(r -> r.getX() < 10);
        },3,3,TimeUnit.SECONDS);
        detectCollision();
    }

    public void detectCollision() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {

            for(Roere r : drawingRoere) {
                if(lama.getAx() > r.getX() && lama.getAx() < r.getX() + r.getWidth()) {
                    System.out.println(r.getY());
                    System.out.println(lama.getAy());
                    if(lama.getAy() < r.getY()+350 || lama.getAy() > r.getY() + getHeight()+600) // TODO fix


                    lama.setDead(true);

                }
            }
        },1,1, TimeUnit.MILLISECONDS);
    }

    public void update() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> updateUI(), 1,1, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(lama.isDead()) {
            drawingRoere.forEach(aMovingObject::stop);
            drawingBalken.forEach(aMovingObject::stop);

        }
        drawingBalken.forEach((b) -> b.draw(g));
        drawingRoere.forEach((c) -> c.draw(g));
        lama.draw(g);
        logo.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        lama.keyPressed(e);
        if(!run) {
            run = true;
            start();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
