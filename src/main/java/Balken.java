import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Balken extends aMovingObject{
    Image img;
    public Balken(int x) {
        super(x, 550, 40, 20);
        try {
            img = ImageIO.read(new File("src/main/java/balken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, getX(), getY(),null);
    }
}
