package com.sonder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by austin on 8/7/2016.
 */
public class Cell {

    public boolean alive;

    public Cell() {
        alive = false;
    }

    public void update(Grid grid, Cell[][] cells, int i, int j) {
        int count = grid.getLivingNeighbors(i, j);
        boolean result = false;

        // Apply the rules and set the next state.
        if (alive && count < 2)
            result = false;
        if (alive && (count == 2 || count == 3))
            result = true;
        if (alive && count > 3)
            result = false;
        if (!alive && count == 3)
            result = true;

        cells[i][j].alive = result;
    }

    public void draw(GraphicsContext gc, int i, int j) {
        if(alive) gc.setFill(Color.BLACK);
        else gc.setFill(Color.WHITE);

        gc.fillRect(i * 5 + 1, j * 5 + 1, 4, 4);
    }


}
