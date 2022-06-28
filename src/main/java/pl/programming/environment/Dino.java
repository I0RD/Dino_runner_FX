package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;

public class Dino {
    final Image dinoIDLE = new Image(Resource.getResource("src/resources/main-character3.png"));
    final Image dinoRUNL = new Image(Resource.getResource("src/resources/main-character2.png"));
    final Image dinoRUNR = new Image(Resource.getResource("src/resources/main-character1.png"));
    Image currentPose=dinoRUNL;
    public Dino() throws FileNotFoundException {
        MainWindow.canvas.getGraphicsContext2D().drawImage(currentPose,100,310);
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                double t = ((currentNanoTime - startNanoTime[0]) / 100000000.0);
                if(t>2)
                {
                    if(currentPose==dinoRUNL)
                    {
                        currentPose=dinoRUNR;
                    }
                    else
                    {
                        currentPose=dinoRUNL;
                    }
                    startNanoTime[0] =System.nanoTime();
                }
            }
        }.start();
    }
}
