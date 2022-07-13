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

public class Sun {
    private final ImageView sun=new ImageView(new Image(Resource.getResource("src/resources/Sun.png")));
    public HBox sunBox=new HBox();
    public Sun() throws FileNotFoundException {
        sun.translateXProperty().set(800);
        sun.translateYProperty().set(80);
        sunBox.getChildren().add(sun);
    }
    public void update()
    {
        KeyValue keyValue = new KeyValue(sun.translateXProperty(), -100);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(40), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
        timeline.setOnFinished(actionEvent -> {
            sun.translateXProperty().set(800);
            timeline.play();
        });
    }
}