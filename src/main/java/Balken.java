import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Balken extends aMovingObject{
    int x;
    Image img;
    public Balken(int x, int width, int height) {
        super(x, 50, 80, 20);
        try {
            img = ImageIO.read(new File("src/main/java/balken.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
