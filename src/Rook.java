import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Rook extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.canAttack.clear();
        if (this.location.equals("e5"))
            System.out.println();
        if (this.color.equals("white")){
            helperAvailableMoves(Piece.whitePiecesOnBoard,Piece.blackPiecesOnBoard);
        }

        else if (this.color.equals("black")){
            helperAvailableMoves(Piece.blackPiecesOnBoard,Piece.whitePiecesOnBoard);
        }

    }

    private void helperAvailableMoves(List<Piece> colorList, List<Piece> oppentList){

        int row = this.row;
        int col = this.col;
        Piece oppent = null;
        String currentSpotChecking = "";
        AtomicBoolean west = new AtomicBoolean(true);
        AtomicBoolean east = new AtomicBoolean(true);
        AtomicBoolean north = new AtomicBoolean(true);
        AtomicBoolean south = new AtomicBoolean(true);
        AtomicBoolean oppentWest = new AtomicBoolean(true);
        AtomicBoolean oppentEast = new AtomicBoolean(true);
        AtomicBoolean oppentNorth = new AtomicBoolean(true);
        AtomicBoolean oppentSouth = new AtomicBoolean(true);



            // checks if moves will be valid for north, south, east and west quardants
            for (int i = 1; i < this.getBoard().length; i++) {
                // check to the right
                if (row > -1 && row < 8 && col + i > -1 && col + i < 8) {
                    if (west.get() && oppentWest.get()) {
                        currentSpotChecking = this.board[row][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : colorList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                west.set(false);
                            }
                        }


                    }

                    if (oppentWest.get() && west.get()) {
                        currentSpotChecking = this.board[row][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentWest.set(false);
                            }

                        }


                    }

                    if (west.get() && oppentWest.get()) {
                        this.availableLocation.add(this.board[row][col + i]);
                    }

                    if (!oppentWest.get() && west.get()) {
                        this.canAttack.put(this.board[row][col + i], oppent);
                        this.availableLocation.add(this.board[row][col + i]);
                        west.set(false);

                    }
                }

                // check to the left
                if (row > -1 && row < 8 && col - i > -1 && col - i < 8) {


                    if (east.get() && oppentEast.get()) {
                        currentSpotChecking = this.board[row][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                east.set(false);
                            }
                        }));



                    }

                    if (oppentEast.get() && east.get()) {
                        currentSpotChecking = this.board[row][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentEast.set(false);
                            }

                        }


                    }

                    if (east.get() && oppentEast.get()) {
                        this.availableLocation.add(this.board[row][col - i]);
                    }

                    if (!oppentEast.get() && east.get()) {
                        this.canAttack.put(this.board[row][col - i], oppent);
                        this.availableLocation.add(this.board[row][col - i]);
                        east.set(false);

                    }


                }

                // check to the south
                if (row + i > -1 && row + i < 8 && col > -1 && col < 8) {

                    if (south.get() && oppentSouth.get()) {
                        currentSpotChecking = this.board[row+i][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                south.set(false);
                            }
                        }));



                    }

                    if (oppentSouth.get() && south.get()) {
                        currentSpotChecking = this.board[row+i][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouth.set(false);
                            }

                        }


                    }

                    if (south.get() && oppentSouth.get()) {
                        this.availableLocation.add(this.board[row+i][col]);
                    }

                    if (!oppentSouth.get() && south.get()) {
                        this.canAttack.put(this.board[row+i][col], oppent);
                        this.availableLocation.add(this.board[row+i][col]);
                        south.set(false);

                    }


                }
                // check to the north
                if (row - i > -1 && row - i < 8 && col > -1 && col < 8) {


                    if (north.get() && oppentNorth.get()) {
                        currentSpotChecking = this.board[row-i][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                north.set(false);
                            }
                        }));



                    }

                    if (oppentNorth.get() && north.get()) {
                        currentSpotChecking = this.board[row-i][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorth.set(false);
                            }

                        }


                    }

                    if (north.get() && oppentNorth.get()) {
                        this.availableLocation.add(this.board[row-i][col]);
                    }

                    if (!oppentNorth.get() && north.get()) {
                        this.canAttack.put(this.board[row-i][col], oppent);
                        this.availableLocation.add(this.board[row-i][col]);
                        north.set(false);

                    }


                }

                //TODO add collision detection
            }



        this.checkPieces();
        System.out.println();
    }


    public Rook(String name, String color, String location) {
        super(name, color, location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-rooke.png" : "black-rook.png";
        loadImage(this.file);
    }

    @Override
    public void findRoute(King king, String locationForKing) {

    }
}
