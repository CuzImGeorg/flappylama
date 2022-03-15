import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Logo extends aMovingObject{

    Image img;

    public Logo(){
        super(0,50,80,80);

        try {
            img = ImageIO.read(new File("src/main/java/rohrdown.png"));
        } catch (IOException ex) {

        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
    }
}
