package pl.programming;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.programming.environment.*;

public class MainWindow extends Application {
    public Scene mainScene;
    public static double speed=60;
    public static Canvas canvas=new Canvas(700,400);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Dino runner FX");
        primaryStage.setResizable(false);
        primaryStage.setHeight(400);
        primaryStage.setWidth(700);
        new Land();
        new Enemy();
        root.getChildren().add(canvas);
        mainScene = new Scene(root, Color.web("#f7f7f7"));
        primaryStage.setScene(mainScene);
        new Dino();
        new Sun();
        new Clouds();
        primaryStage.show();
    }
    public static void main(String[] args) {Application.launch(args);}
}