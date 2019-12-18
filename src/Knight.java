import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Knight extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.canAttack.clear();
        if (this.location.equals("e5"))
            System.out.println();
        if (this.color.equals("white")) {
            availableMovesHelper(Piece.whitePiecesOnBoard, Piece.blackPiecesOnBoard);
        }
        else if (this.color.equals("black")) {
            availableMovesHelper(Piece.blackPiecesOnBoard, Piece.whitePiecesOnBoard);
        }

    }

    private void availableMovesHelper(List<Piece> colorList, List<Piece> oppentList){
        int row = this.row;
        int col = this.col;
        Piece oppent = null;
        String currentSpotChecking = "";
        AtomicBoolean northWest = new AtomicBoolean(true);
        AtomicBoolean northEast = new AtomicBoolean(true);
        AtomicBoolean southWest = new AtomicBoolean(true);
        AtomicBoolean southEast = new AtomicBoolean(true);
        AtomicBoolean oppentNorthWest = new AtomicBoolean(true);
        AtomicBoolean oppentNorthEast = new AtomicBoolean(true);
        AtomicBoolean oppentSouthWest = new AtomicBoolean(true);
        AtomicBoolean oppentSouthEast = new AtomicBoolean(true);

        AtomicBoolean west = new AtomicBoolean(true);
        AtomicBoolean east = new AtomicBoolean(true);
        AtomicBoolean north = new AtomicBoolean(true);
        AtomicBoolean south = new AtomicBoolean(true);
        AtomicBoolean oppentWest = new AtomicBoolean(true);
        AtomicBoolean oppentEast = new AtomicBoolean(true);
        AtomicBoolean oppentNorth = new AtomicBoolean(true);
        AtomicBoolean oppentSouth = new AtomicBoolean(true);
        try {
            // checks if moves will be valid for all 4 diagnol quardants

            // checks north+2 and checks east +1
            if (row+2 > -1 && row +2 < 8 && col + 1 > -1 && col + 1 < 8) {
                if (northWest.get() && oppentNorthWest.get()) {
                    currentSpotChecking = this.board[row + 2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            northWest.set(false);
                        }
                    }));
                }
                if (oppentNorthWest.get() && northWest.get()) {
                    currentSpotChecking = this.board[row + 2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentNorthWest.set(false);
                        }
                    }
                }
                if (northWest.get() && oppentNorthWest.get()) {
                    this.availableLocation.add(this.board[row + 2][col + 1]);
                }
                if (!oppentNorthWest.get() && northWest.get()) {
                    this.canAttack.put(this.board[row + 2][col + 1], oppent);
                    this.availableLocation.add(this.board[row + 2][col + 1]);
                    northWest.set(false);
                }
            }
            // checks north + 2 and checks west one space
            if (row + 2 > -1 && row + 2 < 8 && col - 1 > -1 && col -1 < 8) {


                if (southWest.get() && oppentSouthWest.get()) {
                    currentSpotChecking = this.board[row +2][col - 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            southWest.set(false);
                        }
                    }));
                }

                if (oppentSouthWest.get() && southWest.get()) {
                    currentSpotChecking = this.board[row +2][col - 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentSouthWest.set(false);
                        }

                    }
                }

                if (southWest.get() && oppentSouthWest.get()) {
                    this.availableLocation.add(this.board[row +2][col - 1]);
                }

                if (!oppentSouthWest.get() && southWest.get()) {
                    this.canAttack.put(this.board[row +2][col - 1], oppent);
                    this.availableLocation.add(this.board[row +2][col - 1]);
                    southWest.set(false);

                }












            }
            // checks 2 spaces west and one space east
            if (row+1 > -1 && row +1 < 8 && col - 2 > -1 && col -2 < 8){


                if (southEast.get() && oppentSouthEast.get()) {
                    currentSpotChecking = this.board[row+1][col-2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            southEast.set(false);
                        }
                    }));
                }

                if (oppentSouthEast.get() && southEast.get()) {
                    currentSpotChecking = this.board[row+1][col-2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentSouthEast.set(false);
                        }

                    }


                }

                if (southEast.get() && oppentSouthEast.get()) {
                    this.availableLocation.add(this.board[row+1][col-2]);
                }

                if (!oppentSouthEast.get() && southEast.get()) {
                    this.canAttack.put(this.board[row+1][col-2], oppent);
                    this.availableLocation.add(this.board[row+1][col-2]);
                    southEast.set(false);

                }

                //this.availableLocation.add(this.board[row+1][col-2]);

            }

            if (row-1 > -1 && row -1 < 8 && col - 2 > -1 && col -2 < 8){
                if (northEast.get() && oppentNorthEast.get()) {
                    currentSpotChecking = this.board[row-1][col-2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            northEast.set(false);
                        }
                    }));
                }

                if (oppentNorthEast.get() && northEast.get()) {
                    currentSpotChecking = this.board[row-1][col-2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentNorthEast.set(false);
                        }

                    }


                }

                if (northEast.get() && oppentNorthEast.get()) {
                    this.availableLocation.add(this.board[row-1][col-2]);
                }

                if (!oppentNorthEast.get() && northEast.get()) {
                    this.canAttack.put(this.board[row-1][col-2], oppent);
                    this.availableLocation.add(this.board[row-1][col-2]);
                    northEast.set(false);

                }

                //this.availableLocation.add(this.board[row-1][col-2]);

            }
            // checks 2 spaces east and 1 space north
            if (row+1 > -1 && row+1 < 8 && col + 2 > -1 && col + 2 < 8){

                if (west.get() && oppentWest.get()) {
                    currentSpotChecking = this.board[row + 1][col+2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            west.set(false);
                        }
                    }));



                }

                if (oppentWest.get() && west.get()) {
                    currentSpotChecking = this.board[row + 1][col+2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentWest.set(false);
                        }

                    }


                }

                if (west.get() && oppentWest.get()) {
                    this.availableLocation.add(this.board[row + 1][col+2]);
                }

                if (!oppentWest.get() && west.get()) {
                    this.canAttack.put(this.board[row + 1][col+2], oppent);
                    this.availableLocation.add(this.board[row + 1][col+2]);
                    west.set(false);

                }

                this.availableLocation.add(this.board[row + 1][col+2]);

            }
            // checks 2 spaces east and 1 space south
            if (row-1 > -1 && row-1 < 8 && col + 2 > -1 && col + 2 < 8){


                if (east.get() && oppentEast.get()) {
                    currentSpotChecking = this.board[row - 1][col+2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            east.set(false);
                        }
                    }));



                }

                if (oppentEast.get() && east.get()) {
                    currentSpotChecking = this.board[row - 1][col+2];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentEast.set(false);
                        }

                    }


                }

                if (east.get() && oppentEast.get()) {
                    this.availableLocation.add(this.board[row - 1][col+2]);
                }

                if (!oppentEast.get() && east.get()) {
                    this.canAttack.put(this.board[row - 1][col+2], oppent);
                    this.availableLocation.add(this.board[row - 1][col+2]);
                    east.set(false);

                }

                this.availableLocation.add(this.board[row - 1][col+2]);

            }


            if (row > -2 && row -2 < 8 && col + 1 > -1 && col + 1 < 8) {

                if (south.get() && oppentSouth.get()) {
                    currentSpotChecking = this.board[row - 2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            south.set(false);
                        }
                    }));


                }

                if (oppentSouth.get() && south.get()) {
                    currentSpotChecking = this.board[row - 2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentSouth.set(false);
                        }

                    }


                }

                if (south.get() && oppentSouth.get()) {
                    this.availableLocation.add(this.board[row - 2][col + 1]);
                }

                if (!oppentSouth.get() && south.get()) {
                    this.canAttack.put(this.board[row - 2][col + 1], oppent);
                    this.availableLocation.add(this.board[row - 2][col + 1]);
                    south.set(false);

                }

            }









                //this.availableLocation.add(this.board[row-2][col + 1]);
            // check to the left
            if (row > -2 && row-2 < 8 && col + 1 > -1 && col +1 < 8) {

                if (north.get() && oppentNorth.get()) {
                    currentSpotChecking = this.board[row-2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    colorList.forEach((piece -> {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            north.set(false);
                        }
                    }));



                }

                if (oppentNorth.get() && north.get()) {
                    currentSpotChecking = this.board[row-2][col + 1];
                    String finalCurrentSpotChecking = currentSpotChecking;
                    for (Piece piece : oppentList) {
                        if (piece.location.equals(finalCurrentSpotChecking)) {
                            oppent = piece;
                            oppentNorth.set(false);
                        }

                    }


                }

                if (north.get() && oppentNorth.get()) {
                    this.availableLocation.add(this.board[row-2][col + 1]);
                }

                if (!oppentNorth.get() && north.get()) {
                    this.canAttack.put(this.board[row-2][col + 1], oppent);
                    this.availableLocation.add(this.board[row-2][col + 1]);
                    north.set(false);

                }

                //this.availableLocation.add(this.board[row-2][col + 1]);
            }


            //TODO add collision detection

        }catch (IndexOutOfBoundsException e){
            System.out.println("Index want out of bounds");
        }
    }

    public Knight(String name, String color, String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color.equals("white") ? "white-knight.png" : "black-knight.png";
        loadImage(this.file);
    }
}
