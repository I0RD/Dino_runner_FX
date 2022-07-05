package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;

public class Dino {
    final Image dinoIDLE = new Image(Resource.getResource("src/resources/main-character3.png"));
    final Image dinoRUNL = new Image(Resource.getResource("src/resources/main-character2.png"));
    final Image dinoRUNR = new Image(Resource.getResource("src/resources/main-character1.png"));
    private final ImageView currentPose=new ImageView(dinoIDLE);
    public HBox dinoBox=new HBox();
    public Dino() throws FileNotFoundException {
        currentPose.translateXProperty().set(100);
        currentPose.translateYProperty().set(310);
        dinoBox.getChildren().add(currentPose);
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){

                double t = ((currentNanoTime - startNanoTime[0]) / 100000000.0);
                if(t>2)
                {
                    if(currentPose.imageProperty().get()==dinoRUNR)
                    {
                        currentPose.imageProperty().set(dinoRUNL);
                    }
                    else
                    {
                        currentPose.imageProperty().set(dinoRUNR);
                    }
                    startNanoTime[0] =System.nanoTime();
                }
            }
        }.start();
    }
}
