package com.sonder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by wesley on 8/8/16.
 */
public class Grid {

    private static final int SIZE = 100;

    public Cell[][] cells;

    public Grid() {
        cells = new Cell[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }

        setPush(20, 20);
        setPush(40, 40);
        setPush(60, 60);
    }

    public void setPush(int i, int j) {
        cells[i-1][j].alive = true;
        cells[i][j].alive = true;
        cells[i+1][j].alive = true;
        cells[i][j-1].alive = true;
        cells[i+1][j-1].alive = true;
    }

    public void update() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cells[i][j].update(this, cells, i, j);
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

    public int getLivingNeighbors(int x, int y)
    {
        int count = 0;

        // Check cell on the right.
        if (x != SIZE - 1)
            if (cells[x + 1][y].alive)
        count++;

        // Check cell on the bottom right.
        if (x != SIZE - 1 && y != SIZE - 1)
            if (cells[x + 1][y + 1].alive)
        count++;

        // Check cell on the bottom.
        if (y != SIZE - 1)
            if (cells[x][y + 1].alive)
        count++;

        // Check cell on the bottom left.
        if (x != 0 && y != SIZE - 1)
            if (cells[x - 1][y + 1].alive)
        count++;

        // Check cell on the left.
        if (x != 0)
            if (cells[x - 1][y].alive)
        count++;

        // Check cell on the top left.
        if (x != 0 && y != 0)
            if (cells[x - 1][y - 1].alive)
        count++;

        // Check cell on the top.
        if (y != 0)
            if (cells[x][y - 1].alive)
        count++;

        // Check cell on the top right.
        if (x != SIZE - 1 && y != 0)
            if (cells[x + 1][y - 1].alive)
        count++;

        return count;
    }
}
