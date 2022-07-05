package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pl.programming.MainWindow;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EnemyManager {
    public HBox enemyBox=new HBox();
    private ArrayList<Enemy> enemies=new ArrayList<>();
    public EnemyManager()
    {
        generate();
        update();
    }
    public void generate() {
        for(int count= enemyBox.getChildren().size();count<6;count++)
        {
            try {
                enemies.add(new Enemy(700+count*300));
                enemyBox.getChildren().add(enemies.get(count).cactus);
                enemyBox.getChildren().get(count).translateYProperty().set(enemies.get(count).posX);
                enemyBox.getChildren().get(count).translateYProperty().set(enemies.get(count).posY);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    public void update()
    {
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                for (int count = 0; count<enemyBox.getChildren().size(); count++) {
                    enemies.get(count).posX=enemies.get(count).posX-MainWindow.speed/100;
                    enemyBox.getChildren().get(count).translateXProperty().set(enemies.get(count).posX);
                    enemyBox.getChildren().get(count).translateYProperty().set(enemies.get(count).posY);
                }
                if(enemies.get(0).posX<-100&&enemyBox.getChildren().size()==6)
                {
                    startNanoTime[0] = System.nanoTime();
                    enemyBox.getChildren().remove(0);
                    enemies.remove(0);
                    generate();
                }
            }
        }.start();
    }
}
