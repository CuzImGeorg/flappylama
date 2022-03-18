import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class score extends animal{
    private int score = 1;

//if dead add stop no count
    public void scoreCount() {

            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(() -> {
                if (isDead()) {
                    ses.shutdown();
                } else score++;
                System.out.printf(String.valueOf(score));
            }, 5000, 3000, TimeUnit.MILLISECONDS);

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
