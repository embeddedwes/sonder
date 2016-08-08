package com.sonder;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
        primaryStage.setTitle("Sonder (Game Of Life)");

        StackPane root = new StackPane();
        Scene s = new Scene(root, 800, 600, Color.WHITE);

        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        primaryStage.setScene(s);
        primaryStage.show();

        Grid grid = new Grid();
        Grid nextGrid = new Grid();

        new AnimationTimer()
        {
            int i = 0;

            public void handle(long currentNanoTime)
            {
                i++;

                if(i % 60 == 0) {
                    gc.setFill(Color.WHITE);
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    //nextGrid.update(grid);
                    //grid.cells = nextGrid.cells;
                    grid.update();
                    grid.draw(gc);
                }
            }
        }.start();
    }
}
