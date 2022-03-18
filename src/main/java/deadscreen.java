import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class deadscreen extends JPanel  {

    private int score;
    private int highscore;

    public deadscreen(int score) {
        setSize(400, 600);
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
        restart.setBounds(100, 500, 60, 30);
        restart.setText("Restart");
        restart.setBackground(Color.WHITE);
        restart.addActionListener((l)-> {
            start.getMf().restart();
        });

        JButton quit = new JButton();
        quit.setBounds(100, 550, 60, 30);
        quit.setText("Quit");
        quit.setBackground(Color.WHITE);
        quit.addActionListener((l)-> {
            System.exit(0);
        });

    }

}
