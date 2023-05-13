package pieces;
import main.Board;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Piece {
    public int col,row;
    public int xPos,yPos;
    public boolean isWhite;
    public String name;
    Board board;
    Image sprite;
    int value;

public boolean isFirstMove=true;
    BufferedImage sheet;//sheet contains the image of all pieces
     {

         try {
             sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
         }catch (IOException e) {
             e.printStackTrace();
         }
     }
    protected int sheetScale=sheet.getWidth()/6;
    public Piece(Board board){
        this.board=board;
    }

    public boolean isValidMovement(int col,int row)
    {
        return true;

    }
    public boolean moveCollidesWithPiece(int col,int row)//check if there are any pieces in the selected piece's way
    {
        return false;

    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public void paint (Graphics2D g2d){
        g2d.drawImage(sprite,xPos,yPos,null);
    }

}

