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

    private int ax = 200, ay = 150, speedy = 15, aheight = 75, awidth = 75;
    private BufferedImage img;

    public animal(){

        try {
            img = ImageIO.read(new File("src/main/java/lama.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void moveAnimal() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            ay = ay +2;

        },0 , 20, TimeUnit.MILLISECONDS);

    }

    public void start(){
            moveAnimal();
    }

    public void moveUp(){
        ay=ay-30;
    }


    public void draw(Graphics g) {
        g.drawImage(img, ax, ay, awidth, aheight, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            moveUp();

        }
    }
}

