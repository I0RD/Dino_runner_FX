package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;
import java.io.FileNotFoundException;
import java.util.Random;

public class Enemy{
    public ImageView cactus = null;
    public double posX;
    public double posY;

    public Enemy(double posX) throws FileNotFoundException {
        switch (new Random().nextInt(2)) {
            case 0 -> {
                cactus=new ImageView(new Image(Resource.getResource("src/resources/cactus1.png")));
                this.posY=307;
            }
            case 1->{
                cactus=new ImageView(new Image(Resource.getResource("src/resources/cactus2.png")));
                this.posY=320;
            }
        }
        this.posX=posX;
    }
}
