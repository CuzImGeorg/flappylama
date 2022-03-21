import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Highscore {

   int score;
    public Highscore(int score){
        this.score = score;
        char[] array = new char[100];
        try {
            // Creates a reader using the FileReader
            FileReader output = new FileReader("src/main/java/score.txt");

            // Reads characters
            output.read(array);
            output.close();

            int i = Integer.parseInt(new String(array));
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
