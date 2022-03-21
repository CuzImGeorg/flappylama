import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class score {
    private int score = 0;

//if dead add stop no count
    public void scoreCount() {

            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(() -> {
                if (start.getMf().getP().getLama().isDead()) {
                    ses.shutdown();
                } else score++;
            }, 5000, 3000, TimeUnit.MILLISECONDS);

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void draw(Graphics g){
        g.drawString(String.valueOf(score), 75,75);

    }
}
