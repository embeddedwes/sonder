package com.sonder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by wesley on 8/7/16.
 */
public class Sonder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Group root = new Group();
        Scene s = new Scene(root, 300, 300, Color.BLACK);

        final Canvas canvas = new Canvas(250,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //gc.setFill(Color.BLUE);
        //gc.fillRect(75,75,100,100);

        gc.setFill(Color.WHITE);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                gc.fillRect(i * 20 + 1, i * 20 + 1, 18, 18);
            }
        }

        root.getChildren().add(canvas);

        primaryStage.setScene(s);
        primaryStage.show();
    }
}
