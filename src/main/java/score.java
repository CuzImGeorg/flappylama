import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class score extends animal{
    private int score = 1;
    boolean c = false;


    public void scoreCount() {

        if(c) {
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(() -> {
                if (isDead()) {
                    ses.shutdown();
                } else score++;
                System.out.printf(String.valueOf(score));
            }, 0, 3000, TimeUnit.MILLISECONDS);
        }
        else if(c){
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(() -> {
                c = true;

            }, 0, 5000, TimeUnit.MILLISECONDS);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
