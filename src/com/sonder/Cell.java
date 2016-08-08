package com.sonder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by austin on 8/7/2016.
 */
public class Cell {

    public boolean alive;

    public Cell() {
        alive = true;
    }

    public void update(Cell[][] cells, int i, int j) {
        
    }

    public void draw(GraphicsContext gc, int i, int j) {
        if(alive) gc.setFill(Color.BLACK);
        else gc.setFill(Color.WHITE);

        gc.fillRect(i * 20 + 1, j * 20 + 1, 19, 19);
    }
}
