package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Land {
    private final Image landOne=new Image(Resource.getResource("src/resources/land1.png"));
    private final Image landTwo=new Image(Resource.getResource("src/resources/land2.png"));
    private final Image landThree=new Image(Resource.getResource("src/resources/land2.png"));
    public ArrayList<Image>lands=new ArrayList<>();
    public Land() throws FileNotFoundException {
        generate();
        update();
    }
    public void generate() {
        if (lands.size() * landOne.getWidth() < 771) {
            switch (new Random().nextInt(3)) {
                case 0 -> lands.add(landOne);
                case 1 -> lands.add(landTwo);
                case 2 -> lands.add(landThree);
            }
            generate();
        }
    }

    public void update()
    {
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                double posX = ((currentNanoTime - startNanoTime[0]) / 1000000000.0)* MainWindow.speed;
                for (int count = 0; count*landOne.getWidth() < 771; count++) {
                    MainWindow.canvas.getGraphicsContext2D().drawImage(lands.get(count), count * landOne.getWidth()-posX, 331);
                    MainWindow.canvas.getGraphicsContext2D().restore();
                }
                if(posX>71)
                {
                    startNanoTime[0] = System.nanoTime();
                    MainWindow.speed+=1.25;
                    lands.remove(0);
                    generate();
                }
            }
        }.start();
    }
}
