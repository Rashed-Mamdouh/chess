package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{
    public Pawn(Board board, int col, int row, boolean isWhite) {
    super(board);
    this.col=col;
    this.row=row;
    this.xPos=col* board.tileSize;
    this.yPos=row* board.tileSize;
    this.isWhite=isWhite;
    this.name="Pawn";
    this.sprite=sheet.getSubimage(5*sheetScale,isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);//his line of code retrieves a sub-image from a larger image, scales it to a specific size, and assigns the resulting image to a variable for use elsewhere in the program.
}
    public boolean isValidMovement(int col, int row) {
        int colorIndex = isWhite ? 1 : -1;
        //push pawn one square forward
        if (this.col == col && row == this.row - colorIndex && board.getPiece(col, row) == null)
            return true;
        //push pawn two squares forward
        if (isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null && board.getPiece(col, row + colorIndex) == null)
            return true;
        //push pawn captures left
        if (col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;
        //push pawn captures right
        if (col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;
        //push pawn captures forward
        if (col == this.col&& row == this.row - colorIndex && board.getPiece(col, row) != null)
            return true;


        return false;
    }
}
