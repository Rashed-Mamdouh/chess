package main;

import pieces.Piece;

public class Move {
    int oldCol;
    int oldRow;
    int newCol;
    int newRow;
    Piece piece;
    Piece capture;
    public Move(Board board, Piece piece, int newCol, int newRow){
        this.newCol=newCol;
        this.newRow=newRow;
        this.piece=piece;
        this.oldCol=piece.col;
        this.oldRow=piece.row;
        this.capture=board.getPiece(newCol,newRow);

    }

}
