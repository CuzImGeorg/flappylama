import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class deadscreen  {

    private int score;
    private int highscore;

    public deadscreen(int score) {
        this.score = score;

        char[] array = new char[100];
        try {
            FileReader output = new FileReader("score.txt");
            output.read(array);
            output.close();
            highscore = Integer.parseInt(new String(array));
        } catch (Exception e) {
            e.getStackTrace();
        }
        JButton restart = new JButton();
        restart.setBounds(180, 500, 60, 30);
        restart.setText("Restart");
        restart.setBackground(Color.WHITE);
        restart.addActionListener((l)-> {
            start.getMf().restart();
        });
        start.getMf().getP().add(restart);

        JButton quit = new JButton();
        quit.setBounds(180, 550, 60, 30);
        quit.setText("Quit");
        quit.setBackground(Color.WHITE);
        quit.addActionListener((l)-> {
            System.exit(0);
        });
        start.getMf().getP().add(quit);

        JLabel scorejl = new JLabel("Score /n"+score);
        scorejl.setFont(new Font("Verdana",1,20));
        scorejl.setBounds(180,400,60,30);
        start.getMf().getP().add(scorejl);


        JLabel Highscorejl = new JLabel("Highscore /n"+highscore);
        Highscorejl.setFont(new Font("Verdana",1,20));
        Highscorejl.setBounds(180,450,60,30);
        start.getMf().getP().add(Highscorejl);
    }

}
