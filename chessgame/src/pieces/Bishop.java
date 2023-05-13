package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{
    public Bishop(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col* board.tileSize;
        this.yPos=row* board.tileSize;
        this.isWhite=isWhite;
        this.name="Bishop";
        this.sprite=sheet.getSubimage(2*sheetScale,isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);//his line of code retrieves a sub-image from a larger image, scales it to a specific size, and assigns the resulting image to a variable for use elsewhere in the program.
    }
    public boolean isValidMovement(int col,int row)
    {

        return Math.abs(this.col - col) == Math.abs(this.row - row) && Math.abs(this.col - col) <= 3 || Math.abs(this.col - col) == 1 && Math.abs(this.row - row) == 0;
    }
/*    public boolean moveCollidesWithPiece(int col,int row)
    {

        if(this.col>col)
            for(int c=this.col-1;c>col;c--)
                if(board.getPiece(c,this.row)!=null)return true;

        if(this.col<col)
            for(int c=this.col+1;c<col;c++)
                if(board.getPiece(c,this.row)!=null)return true;


        if(this.row>row)
            for(int r=this.row-1;r>row;r--)
                if(board.getPiece(this.col,r)!=null)return true;

        if(this.row<row)
            for(int r=this.row+1;r<row;r++)
                if(board.getPiece(this.col,r)!=null)return true;
        return false;


    }*/
}
