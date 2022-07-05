package pl.programming;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.programming.environment.*;

public class MainWindow extends Application {
    public static Scene mainScene;
    public static double speed=60;
    public static Canvas canvas=new Canvas(700,400);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        GameManager gameManager=new GameManager();
        primaryStage.setTitle("Dino runner FX");
        primaryStage.setResizable(false);
        primaryStage.setHeight(400);
        primaryStage.setWidth(700);
        new Land();
        root.getChildren().add(gameManager.enemyManager.enemyBox);
        root.getChildren().add(canvas);
        canvas.toBack();
        mainScene = new Scene(root, Color.web("#f7f7f7"));
        primaryStage.setScene(mainScene);
        root.getChildren().add(new GameManager().dino.dinoBox);
        root.getChildren().add(new Sun().sunBox);
        root.getChildren().add(new Clouds().cloudsBox);
        gameManager.game();
        primaryStage.show();
    }
    public static void main(String[] args) {Application.launch(args);}
}