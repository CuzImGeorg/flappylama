import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class deadscreen  {

    private int score;
    private int highscore;

    public deadscreen(int score) {
        this.score = score;
        char[] chars = new char[100];

        try {
            File output = new File("src/main/java/score.txt");
            Scanner s = new Scanner(output);
            int i = s.nextInt();
            highscore = i;
        } catch (Exception e) {
            e.getStackTrace();
        }
        JButton restart = new JButton();
        restart.setBounds(180, 450, 80, 30);
        restart.setText("Restart");
        restart.setBackground(Color.WHITE);
        restart.addActionListener((l)-> {
            start.getMf().restart();
        });
        start.getMf().getP().add(restart);

        JButton quit = new JButton();
        quit.setBounds(180, 490, 80, 30);
        quit.setText("Quit");
        quit.setBackground(Color.WHITE);
        quit.addActionListener((l)-> {
            System.exit(0);
        });
        start.getMf().getP().add(quit);

        JLabel scorejl = new JLabel("Score: "+score);
        scorejl.setFont(new Font("Verdana",1,20));
        scorejl.setBounds(180,200,300,80);
        start.getMf().getP().add(scorejl);


        JLabel Highscorejl = new JLabel("Highscore: "+highscore);
        Highscorejl.setFont(new Font("Verdana",1,20));
        Highscorejl.setBounds(150,240,300,80);
        start.getMf().getP().add(Highscorejl);
    }

}
