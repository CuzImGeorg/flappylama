import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Roere extends aMovingObject {

    int x;
    int y;
    Image img;
    Image img2;
    int height;
    int width;

    public Roere(){
     super(400,0,20,400);
     Random r = new Random();
     y = -r.nextInt(300);

        try {
            img = ImageIO.read(new File("src/main/java/rohre.png"));
        } catch (IOException ex) {
            // ex.printStackTrace();
        }

        try {
            img2 = ImageIO.read(new File("src/main/java/rohre.png"));
        } catch (IOException ex) {
            // ex.printStackTrace();
        }


    }

    @Override
    public void draw(Graphics g) {
        //g.drawImage(img, posX, posY, null);
        g.drawImage(img, x, y, width, height, null);
        g.drawImage(img2, x, y+height+100, width, height, null);

    }

}
