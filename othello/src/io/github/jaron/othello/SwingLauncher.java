package io.github.jaron.othello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class uses a builder patter to launch a swing UI to
 * test your AI.
 *
 * @see
 */
public class SwingLauncher {

    public static final int PLAYER_COLOR = 1;
    public static final int COMPUTER_COLOR = 2;

    public static void main(String[] args) {
        new SwingLauncher()
                .run();
    }

    /**
     * Launches the JFrame that contains the BoardPanel to display the game.
     */
    public void run() {

        Game game = new Game();
        game.init();


        BoardPanel boardPanel = new BoardPanel(game.getBoard());

        boardPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / 50;
                int y = e.getY() / 50;

                System.out.println(x + "," + y);
                if ( game.getBoard().getPiece(x,y) == 0) {
                    game.playPiece(x,y);
                    game.increment();
                } else {
                    System.out.println("ALREADY TAKEN!!!!!");
                }
                boardPanel.repaint();

            }
        });

//        JPanel statusPanel = new JPanel(new BorderLayout());
//        JTextField status = new JTextField("Your turn player 1...");
//        status.setEditable(false);
//        statusPanel.add(status, BorderLayout.CENTER);
//        JButton undo = new JButton("<");
//        undo.addActionListener((ActionEvent e) -> SwingUtilities.invokeLater(() -> board.undo()));
//        statusPanel.add(undo, BorderLayout.EAST);

        JFrame frame = new JFrame("Othello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.add(boardPanel, BorderLayout.CENTER);
//        frame.add(statusPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}