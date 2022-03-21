import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Highscore {

   int score;
    public Highscore(int score){
        this.score = score;
        int array;
        try {
            // Creates a reader using the FileReader

            File output = new File("src/main/java/score.txt");
            Scanner s = new Scanner(output);
            int i = s.nextInt();

            // Reads characters

            if(score > i){
                FileWriter input = new FileWriter("src/main/java/score.txt");
                input.write(""+ score);
                input.close();
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }

    }
}
