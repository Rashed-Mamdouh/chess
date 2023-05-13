package main;

import pieces.Piece;

public class KingCheck {
    Board board;
    KingCheck(Board board){
        this.board=board;
    }
    public  boolean isKingChecked(Move move) {
        Piece king = board.findKing(move.piece.isWhite);
        assert king != null;
        int kingCol = king.col;
        int kingRow = king.row;
        if (board.selectedPeice != null && board.selectedPeice.name.equals("King")) {
            kingCol = move.newCol;
            kingRow = move.newRow;

        }


        return hitByRook(move.newCol, move.newRow, king, kingCol, kingRow, 0, 1) ||
                hitByRook(move.newCol, move.newRow, king, kingCol, kingRow, 1, 0) ||
                hitByRook(move.newCol, move.newRow, king, kingCol, kingRow, 0, -1) ||
                hitByRook(move.newCol, move.newRow, king, kingCol, kingRow, -1, 0) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||

                hitByََQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByََQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByََQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByََQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||

                hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByKing(king, kingCol, kingRow)||
                hitByBishopNewMove(king,kingCol,kingRow);

    }


    private boolean hitByBishopNewMove(Piece king,int kingCol,int kingRow){
        return  checkBishopNewMove(board.getPiece(kingCol-1,kingRow),king)||
                checkBishopNewMove(board.getPiece(kingCol+1,kingRow),king);
    }
    private boolean checkBishopNewMove(Piece piece,Piece king ){
        return piece!=null&&!board.sameTeam(piece,king)&&piece.name.equals("Bishop");

    }
    private boolean hitByRook(int col,int row,Piece king,int kingCol,int kingRow,int colVal,int rowVal){
        for(int i=1;i<8;i++){

            if(kingCol+(i*colVal)==col &&kingRow+(i*rowVal)==row){

                break;
            }
            Piece piece=board.getPiece(kingCol+(i*colVal) ,kingRow+(i*rowVal));
            if(piece!=null && piece!=board.selectedPeice){
                if(!board.sameTeam(piece,king)&&(piece.name.equals("Rook")||piece.name.equals("Queen") )){
                    return true;
                }
                break;

            }
        }
     return false;
    }

    private boolean hitByBishop(int col,int row,Piece king,int kingCol,int kingRow,int colVal,int rowVal){


        for(int i=1;i<4;i++){

            if(kingCol-(i*colVal)==col &&kingRow-(i*rowVal)==row){

                break;
            }
            Piece piece=board.getPiece(kingCol-(i*colVal) ,kingRow-(i*rowVal));
            if(piece!=null && piece!=board.selectedPeice){
                if(!board.sameTeam(piece,king)&&(piece.name.equals("Bishop") )){
                    return true;
                }


            }
        }
        return false;
    }
    private boolean hitByََQueen(int col,int row,Piece king,int kingCol,int kingRow,int colVal,int rowVal){
        for(int i=1;i<8;i++){

            if(kingCol-(i*colVal)==col &&kingRow-(i*rowVal)==row){

                break;
            }
            Piece piece=board.getPiece(kingCol-(i*colVal) ,kingRow-(i*rowVal));
            if(piece!=null && piece!=board.selectedPeice){
                if(!board.sameTeam(piece,king)&&piece.name.equals("Queen") ){
                    return true;
                }
                break;

            }
        }
        return false;
    }
    private boolean hitByKnight(int col,int row,Piece king,int kingCol,int kingRow){
        return checkKinght(board.getPiece(kingCol-2,kingRow-3),king,col,row) ||
        checkKinght(board.getPiece(kingCol+2,kingRow-3),king,col,row)||
        checkKinght(board.getPiece(kingCol+3,kingRow-2),king,col,row)||
        checkKinght(board.getPiece(kingCol-3,kingRow+2),king,col,row)||
        checkKinght(board.getPiece(kingCol+3,kingRow+2),king,col,row)||
        checkKinght(board.getPiece(kingCol-2,kingRow+3),king,col,row)||
        checkKinght(board.getPiece(kingCol+2,kingRow+3),king,col,row)||
        checkKinght(board.getPiece(kingCol-3,kingRow-2),king,col,row);
    }
    private boolean checkKinght(Piece piece,Piece king ,int col,int row){

        return piece!=null&&!board.sameTeam(piece,king)&&piece.name.equals("Knight");

    }

    private boolean hitByKing(Piece king,int kingCol,int kingRow){
        return checkKing(board.getPiece(kingCol-1,kingRow-1),king)||
                checkKing(board.getPiece(kingCol+1,kingRow-1),king)||
                checkKing(board.getPiece(kingCol,kingRow-1),king)||
                checkKing(board.getPiece(kingCol-1,kingRow),king)||
                checkKing(board.getPiece(kingCol+1,kingRow),king)||
                checkKing(board.getPiece(kingCol-1,kingRow+1),king)||
                checkKing(board.getPiece(kingCol+1,kingRow+1),king)||
                checkKing(board.getPiece(kingCol,kingRow+1),king);
    }
    private boolean checkKing(Piece piece,Piece king ){
        return piece!=null&&!board.sameTeam(piece,king)&&piece.name.equals("King");

    }
    private boolean hitByPawn(int col,int row,Piece king,int kingCol,int kingRow){
        int colorVal=king.isWhite ? -1:1;
        return checkPawn(board.getPiece(kingCol+1,kingRow+colorVal),king,col,row)||
         checkPawn(board.getPiece(kingCol,kingRow+colorVal),king,col,row)||
                checkPawn(board.getPiece(kingCol-1,kingRow+colorVal),king,col,row);

    }
    private boolean checkPawn(Piece piece,Piece king,int col,int row){
        return piece!=null&&!board.sameTeam(piece,king)&&piece.name.equals("Pawn");
    }


}
