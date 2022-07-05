package pl.programming;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pl.programming.environment.Dino;
import pl.programming.environment.EnemyManager;
import pl.programming.environment.Land;

import java.io.FileNotFoundException;

public class GameManager {
    public Dino dino=new Dino();
    public Land land=new Land();
    public EnemyManager enemyManager=new EnemyManager();
    private boolean isDead=false;
    private boolean isPlay=false;

    public GameManager() throws FileNotFoundException {}

    public void game()
    {
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                if(!isDead&&!isPlay)
                {
                    dino.currentPose.imageProperty().set(dino.dinoIDLE);
                    MainWindow.mainScene.setOnKeyPressed((KeyEvent event) -> {
                        if(event.getCode()== KeyCode.W||event.getCode()==KeyCode.SPACE)
                        {
                            isPlay=true;
                            enemyManager.generate();
                            enemyManager.update();
                            land.update();
                        }
                    });
                }
                double t = ((currentNanoTime - startNanoTime[0]) / 100000000.0);
                if(t>2&&isPlay)
                {
                    if(dino.currentPose.imageProperty().get()==dino.dinoRUNR)
                    {
                        dino.currentPose.imageProperty().set(dino.dinoRUNL);
                    }
                    else
                    {
                        dino.currentPose.imageProperty().set(dino.dinoRUNR);
                    }
                    startNanoTime[0] =System.nanoTime();
                }
            }
        }.start();
    }
}
