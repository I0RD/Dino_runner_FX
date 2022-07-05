package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;

public class Dino {
    public final Image dinoIDLE = new Image(Resource.getResource("src/resources/main-character3.png"));
    public final Image dinoDEAD = new Image(Resource.getResource("src/resources/main-character4.png"));
    public final Image dinoRUNL = new Image(Resource.getResource("src/resources/main-character2.png"));
    public final Image dinoRUNR = new Image(Resource.getResource("src/resources/main-character1.png"));
    public ImageView currentPose=new ImageView(dinoIDLE);
    public HBox dinoBox=new HBox();
    public Dino() throws FileNotFoundException {
        currentPose.translateXProperty().set(100);
        currentPose.translateYProperty().set(310);
        dinoBox.getChildren().add(currentPose);
    }
}
