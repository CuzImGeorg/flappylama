import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class aMovingObject {

    private int x;
    private int y;
    private final int width;
    private final int height;
    private boolean run = false;


    public aMovingObject(int x,int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        moveLeft();
    }

    public void start() {
        run = true;
    }

    public void stop() {
        run = false;
    }
    
    public void moveLeft() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(run) {
                x--;
            }
        },0 , start.getMode() == 0 ?  10 : 7, TimeUnit.MILLISECONDS);
    }

    public abstract void draw(Graphics g);



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
