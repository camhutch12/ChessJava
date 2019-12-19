import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pawn extends Piece {

    private Image image;

    private List<String> whiteToBeQueen;
    private List<String> blackToBeQueen;


    public List<String> getWhiteToBeQueen() {
        return whiteToBeQueen;
    }

    public void setWhiteToBeQueen(List<String> whiteToBeQueen) {
        this.whiteToBeQueen = whiteToBeQueen;
    }

    public List<String> getBlackToBeQueen() {
        return blackToBeQueen;
    }

    public void setBlackToBeQueen(List<String> blackToBeQueen) {
        this.blackToBeQueen = blackToBeQueen;
    }

    Pawn(String name, String color, String location) {
        super(name, color, location);
        whiteToBeQueen = new ArrayList<>();
        blackToBeQueen = new ArrayList<>();
        setupImage(file);
        //setupForPawnToQueenLists();


    }

    public void setupForPawnToQueenLists() {
        for (int i = 0; i < this.board.length; i++) {
            this.whiteToBeQueen.add(this.board[0][i]);
            this.blackToBeQueen.add(this.board[7][i]);
        }
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-pawn.png" : "black-pawn.png";
        loadImage(this.file);
    }

    @Override
    public void findRoute(King king, String locationForKing) {
        this.routeToCheck.clear();


        if (this.color.equals("white")) {
           helperFindRoute(king.location,Piece.allPiecesOnBoard,king);
        } else if (this.color.equals("black")) {
           helperFindRoute(king.location,Piece.allPiecesOnBoard,king);

        }
    }

    public void helperFindRoute(String location, List<Piece> oppentList, King king){
        int row = this.row;
        int col = this.col;
        Piece oppent = null;
        Piece oppent2 = null;
        String currentSpotChecking = "";
        String currentSpotChecking2 = "";
        boolean noPieceInWay1 = true;
        boolean noPieceInWay2 = true;

        int value = 1;
        int value2 = 2;
        if (this.color.equals("white")) {
            value *= -1;
            value2 *= -1;
        }

        if (this.color.equals("black")) {
            if (this.row + 1 > -1 && this.row + 1 < 8 && this.col + 1 > -1 && this.col + 1 < 8) {
                currentSpotChecking = this.board[row + 1][col + 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location
                    if (piece.location.equals(currentSpotChecking)) {
                        this.routeToCheck.add(currentSpotChecking);
                        break;
                    }

                }

            }

            if (this.routeToCheck.contains(king.location)){
                return;
            }
            else {
                this.routeToCheck.clear();
            }
            if (this.row + 1 > -1 && this.row + 1 < 8 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking2 = this.board[row + 1][col - 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location

                    if (piece.location.equals(currentSpotChecking2)) {
                        this.routeToCheck.add(currentSpotChecking2);
                        break;

                    }
                }
            }


            if (this.routeToCheck.contains(king.location)){
                return;
            }
            else {
                this.routeToCheck.clear();
            }

        } else if (this.color.equals("white")) {

            if (this.row - 1 > -1 && this.row - 1 < 8 && this.col + 1 > -1 && this.col + 1 < 8) {
                currentSpotChecking2 = this.board[row - 1][col + 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location

                    if (piece.location.equals(currentSpotChecking2)) {
                        this.routeToCheck.add(currentSpotChecking2);
                        break;
                    }
                }

            }
            if (this.routeToCheck.contains(king.location)){
                return;
            }
            else {
                this.routeToCheck.clear();
            }
            if (this.row - 1 > -1 && this.row - 1 < 8 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking = this.board[row - 1][col - 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location
                    if (piece.location.equals(currentSpotChecking)) {
                        this.routeToCheck.add(currentSpotChecking);
                        break;
                    }

                }
            }
            if (this.routeToCheck.contains(king.location)){
                return;
            }
            else {
                this.routeToCheck.clear();
            }

        }



        this.checkPieces();
        System.out.println();




    }

    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.canAttack.clear();

        if (this.color.equals("white")) {
            helperAvailableMoves(Piece.whitePiecesOnBoard, Piece.blackPiecesOnBoard);
        } else if (this.color.equals("black")) {
            helperAvailableMoves(Piece.blackPiecesOnBoard, Piece.whitePiecesOnBoard);
        }


    }



    private void helperAvailableMoves(java.util.List<Piece> colorList, List<Piece> oppentList) {

        int row = this.row;
        int col = this.col;
        Piece oppent = null;
        Piece oppent2 = null;
        String currentSpotChecking = "";
        String currentSpotChecking2 = "";
        String finalCurrentSpotChecking;
        String finalCurrentSpotChecking2 = null;
        boolean noPieceInWay1 = true;
        boolean noPieceInWay2 = true;

        int value = 1;
        int value2 = 2;
        if (this.color.equals("white")) {
            value *= -1;
            value2 *= -1;
        }


        if (this.turn == 0) {
            if (this.row + value > -1 && this.row + value < 8) {
                currentSpotChecking = this.board[row + value][col];
                for (Piece piece : this.getAllPiecesOnBoard()) {
                    if (piece.location.equals(currentSpotChecking)) {
                        noPieceInWay1 = false;
                        noPieceInWay2 = false;
                    }

                }


            }
            if (this.row + value2 > -1 && this.row + value2 < 8) {
                currentSpotChecking2 = this.board[row + value2][col];
                for (Piece piece : this.getAllPiecesOnBoard()) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        noPieceInWay2 = false;
                    }
                }

            }

            // This is check if there is a white peice in the location

            if (noPieceInWay1) {
                this.availableLocation.add(currentSpotChecking);
                noPieceInWay1 = true;
            }
            if (noPieceInWay2) {
                noPieceInWay2 = true;
                this.availableLocation.add(currentSpotChecking2);

            }

        }
        // if the turn is not equal to zero
        else {
            if (this.row + value > -1 && this.row + value < 8) {
                currentSpotChecking = this.board[row + value][col];

                for (Piece piece : getAllPiecesOnBoard()) {
                    if (piece.location.equals(currentSpotChecking)) {
                        noPieceInWay1 = false;
                    }
                }

                if (noPieceInWay1) {
                    this.availableLocation.add(currentSpotChecking);
                    noPieceInWay1 = true;
                }


            }


        }


        if (this.color.equals("black")) {
            if (this.row + 1 > -1 && this.row + 1 < 8 && this.col + 1 > -1 && this.col + 1 < 8) {
                currentSpotChecking = this.board[row + 1][col + 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location
                    if (piece.location.equals(currentSpotChecking)) {
                        this.availableLocation.add(currentSpotChecking);

                    }

                }

            }
            if (this.row + 1 > -1 && this.row + 1 < 8 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking2 = this.board[row + 1][col - 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location

                    if (piece.location.equals(currentSpotChecking2)) {
                        this.availableLocation.add(currentSpotChecking2);

                    }
                }
            }


            //En Pasant
            if (this.row == 4 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking = this.board[4][col - 1];
                currentSpotChecking2 = this.board[4][col + 1];
                for (Piece piece : oppentList) {
                    char[] n = piece.name.toCharArray();
                    char[] copy = Arrays.copyOf(n, 4);
                    String nam = String.valueOf(copy);
                    System.out.println("nam = " + nam);
                    if (nam.equals("Pawn") && piece.location.equals(currentSpotChecking) && piece.turn == 1) {
                        this.availableLocation.add(this.board[5][col - 1]);
                    }
                    if (nam.equals("Pawn") && piece.location.equals(currentSpotChecking2) && piece.turn == 1) {
                        this.availableLocation.add(this.board[5][col + 1]);
                    }
                }
            }

        } else if (this.color.equals("white")) {

            if (this.row - 1 > -1 && this.row - 1 < 8 && this.col + 1 > -1 && this.col + 1 < 8) {
                currentSpotChecking2 = this.board[row - 1][col + 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location

                    if (piece.location.equals(currentSpotChecking2)) {
                        this.availableLocation.add(currentSpotChecking2);

                    }
                }

            }

            if (this.row - 1 > -1 && this.row - 1 < 8 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking = this.board[row - 1][col - 1];
                for (Piece piece : oppentList) {

                    // this means that there is a piece on that location
                    if (piece.location.equals(currentSpotChecking)) {
                        this.availableLocation.add(currentSpotChecking);

                    }

                }
            }

            //En Pasant
            if (this.row == 3 && this.col - 1 > -1 && this.col - 1 < 8) {
                currentSpotChecking = this.board[3][col - 1];
                currentSpotChecking2 = this.board[3][col + 1];
                for (Piece piece : oppentList) {
                    char[] n = piece.name.toCharArray();
                    char[] copy = Arrays.copyOf(n, 4);
                    String nam = String.valueOf(copy);
                    System.out.println("nam = " + nam);
                    if (nam.equals("Pawn") && piece.location.equals(currentSpotChecking) && piece.turn == 1) {
                        this.availableLocation.add(this.board[2][col - 1]);
                    }
                    if (nam.equals("Pawn") && piece.location.equals(currentSpotChecking2) && piece.turn == 1) {
                        this.availableLocation.add(this.board[2][col + 1]);
                    }
                }
            }


            this.checkPieces();
            System.out.println();


        }
    }



    public Piece pawnToQueen() {
        if (this.color.equals("white")) {
            if (this.whiteToBeQueen.contains(this.location)) {
                Queen q = new Queen("queen", this.color, this.location);
                return q;

            } else return this;
        } else if (this.color.equals("black")) {
            if (this.blackToBeQueen.contains(this.location)) {
                Queen q = new Queen("queen", this.color, this.location);
                return q;
            } else return this;
        }
        return this;

    }


}


