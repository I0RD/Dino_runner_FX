package pl.programming.environment;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;
import java.util.Random;

public class Clouds {
    private ImageView[] clouds=new ImageView[4];
    public HBox cloudsBox=new HBox();
    public Clouds() throws FileNotFoundException {
        for(int count=0;count<clouds.length;count++)
        {
            clouds[count]=new ImageView(new Image(Resource.getResource("src/resources/cloud.png")));
            clouds[count].translateXProperty().set(800+new Random().nextInt(120));
            clouds[count].translateYProperty().set(new Random().nextInt(120));
            cloudsBox.getChildren().add(clouds[count]);
            KeyValue keyValue = new KeyValue(clouds[count].translateXProperty(), -300);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
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
