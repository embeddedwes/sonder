package com.sonder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by wesley on 8/8/16.
 */
public class Grid {

    private static final int SIZE = 20;

    private Cell[][] cells;

    public Grid() {
        cells = new Cell[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void update() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cells[i][j].update(cells, i, j);
            }
        }
    }

    public void draw(GraphicsContext gc) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].draw(gc, i, j);
            }
        }
    }
}
