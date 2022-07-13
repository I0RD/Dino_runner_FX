package pl.programming;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pl.programming.environment.*;
import java.io.FileNotFoundException;

public class GameManager {
    public Dino dino=new Dino();
    public Land land=new Land();
    public Sun sun=new Sun();
    public Clouds clouds=new Clouds();
    public EnemyManager enemyManager=new EnemyManager();
    public Text score=new Text("Score: ");
    private boolean isDead=false;
    private boolean isPlay=false;
    private boolean isJumping=false;
    private int scoreNumb=0;

    public GameManager() throws FileNotFoundException {
        score.setX(600);
        score.setY(20);
    }

    public void game()
    {
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                score.setText("Score: "+scoreNumb);
                MainWindow.mainScene.setOnKeyPressed((KeyEvent event) -> {
                    if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.SPACE) {
                        if(!isPlay&&!isDead)
                        {
                            sun.update();
                            clouds.update();
                            enemyManager.reflash();
                            enemyManager.update();
                            land.update();
                        }
                        else{
                            enemyManager.reflash();
                        }
                        scoreNumb=-1;
                        MainWindow.speed=60;
                        isPlay = true;
                        isDead = false;
                    }
                });
                if(!isDead)
                {
                    if(!isPlay)
                    {
                        dino.currentPose.imageProperty().set(dino.dinoIDLE);
                    }
                    else {
                        dino.update();
                        for(int count=0;count<enemyManager.enemyBox.getChildren().size();count++)
                        {
                            if(dino.dinoRec.intersects(enemyManager.getX(count),enemyManager.getY(count),enemyManager.getW(count),enemyManager.getH(count)))
                            {
                                isPlay=false;
                                isJumping=false;
                                isDead=true;
                            }
                        }
                        MainWindow.mainScene.setOnKeyPressed((KeyEvent event) -> {
                            if (event.getCode() == KeyCode.W  && !isJumping || event.getCode() == KeyCode.SPACE && !isJumping) {
                                dino.currentPose.imageProperty().set(dino.dinoIDLE);
                                isJumping = true;
                                final KeyValue[] keyValue = {new KeyValue(dino.currentPose.translateYProperty(), 220)};
                                final KeyFrame[] keyFrame = {new KeyFrame(Duration.seconds(0.6), keyValue[0])};
                                final Timeline[] timeline = {new Timeline(keyFrame[0])};
                                timeline[0].play();
                                timeline[0].setOnFinished(actionEvent -> {
                                    KeyValue value = new KeyValue(dino.currentPose.translateYProperty(), 220);
                                    KeyFrame frame = new KeyFrame(Duration.seconds(0.3), value);
                                    Timeline beat = new Timeline(frame);
                                    beat.play();
                                    beat.setOnFinished(action -> {
                                        keyValue[0] = new KeyValue(dino.currentPose.translateYProperty(), 310);
                                        keyFrame[0] = new KeyFrame(Duration.seconds(0.6), keyValue[0]);
                                        timeline[0] = new Timeline(keyFrame[0]);
                                        timeline[0].play();
                                        timeline[0].setOnFinished(actionE -> isJumping = false);
                                    });
                                });
                            }
                        });
                        double t = ((currentNanoTime - startNanoTime[0]) / 100000000.0);
                        if(t>2)
                        {
                            scoreNumb++;
                            startNanoTime[0] =System.nanoTime();
                            if(isPlay&&!isDead&&!isJumping)
                            {
                                if(dino.currentPose.imageProperty().get()==dino.dinoRUNR)
                                {
                                    dino.currentPose.imageProperty().set(dino.dinoRUNL);
                                }
                                else
                                {
                                    dino.currentPose.imageProperty().set(dino.dinoRUNR);
                                }
                            }
                        }
                    }
                }
                else
                {
                    dino.currentPose.imageProperty().set(dino.dinoDEAD);
                    MainWindow.speed=0;
                }
            }
        }.start();
    }
}