import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public  class ResourceLoader {
    private BufferedImage balken, animalbild, hg, rohredown, rohrup, winrohr;



    public ResourceLoader(){
        try {
            balken= ImageIO.read(new File("src/main/java/balken.png"));
            rohredown= ImageIO.read(new File("src/main/java/rohrdown.png"));
            winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
            rohrup= ImageIO.read(new File("src/main/java/rohrup.png"));
            hg= ImageIO.read(new File("src/main/java/hg.png"));
            animalbild= ImageIO.read(new File("src/main/java/lama.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void addtoPanel(JPanel p){
        JMenuBar bar = new JMenuBar();
        bar.setBounds(1,1,25,20);
        bar.setBackground(Color.darkGray);

        JMenu animal = new JMenu("Tp");
        animal.setBounds(0,0,100,20);
        animal.setBackground(Color.darkGray);
        animal.setForeground(Color.white);
        JMenuItem normal = new JMenuItem("default");
        normal.setForeground(Color.white);
        normal.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/rohrdown.png"));
                winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
                rohrup= ImageIO.read(new File("src/main/java/rohrup.png"));
                hg= ImageIO.read(new File("src/main/java/hg.png"));
                animalbild= ImageIO.read(new File("src/main/java/lama.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        normal.setBackground(Color.gray);
        animal.add(normal);
        bar.add(animal);

        JMenuItem dog = new JMenuItem("Minecraft");
        dog.setForeground(Color.white);
        dog.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/dog/tree.png"));
                winrohr= ImageIO.read(new File("src/main/java/img/dog/mcsheepdownload.png"));
                rohrup= rohredown;
                hg= ImageIO.read(new File("src/main/java/img/dog/mcbackground.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/dog/mcwolf.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        dog.setBackground(Color.gray);
        animal.add(dog);


        JMenuItem dd = new JMenuItem("testdonotuse");
        dd.setForeground(Color.white);
        dd.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/dog/tree.png"));
                winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
                rohrup=ImageIO.read(new File("src/main/java/img/1945/flamme.png")); ;
                hg= ImageIO.read(new File("src/main/java/img/1945/ort.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/dog/mcwolf.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        dd.setBackground(Color.gray);
        animal.add(dd);

        p.add(bar);
        p.updateUI();
    }

    public BufferedImage getBalken() {
        return balken;
    }

    public BufferedImage getAnimalbild() {
        return animalbild;
    }

    public BufferedImage getHg() {
        return hg;
    }



    public BufferedImage getRohredown() {
        return rohredown;
    }



    public BufferedImage getRohrup() {
        return rohrup;
    }

    public BufferedImage getWinrohr() {
        return winrohr;
    }
}
