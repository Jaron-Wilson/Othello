package io.github.jaron.othello;

import java.awt.*;

public class Game {

    private int PLAYER_WHITE = -1;
    private int PLAYER_BLACK = 1;

    int turn = -1;
    private Board board;

    public void init() {
        board = new Board();
        board.setPiece(3, 3, -1);
        board.setPiece(4, 4, -1);

        board.setPiece(3, 4, 1);
        board.setPiece(4, 3, 1);
    }

    public Game increment() {
        turn = (turn == PLAYER_WHITE) ? PLAYER_BLACK : PLAYER_WHITE;
        return this;
    }

    public int getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public void playPiece(int x, int y) {
        board.setPiece(x, y, getTurn());
        flip(x,y, getTurn());
    }


    public void flip(int x, int y, int myColor) {

        int opponentColor = myColor*-1;

        // Horizontal First to the right
        int opponentCount = 0;
/*        for (int deltaX = x+1; deltaX < 8 && deltaX >=0; deltaX++) {
            int piece = board.getPiece(deltaX,y);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", deltaX, y));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", deltaX, y));
                //We need to flip the pieces
                for(int i=deltaX-1; opponentCount>0; i-=1, opponentCount--){
                    board.setPiece(i,y,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", i, y));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", deltaX, y));
                break;
            }
        }

        // Horizontal First to the left
        opponentCount = 0;
        for (int deltaX = x-1; deltaX < 8 && deltaX >=0; deltaX--) {
            int piece = board.getPiece(deltaX,y);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", deltaX, y));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", deltaX, y));
                //We need to flip the pieces
                for(int i=deltaX+1; opponentCount>0; i+=1, opponentCount--){
                    board.setPiece(i,y,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", i, y));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", deltaX, y));
                break;
            }
        }

        // vertical First bottom to top
         opponentCount = 0;
        for (int deltaY = y+1; deltaY < 8 && deltaY >=0; deltaY++) {
            int piece = board.getPiece(x,deltaY);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", x,deltaY ));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", x, deltaY));
                //We need to flip the pieces
                for(int i=deltaY-1; opponentCount>0; i-=1, opponentCount--){
                    board.setPiece(x,i,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", x, i));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", x, deltaY));
                break;
            }
        }

        // vertical First top to bottom
        for (int deltaY = y-1; deltaY < 8 && deltaY >=0; deltaY--) {
            int piece = board.getPiece(x,deltaY);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", x, deltaY));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", x, deltaY));
                //We need to flip the pieces
                for(int i=deltaY+1; opponentCount>0; i+=1, opponentCount--){
                    board.setPiece(x,i,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", x, i));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", x, deltaY));
                break;
            }
        }
        // diagonal top bottom
             opponentCount = 0;
        for (int deltaX = x+1, deltaY = y+1; deltaY < 8 && deltaY >=0 && deltaX < 8 && deltaX >=0; deltaX++, deltaY++){
            int piece = board.getPiece(deltaX,deltaY);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", deltaX,deltaY ));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", deltaX, deltaY));
                //We need to flip the pieces
                for(int xi=deltaX-1, yi=deltaY-1; opponentCount>0; xi -= 1, yi-=1, opponentCount--){
                    board.setPiece(xi,yi,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", xi, yi));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", deltaX, deltaY));
                break;
            }
        }*/

        // diagonal top bottom
        opponentCount = 0;
        for (int deltaX = x-1, deltaY = y-1; deltaY < 8 && deltaY >=0 && deltaX < 8 && deltaX >=0; deltaX++, deltaY++){
            int piece = board.getPiece(deltaX,deltaY);
            if( piece == opponentColor){
                opponentCount++;
                System.out.println(String.format("FOUND OPPONENT PIECE (%d,%d)", deltaX,deltaY ));
            } else if (piece == myColor ) {
                System.out.println(String.format("FOUND **YOUR** PIECE (%d,%d)", deltaX, deltaY));
                //We need to flip the pieces
                for(int xi=deltaX-1, yi=deltaY-1; opponentCount>0; xi -= 1, yi +=1, opponentCount--){
                    board.setPiece(xi,yi,myColor);
                    System.out.println(String.format("FLIP (%d,%d)", xi, yi));
                }
            } else { //It is empty
                System.out.println(String.format("FOUND ***NO*** PIECE (%d,%d)", deltaX, deltaY));
                break;
            }
        }

    }
}