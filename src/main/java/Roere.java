import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Roere extends aMovingObject {


    Image img;
    Image img2;


    public Roere(){
     super(400,0,50,400);
     Random r = new Random();
     int t = -r.nextInt(300);
     setY(t);

        try {
            img = ImageIO.read(new File("src/main/java/rohrdown.png"));
        } catch (IOException ex) {

        }

        try {
            img2 = ImageIO.read(new File("src/main/java/rohrup.png"));
        } catch (IOException ex) {

        }


    }

    @Override
    public void draw(Graphics g) {
        //g.drawImage(img, posX, posY, null);
        g.drawImage(start.getRl().getRohredown(), getX(), getY(), getWidth(), getHeight(), null);
        g.drawImage(start.getRl().getRohredown(), getX(), getY()+getHeight()+100, getWidth(), getHeight(), null);

    }

}
