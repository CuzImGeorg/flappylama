import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class score extends animal{
    private int score;

    public void scoreCount() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(dead = true){
                ses.shutdown();}
            else score++;

        },0 , 2000, TimeUnit.MILLISECONDS);

    }

    public void setScore(int score) {
        this.score = score;
    }
}
