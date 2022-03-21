import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private score sc;
    private deadscreen dc;
    private Logo logo;
    public MainPanel() {
        setSize(400,600);
        setLayout(null);
        lama = new animal();
        logo = new Logo();
        drawingBalken = new ArrayList<>();
        drawingRoere = new ArrayList<>();

        for (int i = 0; i <11; i++) {
            drawingBalken.add(new Balken(i*40));
        }


        addKeyListener(this);
        onDeath();
        update();

    }
    
    public void onDeath(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if (lama.isDead()) {
                dc = new deadscreen(sc.getScore());
                Highscore hs = new Highscore(sc.getScore());
                ses.shutdown();
            }

        },10,10, TimeUnit.MILLISECONDS);

    }

    public void start() {
        drawingBalken.forEach(aMovingObject::start);
        sc = new score();
        sc.scoreCount();
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
                    if(lama.getAy() < r.getY()+350 || lama.getAy() > r.getY() +450){
                        lama.setDead(true);
                        
                        ses.shutdown();
                    }



                }
            }
        },1,1, TimeUnit.MILLISECONDS);
    }

    public void update() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> updateUI(), 1,5, TimeUnit.MILLISECONDS);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(ImageIO.read(new File("src/main/java/hg.png")), 0,0 ,400,570,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lama.isDead()) {
            drawingRoere.forEach(aMovingObject::stop);
            drawingBalken.forEach(aMovingObject::stop);

        }
        drawingBalken.forEach((b) -> b.draw(g));
        drawingRoere.forEach((c) -> c.draw(g));
        try {
            g.drawImage(ImageIO.read(new File("src/main/java/wolke.png")), 0 , 0 ,400,20, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lama.draw(g);
        logo.draw(g);
        try{
            sc.draw(g);
        } catch (Exception s) {};


        g.setColor(new Color(245,222,179));
        g.fillRect(0,570,400,50);
        g.setColor(Color.black);

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

    public animal getLama() {
        return lama;
    }

    public score getScore() {
        return sc;
    }
}
