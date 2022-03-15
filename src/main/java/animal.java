import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class animal {

    private int ax = 200, ay = 150, speedy = 15, aheight = 130, awidth = 130;
    private BufferedImage img;

    public animal(int ax, int ay, int speedy, int aheight, int awidth){
        this.ax = ax;
        this.ay = ay;
        this.speedy = speedy;
        this.awidth = awidth;
        this.aheight = aheight;

        try {
            img = ImageIO.read(new File("lama.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void moveAnimal() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            ay = ay -2;

        },0 , 100, TimeUnit.MILLISECONDS);

    }

    public void start(){
            moveAnimal();
    }

    public void moveUp(){
        ay=ay+30;
    }


    public void draw(Graphics g) {
        g.drawImage(img, ay, ax, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            moveUp();

        }
    }
}

