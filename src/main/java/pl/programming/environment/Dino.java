package pl.programming.environment;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import pl.programming.utilities.Resource;
import java.io.FileNotFoundException;

public class Dino {
    public Rectangle dinoRec;
    public final Image dinoIDLE = new Image(Resource.getResource("src/resources/main-character3.png"));
    public final Image dinoDEAD = new Image(Resource.getResource("src/resources/main-character4.png"));
    public final Image dinoRUNL = new Image(Resource.getResource("src/resources/main-character2.png"));
    public final Image dinoRUNR = new Image(Resource.getResource("src/resources/main-character1.png"));
    public ImageView currentPose=new ImageView(dinoIDLE);
    public HBox dinoBox=new HBox();
    public Dino() throws FileNotFoundException {
        currentPose.translateXProperty().set(100);
        currentPose.translateYProperty().set(310);
        dinoRec=new Rectangle(currentPose.getImage().getWidth(),currentPose.getImage().getHeight(),currentPose.getX(),currentPose.getY());
        dinoBox.getChildren().add(currentPose);
    }
    public void update()
    {
        dinoRec=new Rectangle(currentPose.getImage().getWidth()-5,currentPose.getImage().getHeight()-5,currentPose.getTranslateX()-5,currentPose.getTranslateY()+5);
    }
}