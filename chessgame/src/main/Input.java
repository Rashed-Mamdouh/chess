package main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {
    Board board;
    Input(Board board){
        this.board=board;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int col=e.getX()/ board.tileSize;
        int row=e.getY()/ board.tileSize;
        Piece pieceXY=board.getPiece(col,row);
        if(pieceXY!=null)board.selectedPeice=pieceXY;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(board.selectedPeice!=null){
            board.selectedPeice.xPos=e.getX()- board.tileSize/2;
            board.selectedPeice.yPos=e.getY()- board.tileSize/2;
            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col=e.getX()/ board.tileSize;
        int row=e.getY()/ board.tileSize;
        if(board.selectedPeice!=null){
            Move move=new Move(board,board.selectedPeice,col,row);
            if(board.isValidMove(move)){
                board.makeMove(move);
            }else{
                board.selectedPeice.xPos=board.selectedPeice.col* board.tileSize;
                board.selectedPeice.yPos=board.selectedPeice.row* board.tileSize;
            }
        }
        board.selectedPeice=null;
        board.repaint();

    }






}
