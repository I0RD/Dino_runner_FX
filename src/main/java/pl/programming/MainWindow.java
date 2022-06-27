package pl.programming;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.programming.environment.Clouds;
import pl.programming.environment.Land;
import pl.programming.environment.Sun;

public class MainWindow extends Application {
    public Scene mainScene;
    private double speed=1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Dino runner FX");
        primaryStage.setResizable(false);
        primaryStage.setHeight(400);
        primaryStage.setWidth(700);
        Land land = new Land();
        Label label = new Label("AA");
        root.getChildren().add(land.canvas);
        mainScene = new Scene(root, Color.web("#f7f7f7"));
        primaryStage.setScene(mainScene);
        Sun sun=new Sun();
        root.getChildren().add(sun.sunBox);
        Clouds clouds=new Clouds();
        root.getChildren().add(clouds.cloudsBox);
        final long[] startNanoTime = {System.nanoTime()};
        new AnimationTimer() {
            public void handle ( long currentNanoTime){
                double t = ((currentNanoTime - startNanoTime[0]) / 100000000)*speed;
                System.out.println(t);
                land.update(t);
                if(t>71)
                {
                    startNanoTime[0] = System.nanoTime();
                    speed+=0.5;
                }
            }
        }.start();
        primaryStage.show();
    }
    public static void main(String[] args) {Application.launch(args);}
}