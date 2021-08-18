package io.github.jaron.othello;

public class Board {
    private int[][] state;

    private int width = 8;
    private int height = 8;

    public Board() {
        state = new int[8][8];
    }

    public int getPiece(int x, int y) {
        return (x >= 0 && x < width && y >= 0 & y < height) ? state[x][y] : 0;
    }

    public void setPiece(int x, int y, int color) {
        state[x][y] = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
