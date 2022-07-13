package pl.programming.environment;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import pl.programming.MainWindow;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EnemyManager {
    public Group enemyBox=new Group();
    private final ArrayList<Enemy> enemies=new ArrayList<>();
    public EnemyManager() {}
    public void generate() {
        for(int count= enemyBox.getChildren().size();count<6;count++)
        {
            try {
                if(count==0)
                {
                    enemies.add(new Enemy(750));
                }
                else
                {
                    enemies.add(new Enemy(enemies.get(count-1).getPosX()+200));
                }
                enemyBox.getChildren().add(enemies.get(count).getImage());
                enemyBox.getChildren().get(count).translateYProperty().set(enemies.get(count).getPosX());
                enemyBox.getChildren().get(count).translateYProperty().set(enemies.get(count).getPosY());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    public void update()
    {
        new AnimationTimer() {
            public void handle (long l){
                for (int count = 0; count<enemyBox.getChildren().size(); count++) {
                    enemies.get(count).setPosX(enemies.get(count).getPosX()-MainWindow.speed/150);
                    enemyBox.getChildren().get(count).translateXProperty().set(enemies.get(count).getPosX());
                }
                if(enemies.get(0).getPosX()<-100&&enemyBox.getChildren().size()==6)
                {
                    enemyBox.getChildren().remove(0);
                    enemies.remove(0);
                    generate();
                }
            }
        }.start();
    }
    public double getX(int o)
    {
        return enemies.get(o).getPosX();
    }
    public double getY(int o)
    {
        return enemies.get(o).getPosY();
    }
    public double getW(int o)
    {
        return enemies.get(o).getImage().getImage().getWidth()-80;
    }
    public double getH(int o)
    {
        return enemies.get(o).getImage().getImage().getHeight();
    }
    public void reflash()
    {
        enemies.removeAll(enemies);
        enemyBox.getChildren().removeAll(enemyBox.getChildren());
        generate();
    }
}