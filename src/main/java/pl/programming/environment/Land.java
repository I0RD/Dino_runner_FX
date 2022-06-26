package pl.programming.environment;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pl.programming.utilities.Resource;

import java.io.FileNotFoundException;

public class Land {
    ImageView landOne=new ImageView(Resource.getResource("src/resources/land1.png"));
    public HBox ground;
    public Land() throws FileNotFoundException {
        ground=new HBox(landOne);
        ground.setLayoutY(332);
    }
}
