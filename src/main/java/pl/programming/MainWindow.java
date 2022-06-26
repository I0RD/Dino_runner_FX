package pl.programming;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.programming.environment.Land;

public class MainWindow extends Application {
    public Scene mainScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dino runner FX");
        primaryStage.setResizable(false);
        primaryStage.setHeight(400);
        primaryStage.setWidth(700);
        Land lands=new Land();
        mainScene=new Scene(lands.ground,400,700,Color.web("#f7f7f7"));

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    public static void main(String[] args) {Application.launch(args);}
}