import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Balken extends aMovingObject{
    Image img;
    public Balken(int x) {
        super(x, 550, 40, 20);
        try {
            img = ImageIO.read(new File("src/main/java/balken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        resetX();
    }

    public void resetX() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(getX()< -40) setX(400);
        },1,1, TimeUnit.MILLISECONDS);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(start.getRl().getBalken(), getX(), getY(),null);
    }
}
