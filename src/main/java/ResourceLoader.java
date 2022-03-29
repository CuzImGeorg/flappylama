import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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

    public void secret(KeyEvent e) throws IOException {
        System.out.println(e.getKeyChar());
        switch (e.getKeyChar()) {
            case 'q' ->  {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/1945/flammedown.png"));
                winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
                rohrup=ImageIO.read(new File("src/main/java/img/1945/flamme.png")); ;
                hg= ImageIO.read(new File("src/main/java/img/1945/ort.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/1945/stern.png"));
            }
            case 'w' -> {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/2022/haus2down.png"));
                winrohr= ImageIO.read(new File("src/main/java/img/2022/ukraine.png"));
                rohrup= ImageIO.read(new File("src/main/java/img/2022/haus2.png"));
                hg= ImageIO.read(new File("src/main/java/img/2022/apocalypsehg.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/2022/tank.png"));
            }
            case 'e' ->  {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/2022/haus2down.png"));
                winrohr= ImageIO.read(new File("src/main/java/img/elfsetember/ziel.png"));
                rohrup= ImageIO.read(new File("src/main/java/img/2022/haus2.png"));
                hg= ImageIO.read(new File("src/main/java/img/elfsetember/hg.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/elfsetember/flugzeug.png"));
            }
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

        JMenuItem Sushi = new JMenuItem("Sushi");
        Sushi.setForeground(Color.white);
        Sushi.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/sushi/bambusrohr.jpg"));
                winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
                rohrup= rohredown;
                hg= ImageIO.read(new File("src/main/java/img/sushi/sushihg.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/sushi/sushi.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        Sushi.setBackground(Color.gray);
        animal.add(Sushi);

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
                rohredown= ImageIO.read(new File("src/main/java/img/1945/flammedown.png"));
                winrohr= ImageIO.read(new File("src/main/java/winrohr.png"));
                rohrup=ImageIO.read(new File("src/main/java/img/1945/flamme.png")); ;
                hg= ImageIO.read(new File("src/main/java/img/1945/ort.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/1945/stern.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        dd.setBackground(Color.gray);
//        animal.add(dd);


        JMenuItem tank = new JMenuItem("testpackplsignore");
        tank.setForeground(Color.white);
        tank.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/2022/haus2down.png"));
                winrohr= ImageIO.read(new File("src/main/java/img/2022/ukraine.png"));
                rohrup= ImageIO.read(new File("src/main/java/img/2022/haus2.png"));
                hg= ImageIO.read(new File("src/main/java/img/2022/apocalypsehg.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/2022/tank.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        tank.setBackground(Color.gray);
//        animal.add(tank);

        JMenuItem elfsetember = new JMenuItem("elfsetember");
        elfsetember.setForeground(Color.white);
        elfsetember.addActionListener((l)-> {
            BufferedImage  tmp = null;
            try {
                balken= ImageIO.read(new File("src/main/java/balken.png"));
                rohredown= ImageIO.read(new File("src/main/java/img/2022/haus2down.png"));
                winrohr= ImageIO.read(new File("src/main/java/img/elfsetember/ziel.png"));
                rohrup= ImageIO.read(new File("src/main/java/img/2022/haus2.png"));
                hg= ImageIO.read(new File("src/main/java/img/elfsetember/hg.png"));
                animalbild= ImageIO.read(new File("src/main/java/img/elfsetember/flugzeug.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        elfsetember.setBackground(Color.gray);
//        animal.add(elfsetember);


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
