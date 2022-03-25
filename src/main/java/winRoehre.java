import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class winRoehre extends aMovingObject{
    private Image img;

    public winRoehre() {
        super(400,300,150,300);


        img = start.getRl().getWinrohr();


    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, getX(), getY(), getWidth(), getHeight(), null);
    }
}

