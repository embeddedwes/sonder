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

    public static int GRID_WIDTH, GRID_HEIGHT = 40;

    private Cell[GRID_WIDTH][GRID_HEIGHT] cells;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sonder (Game Of Life)");

        cells = new Cell[GRID_WIDTH][GRID_HEIGHT];

        Group root = new Group();
        Scene s = new Scene(root, 600, 600, Color.BLACK);

        final Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                gc.fillRect(i * 20, i * 20, 18, 18);
            }
        }

        root.getChildren().add(canvas);

        primaryStage.setScene(s);
        primaryStage.show();
    }
}
