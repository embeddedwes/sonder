package com.sonder;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by wesley on 8/7/16.
 */

public class ResizableCanvas extends Canvas {

    private static final int CELL_SPACING = 1;

    public ResizableCanvas() {
        // Redraw canvas when size changes.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);

        gc.setFill(Color.WHITE);

        /* gc.setStroke(Color.RED);
        gc.strokeLine(0, 0, width, height);
        gc.strokeLine(0, height, width, 0);

       */
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                gc.fillRect(i * Cell.SIZE, i * Cell.SIZE, Cell.SIZE - CELL_SPACING, Cell.SIZE - CELL_SPACING);
            }
        }
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }
}
