package pl.programming.environment;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import pl.programming.MainWindow;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;
import java.util.Random;

public class Clouds {
    private final ImageView[] clouds=new ImageView[4];
    public Clouds() throws FileNotFoundException {
        for(int count=0;count<clouds.length;count++)
        {
            clouds[count]=new ImageView(new Image(Resource.getResource("src/resources/cloud.png")));
            clouds[count].translateXProperty().set(800+new Random().nextInt(120));
            clouds[count].translateYProperty().set(new Random().nextInt(120));
            MainWindow.canvas.getGraphicsContext2D().drawImage(clouds[count].getImage(),clouds[count].getTranslateX(),clouds[count].getTranslateY());
            KeyValue keyValue = new KeyValue(clouds[count].translateXProperty(), -300);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(30), keyValue);
            Timeline timeline = new Timeline(keyFrame);
            timeline.play();
            int finalCount = count;
            timeline.setOnFinished(actionEvent -> {
                clouds[finalCount].translateXProperty().set(800+new Random().nextInt(120));
                timeline.play();
            });
        }
    }
}
