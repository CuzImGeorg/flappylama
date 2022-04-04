import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class score {
    private int score=0;
    JLabel scorejl;
//if dead add stop no count
    public void scoreCount() {

        scorejl = new JLabel(String.valueOf(score));
        scorejl.setFont(new Font("Verdana",1,20));
        scorejl.setBounds(100,100,300,80);
        start.getMf().getP().add(scorejl);

            ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
            ses.scheduleAtFixedRate(() -> {
                if (start.getMf().getP().getLama().isDead()) {
                    ses.shutdown();
                } else score++;
            }, 1500, start.getMode() == 0 ?  3000 : 2000, TimeUnit.MILLISECONDS);

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void draw(Graphics g){

        scorejl.setText(String.valueOf(score));


    }


}
