package pl.programming.environment;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import pl.programming.utilities.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Land {
    private final Image landOne=new Image(Resource.getResource("src/resources/land1.png"));
    private final Image landTwo=new Image(Resource.getResource("src/resources/land2.png"));
    private final Image landThree=new Image(Resource.getResource("src/resources/land2.png"));
    public ArrayList<Image>lands=new ArrayList<>();
    public Canvas canvas=new Canvas(700,400);
    private GraphicsContext gc=canvas.getGraphicsContext2D();
    public Land() throws FileNotFoundException {
        generate();
    }
    public void generate() {
        if (lands.size() * landOne.getWidth() < 771) {
            switch (new Random().nextInt(3)) {
                case 1 -> lands.add(landOne);
                case 2 -> lands.add(landTwo);
                case 3 -> lands.add(landThree);
            }
            generate();
        }
    }

    public void update(double speed)
    {
        for (int count = 0; count*landOne.getWidth() < 771; count++) {
            if(count * landOne.getWidth()-speed<-71)
            {
                lands.remove(count);
                generate();
            }
            else
            {
                gc.drawImage(lands.get(count), count * landOne.getWidth()-speed, 331);
                gc.restore();
            }
        }
    }
}
