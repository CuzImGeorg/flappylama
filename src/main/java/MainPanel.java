import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPanel extends JPanel implements KeyListener{
    private boolean run = false;
    private final animal lama;
    private final ArrayList<Balken> drawingBalken;
    private final ArrayList<Roere> drawingRoere;
    private score sc;
    private deadscreen dc;
    private final Logo logo;
    private winRoehre wr;
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
        start.getRl().addtoPanel(this);
        update();
        endless();
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

    public void renderTimer(Graphics g) {
        g.setFont(new Font("Verdana",1,20));
        g.drawString(min+":"+sec, 330,20);
    }

    private int sec = 0, min = 0;
    public void timer() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(() -> {
            if(lama.isDead()) ses.shutdown();
            if(sec == 59) {
                sec = 0;
                min++;
            }else {
                sec++;
            }

        },1,1,TimeUnit.SECONDS );


    }

    public void start() {
        drawingBalken.forEach(aMovingObject::start);
        sc = new score();
        sc.scoreCount();
        lama.start();
        logo.start();
        timer();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(lama.isDead()) ses.shutdown();
            if(sc.getScore() <= start.getWinpoints()-2) {
                drawingRoere.add(new Roere());
                drawingRoere.forEach(run ? aMovingObject::start : null);
                drawingRoere.removeIf(r -> r.getX() < 10);
            }
            else {
                wr = new winRoehre();
                wr.start();
                ses.shutdown();
                ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(1);
                ses2.schedule(()->{
                    lama.setDead(true);
                    wr.stop();
                },2000,TimeUnit.MILLISECONDS);
            }
        },3,3,TimeUnit.SECONDS);
        detectCollision();
    }

    public void detectCollision() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {

            for(Roere r : drawingRoere) {
                if(r.getX() <= lama.getAx() + lama.getAwidth()-25 && r.getX() + r.getWidth() >= lama.getAx()+50){
                    if(lama.getAy() <= r.getY()+350 || lama.getAy()>r.getY()+450){
                        lama.setDead(true);
                        ses.shutdown();
                    }

                }


            }
        },1,1, TimeUnit.MILLISECONDS);
    }

    public void update() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(this::updateUI, 1,5, TimeUnit.MILLISECONDS);
    }

    public void endless() {
        JMenu endless = new JMenu("Endless");
        JMenuItem selectendless = new JMenuItem("Endless");
        endless.setBackground(Color.darkGray);
        endless.setForeground(Color.white);
        endless.setBounds(101, 0,100,20);
        selectendless.setBackground(Color.darkGray);
        selectendless.setForeground(Color.white);
        selectendless.addActionListener((l)-> {
            start.setWinpoints(999999);
            endless.setText("Endless");
        });


        JMenuItem winon100 = new JMenuItem("Normal");
        winon100.setBackground(Color.darkGray);
        winon100.setForeground(Color.white);
        winon100.addActionListener((l)-> {
            start.setWinpoints(100);
            endless.setText("Normal");
        });


        endless.add(winon100);
        endless.add(selectendless);
        start.getRl().bar.add(endless);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(start.getRl().getHg(), 0,0 ,400,570,null);
        if(lama.isDead()) {
            drawingRoere.forEach(aMovingObject::stop);
            drawingBalken.forEach(aMovingObject::stop);

        }
        drawingBalken.forEach((b) -> b.draw(g));
        drawingRoere.forEach((c) -> c.draw(g));

        try{
            wr.draw(g);
        } catch (Exception ignored) {}
        lama.draw(g);
        logo.draw(g);
        try{
            sc.draw(g);
        } catch (Exception ignored) {}

        try {
            g.drawImage(ImageIO.read(new File("src/main/java/cloud.png")), 0,0, 600,40,null );
        } catch (IOException e) {
            e.printStackTrace();
        }
        renderTimer(g);
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


}
