package io.github.jaron.othello;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {


    private Color BOARD_COLOR = Color.GREEN.darker().darker();

    protected Dimension defaultDimension;

    private Color[] COLORS = {Color.WHITE, Color.GRAY, Color.BLACK};

    private Board board;

    public BoardPanel(Board board) {
        this.board = board;
        this.defaultDimension = new Dimension(board.getWidth() * 50 - 5, board.getHeight() * 50 - 5);
    }

    @Override
    public Dimension getPreferredSize() {
        return defaultDimension;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.darkGray);
        //First paint the board, which is an 8x8 of squares

        for (int x = 0, width = board.getWidth(); x < width; x++) {
            for (int y = 0, height = board.getHeight(); y < height; y++) {

                g.setColor(BOARD_COLOR);
                g.fillRoundRect(x * 50, y * 50, 45, 45, 5, 5);

                int color = board.getPiece(x, y);
                if (color != 0) {
                    g.setColor(COLORS[color + 1]);
                    g.fillRoundRect(x * 50 + 3, y * 50 + 3, 39, 39, 35, 35);
                }
            }
        }
    }
}
