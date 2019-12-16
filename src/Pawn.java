import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pawn extends Piece {

    private Image image;
    private int turn;


    Pawn(String name, String color, String location) {
        super(name, color, location);
        setupImage(file);


    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-pawn.png" : "black-pawn.png";
        loadImage(this.file);
    }

    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.canAttack.clear();
        if (this.location.equals("e5"))
            System.out.println();
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
        AtomicBoolean moveOne = new AtomicBoolean(true);
        AtomicBoolean moveTwo = new AtomicBoolean(true);
        AtomicBoolean oppentNorthWest = new AtomicBoolean(true);
        AtomicBoolean oppentP2 = new AtomicBoolean(true);
        int value = 1;
        int value2 = 2;
        if (this.color.equals("white")) {
            value *= -1;
            value2 *= -1;
        }

            try {
                if (moveOne.get() && oppentNorthWest.get() && moveTwo.get()) {
                    currentSpotChecking = this.board[row + value][col];
                    currentSpotChecking2 = this.board[row + value2][col];

                    String finalCurrentSpotChecking = currentSpotChecking;
                    String finalCurrentSpotChecking2 = currentSpotChecking2;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            moveOne.set(false);
                        }
                        if (piece.location.equals(finalCurrentSpotChecking2)) {
                            moveTwo.set(false);
                        }
                    }));
                }
                if (oppentNorthWest.get() && moveOne.get()) {

                    if (this.color.equals("black")) {
                        currentSpotChecking = this.board[row + value][col + value];
                        currentSpotChecking2 = this.board[row + 1][col - 1];
                    } else if (this.color.equals("white")) {
                        currentSpotChecking2 = this.board[row - 1][col + 1];

                    }


                    String finalCurrentSpotChecking = currentSpotChecking;
                    String finalCurrentSpotChecking2 = currentSpotChecking2;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentNorthWest.set(false);
                        }
                        if (piece.location.equals(finalCurrentSpotChecking2)) {
                            oppent2 = piece;
                            oppentP2.set(false);

                        }
                    }
                }
                if (moveOne.get() && oppentNorthWest.get()) {
                    this.availableLocation.add(this.board[row + value][col]);
                    this.availableLocation.add(this.board[row + value2][col]);
                }
                if (!oppentNorthWest.get() && moveOne.get()) {
                    this.canAttack.put(this.board[row + value][col + value], oppent);
                    this.availableLocation.add(this.board[row + value][col + value]);
                    moveOne.set(false);
                }

                if (!oppentP2.get() && moveTwo.get()) {
                    this.canAttack.put(this.board[row + 1][col - 1], oppent2);
                    this.availableLocation.add(this.board[row + 1][col - 1]);

                    if (this.color.equals("black")) {
                        this.availableLocation.add(this.board[row + 1][col - 1]);
                    } else if (this.color.equals("white")) {
                        this.availableLocation.add(this.board[row - 1][col + 1]);
                        moveTwo.set(false);

                    }
                }
                this.checkPieces();
                System.out.println();
            } catch (IndexOutOfBoundsException e) {

            }

        }


}


