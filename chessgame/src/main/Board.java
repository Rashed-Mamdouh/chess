package main;
import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    int cols=8;
    int rows=8;
    public int tileSize=85;
    ArrayList<Piece>pieceList=new ArrayList<>();
    public Piece selectedPeice;
    Input input=new Input(this);
    public KingCheck checkScanner=new KingCheck(this);

    Board()  {
        this.setPreferredSize(new Dimension(cols*tileSize,rows*tileSize));
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
        addPieces();
        endgame();

    }
    private void moveKing(Move move){
        if(Math.abs(move.piece.col - move.newCol)==2){
            Piece rook;
            if(move.piece.col<move.newCol){
                rook=getPiece(7,move.piece.row);
                rook.col=5;

            }else{
                rook=getPiece(0,move.piece.row);
                rook.col=3;
            }
            rook.xPos=rook.col*tileSize;
        }

    }
    public Piece getPiece(int col,int row){

        for(Piece piece:pieceList){
            if(piece.col==col && piece.row==row){


                return piece;

            }
        }
        return null;
    }

    public void makeMove(Move move){
        if(move.piece.name.equals("King")) {
        moveKing(move);
        }
        move.piece.col=move.newCol;
        move.piece.row=move.newRow;
        move.piece.xPos=move.newCol*tileSize;
        move.piece.yPos=move.newRow*tileSize;
        capture(move.capture);
        move.piece.isFirstMove=false;
    }
    public void capture(Piece piece){
        pieceList.remove(piece);
    }
    public boolean isValidMove(Move move){
        if(sameTeam(move.piece,move.capture))
            return false;
        if(!move.piece.isValidMovement(move.newCol,move.newRow))
            return false;
        if(move.piece.moveCollidesWithPiece(move.newCol,move.newRow))
            return false;
        if(checkScanner.isKingChecked(move))return false;
        return true;
    }
    public boolean sameTeam(Piece p1,Piece p2){
        if(p1==null ||p2==null)
        return false;
        return p1.isWhite==p2.isWhite;


    }
    Piece findKing(boolean isWhite){
        for(Piece piece:pieceList){
            if(piece.isWhite==isWhite &&piece.name.equals("King"))return piece;
        }
        return null;

    }
    public void endgame(){
        King whiteKing=(King)findKing(true);
        King blackKing=(King)findKing(false);
        if(whiteKing.hasEscapeMoves()) System.out.println("white loses");
        if(blackKing.hasEscapeMoves()) System.out.println("black loses");

    }
    public void addPieces()  {
        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new King(this,4,0,false));
        pieceList.add(new Queen(this,3,0,false));
        pieceList.add(new Rook(this,7,0,false));
        pieceList.add(new Rook(this,0,0,false));

        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));

        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));

        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Knight(this,6,7,true));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new Bishop(this,5,7,true));
        pieceList.add(new King(this,4,7,true));
        pieceList.add(new Queen(this,3,7,true));
        pieceList.add(new Rook(this,7,7,true));
        pieceList.add(new Rook(this,0,7,true));


    }
    public void paintComponent(Graphics g ){
        Graphics2D g2d=(Graphics2D)g;
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++){
                if((c+r)%2==0)
                g2d.setColor(new Color(222, 106, 0, 255));
                else
                    g2d.setColor(new Color(218, 187, 164));
                g2d.fillRect(c*tileSize,r*tileSize,tileSize,tileSize);

            }
            if(selectedPeice!=null)
                for(int x=0;x<rows;x++)
                    for(int c=0;c<cols;c++){
                        if(isValidMove(new Move(this,selectedPeice,c,x))){
                            g2d.setColor(new Color(68,180,57,190));
                            g2d.fillRect(c*tileSize,x*tileSize,tileSize,tileSize);
                        }
                    }



        for(Piece piece: pieceList){
            piece.paint(g2d);//this is a function in Piece class that draw
        }
    }




   /* Spot [][] boardSpots=new Spot[8][8];
    String imgpath;
    main.Board(){
     ;

        this.setSize(1280, 1024);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int i;
        int j;
        this.getContentPane().setBackground(Color.pink);





        for( i=0;i<8;i++){
            for( j=0;j<8;j++) {
                boardSpots[i][j]=new Spot();
                if(i%2==0){
                    if(j%2==0){boardSpots[i][j].setBackground(Color.gray);}
                    else{boardSpots[i][j].setBackground(new Color(0xF5F5DC));}

                }
                else{
                    if(j%2==0) {boardSpots[i][j].setBackground(new Color(0xF5F5DC));}
                    else{boardSpots[i][j].setBackground(Color.gray);}
            }

                if(i==0||i==1||i==6||i==7){
                boardSpots[i][j].isEmpty=false;
                }
                else{boardSpots[i][j].isEmpty=true;
                }
                boardSpots[i][j].setBounds(120*j,120*i,120,120);

                boardSpots[i][j].x=j;
                boardSpots[i][j].y=i;





                this.add(boardSpots[i][j]);




            }
        }


        DragPanel blackRook=new DragPanel("blackrook.png");
        ImageIcon icon=new ImageIcon("blackrook.png");
        JLabel blackRookl=new JLabel();
        blackRookl.setIcon(icon);
        blackRook.setBounds(0,0,50,50);
        boardSpots[0][0].add(blackRook);


        boardSpots[0][0].setLayout(null);

        this.setVisible(true);

    }
*/


}
