import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Logo extends aMovingObject{

    Image img;

    public Logo(){
        super(50,200,100,80);
        try {
            img = ImageIO.read(new File("src/main/java/logo2.png"));
        } catch (IOException ex) {

        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
    }
}
