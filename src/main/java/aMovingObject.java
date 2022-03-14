import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class aMovingObject {

    private int x,y;
    private boolean run = false;


    public aMovingObject(int x,int y){
        this.x = x;
        this.y = y;

    }
    
    public void moveLeft() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(run) {
                y--;
            }
        },0 , 10, TimeUnit.MILLISECONDS);
    }



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
}