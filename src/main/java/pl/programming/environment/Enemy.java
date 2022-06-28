package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private final Image cactusOne = new Image(Resource.getResource("src/resources/cactus1.png"));
    private final Image cactusTwo = new Image(Resource.getResource("src/resources/cactus2.png"));
    private final ArrayList<Image> enemys=new ArrayList<>();

    public Enemy() throws FileNotFoundException {
        generate();
        update();
    }
    public void generate() {
        if (enemys.size() < 6) {
            switch (new Random().nextInt(3)) {
                case 1 -> enemys.add(cactusOne);
                case 2 -> enemys.add(cactusTwo);
            }
            generate();
        }
    }
    public void update() {
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                double posX = ((currentNanoTime - startNanoTime[0]) / 1000000000.0)* MainWindow.speed;
                for (int count = 0; count < enemys.size(); count++) {
                    if(enemys.get(count)==cactusTwo) {
                        MainWindow.canvas.getGraphicsContext2D().drawImage(enemys.get(count), (250+(count*300))-posX, 320);
                        MainWindow.canvas.getGraphicsContext2D().restore();
                    }else
                    {
                        MainWindow.canvas.getGraphicsContext2D().drawImage(enemys.get(count), (250+(count*300))-posX, 308);
                        MainWindow.canvas.getGraphicsContext2D().restore();
                    }
                    if((250+(count*300))-posX<-30)
                    {
                        startNanoTime[0] = System.nanoTime();
                        enemys.remove(0);
                        generate();
                    }
                }
            }
        }.start();
    }
}
