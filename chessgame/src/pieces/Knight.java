package pieces;
import main.Board;

import java.awt.image.BufferedImage;

public class Knight extends Piece{
    public Knight(Board board,int col,int row,boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col* board.tileSize;
        this.yPos=row* board.tileSize;
        this.isWhite=isWhite;
        this.name="Knight";
        this.sprite=sheet.getSubimage(3*sheetScale,isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);//his line of code retrieves a sub-image from a larger image, scales it to a specific size, and assigns the resulting image to a variable for use elsewhere in the program.
    }

    public boolean isValidMovement(int col,int row)
    {
        return Math.abs(col-this.col)==2&&Math.abs(row-this.row)==3||Math.abs(col-this.col)==3&&Math.abs(row-this.row)==2;

    }
    public boolean moveCollidesWithPiece(int col,int row)
    {
        return false;

    }
}