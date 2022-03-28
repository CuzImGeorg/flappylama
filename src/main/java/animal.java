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
    public boolean dead = false;
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
            ay = ay +3;
            if(dead) ses.shutdown();
            if(ay >= 500 || ay < -5){
                dead = true;
                ses.shutdown();
            }
        },0 , 20, TimeUnit.MILLISECONDS);

    }

    public void start(){
            moveAnimal();
    }
    int i = 5;
    public void moveUp(){
        i=5;
  /*      if(!dead) {
            ay = ay - 53;
        } */

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
                if (!dead && i > 0) {
                    ay = ay - 10;
                    i--;
                }else {
                    ses.shutdown();
                }

        },0 , 20, TimeUnit.MILLISECONDS);

    }


    public void draw(Graphics g) {
        g.drawImage(start.getRl().getAnimalbild(), ax, ay, awidth, aheight, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            moveUp();

        }
    }

    public boolean isDead() {
        return dead;
    }

    public int getAx() {
        return ax;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getSpeedy() {
        return speedy;
    }

    public void setSpeedy(int speedy) {
        this.speedy = speedy;
    }

    public int getAheight() {
        return aheight;
    }

    public void setAheight(int aheight) {
        this.aheight = aheight;
    }

    public int getAwidth() {
        return awidth;
    }

    public void setAwidth(int awidth) {
        this.awidth = awidth;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

