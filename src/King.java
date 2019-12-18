import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class King extends Piece {

    @Override

    public void availableMoves() {

        this.availableLocation.clear();
        this.canAttack.clear();
        if (this.location.equals("e5"))
            System.out.println();
        if (this.color.equals("white")){
            diagnolMoves(Piece.whitePiecesOnBoard,Piece.blackPiecesOnBoard);
            verticalHorizontalMoves(Piece.whitePiecesOnBoard,Piece.blackPiecesOnBoard);
        }

        else if (this.color.equals("black")){
            diagnolMoves(Piece.blackPiecesOnBoard,Piece.whitePiecesOnBoard);
            verticalHorizontalMoves(Piece.blackPiecesOnBoard,Piece.whitePiecesOnBoard);
        }

    }

    public King(String name, String color, String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-king.png" : "black-king.png";
        loadImage(this.file);
    }

    @Override
    public void findRoute() {

    }

    private void diagnolMoves(List<Piece> colorList, List<Piece> oppentList){
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

        try {
            // checks if moves will be valid for all 4 diagnol quardants

                if (row + 1 > -1 && row + 1 < 8 && col + 1 > -1 && col + 1 < 8) {
                    if (northWest.get() && oppentNorthWest.get()) {
                        currentSpotChecking = this.board[row + 1][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                northWest.set(false);
                            }
                        }));
                    }

                    if (oppentNorthWest.get() && northWest.get()) {
                        currentSpotChecking = this.board[row + 1][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorthWest.set(false);
                            }

                        }

                    }

                    if (northWest.get() && oppentNorthWest.get()) {
                        this.availableLocation.add(this.board[row + 1][col + 1]);
                    }

                    if (!oppentNorthWest.get() && northWest.get()) {
                        this.canAttack.put(this.board[row + 1][col + 1], oppent);
                        this.availableLocation.add(this.board[row + 1][col + 1]);
                        northWest.set(false);

                    }

                }

                if (row - 1 > -1 && row - 1 < 8 && col - 1 > -1 && col - 1 < 8) {
                    if (southWest.get() && oppentSouthWest.get()) {
                        currentSpotChecking = this.board[row - 1][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                southWest.set(false);
                            }
                        }));
                    }

                    if (oppentSouthWest.get() && southWest.get()) {
                        currentSpotChecking = this.board[row - 1][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouthWest.set(false);
                            }

                        }


                    }

                    if (southWest.get() && oppentSouthWest.get()) {
                        this.availableLocation.add(this.board[row + 1][col + 1]);
                    }

                    if (!oppentSouthWest.get() && southWest.get()) {
                        this.canAttack.put(this.board[row - 1][col - 1], oppent);
                        this.availableLocation.add(this.board[row - 1][col - 1]);
                        southWest.set(false);

                    }
                }

                if (row + 1 > -1 && row + 1 < 8 && col - 1 > -1 && col - 1 < 8) {
                    if (southEast.get() && oppentSouthEast.get()) {
                        currentSpotChecking = this.board[row + 1][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                southEast.set(false);
                            }
                        }));
                    }

                    if (oppentSouthEast.get() && southEast.get()) {
                        currentSpotChecking = this.board[row + 1][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouthEast.set(false);
                            }

                        }


                    }

                    if (southEast.get() && oppentSouthEast.get()) {
                        this.availableLocation.add(this.board[row + 1][col - 1]);
                    }

                    if (!oppentSouthEast.get() && southEast.get()) {
                        this.canAttack.put(this.board[row + 1][col - 1], oppent);
                        this.availableLocation.add(this.board[row + 1][col - 1]);
                        southEast.set(false);

                    }

                }

                if (row - 1 > -1 && row - 1 < 8 && col + 1 > -1 && col + 1 < 8) {
                    if (northEast.get() && oppentNorthEast.get()) {
                        currentSpotChecking = this.board[row - 1][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                northEast.set(false);
                            }
                        }));
                    }

                    if (oppentNorthEast.get() && northEast.get()) {
                        currentSpotChecking = this.board[row - 1][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorthEast.set(false);
                            }

                        }


                    }

                    if (northEast.get() && oppentNorthEast.get()) {
                        this.availableLocation.add(this.board[row - 1][col + 1]);
                    }

                    if (!oppentNorthEast.get() && northEast.get()) {
                        this.canAttack.put(this.board[row - 1][col + 1], oppent);
                        this.availableLocation.add(this.board[row - 1][col + 1]);
                        northEast.set(false);

                    }
                }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index want out of bounds");
        }
    }

    private void verticalHorizontalMoves(List<Piece> colorList, List<Piece> oppentList){

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

        try {

            // checks if moves will be valid for north, south, east and west quadrants
                // check to the right
                if (row > -1 && row < 8 && col + 1 > -1 && col + 1 < 8) {
                    if (west.get() && oppentWest.get()) {
                        currentSpotChecking = this.board[row][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                west.set(false);
                            }
                        }));

                    }

                    if (oppentWest.get() && west.get()) {
                        currentSpotChecking = this.board[row][col + 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentWest.set(false);
                            }

                        }
                    }

                    if (west.get() && oppentWest.get()) {
                        this.availableLocation.add(this.board[row][col + 1]);
                    }

                    if (!oppentWest.get() && west.get()) {
                        this.canAttack.put(this.board[row][col + 1], oppent);
                        this.availableLocation.add(this.board[row][col + 1]);
                        west.set(false);

                    }

                    //Castling right
                    if(oppentWest.get() && west.get() && turn == 0){
                        currentSpotChecking = this.board[row][col + 2];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                west.set(false);
                            }
                        }));
                    }

                    if (oppentWest.get() && west.get() && turn == 0) {
                        currentSpotChecking = this.board[row][col + 2];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentWest.set(false);
                            }

                        }
                    }

                    if(oppentWest.get() && west.get() && turn == 0){
                        currentSpotChecking = this.board[row][col + 3];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking) && piece.name.equals("rook") && piece.turn == 0) {
                                this.availableLocation.add(this.board[row][col+2]);
                            }
                        }));
                    }

                }

                // check to the left
                if (row > -1 && row < 8 && col - 1 > -1 && col - 1 < 8) {


                    if (east.get() && oppentEast.get()) {
                        currentSpotChecking = this.board[row][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                east.set(false);
                            }
                        }));



                    }

                    if (oppentEast.get() && east.get()) {
                        currentSpotChecking = this.board[row][col - 1];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentEast.set(false);
                            }

                        }


                    }

                    if (east.get() && oppentEast.get()) {
                        this.availableLocation.add(this.board[row][col - 1]);
                    }

                    if (!oppentEast.get() && east.get()) {
                        this.canAttack.put(this.board[row][col - 1], oppent);
                        this.availableLocation.add(this.board[row][col - 1]);
                        east.set(false);

                    }

                    if(oppentEast.get() && east.get() && turn == 0){
                        currentSpotChecking = this.board[row][col - 2];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                west.set(false);
                            }
                        }));
                    }

                    if (oppentEast.get() && east.get() && turn == 0) {
                        for(int i = (col-2); i > 0 ;i--) {
                            currentSpotChecking = this.board[row][i];
                            String finalCurrentSpotChecking = currentSpotChecking;
                            for (Piece piece : oppentList) {
                                if (piece.location.equals(finalCurrentSpotChecking)) {
                                    oppent = piece;
                                    oppentWest.set(false);
                                }

                            }
                        }
                    }

                    if(oppentEast.get() && east.get() && turn == 0){
                        currentSpotChecking = this.board[row][col - 4];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking) && piece.name.equals("rook") && piece.turn == 0 && piece.color == this.color) {
                                this.availableLocation.add(this.board[row][col-2]);
                            }
                        }));
                    }

                }

                // check to the south
                if (row + 1 > -1 && row + 1 < 8 && col > -1 && col < 8) {

                    if (south.get() && oppentSouth.get()) {
                        currentSpotChecking = this.board[row+1][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                south.set(false);
                            }
                        }));



                    }

                    if (oppentSouth.get() && south.get()) {
                        currentSpotChecking = this.board[row+1][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouth.set(false);
                            }

                        }


                    }

                    if (south.get() && oppentSouth.get()) {
                        this.availableLocation.add(this.board[row+1][col]);
                    }

                    if (!oppentSouth.get() && south.get()) {
                        this.canAttack.put(this.board[row+1][col], oppent);
                        this.availableLocation.add(this.board[row+1][col]);
                        south.set(false);

                    }


                }
                // check to the north
                if (row - 1 > -1 && row - 1 < 8 && col > -1 && col < 8) {


                    if (north.get() && oppentNorth.get()) {
                        currentSpotChecking = this.board[row-1][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                north.set(false);
                            }
                        }));



                    }

                    if (oppentNorth.get() && north.get()) {
                        currentSpotChecking = this.board[row-1][col];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorth.set(false);
                            }

                        }


                    }

                    if (north.get() && oppentNorth.get()) {
                        this.availableLocation.add(this.board[row-1][col]);
                    }

                    if (!oppentNorth.get() && north.get()) {
                        this.canAttack.put(this.board[row-1][col], oppent);
                        this.availableLocation.add(this.board[row-1][col]);
                        north.set(false);

                    }


                }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index want out of bounds");
        }

        this.checkPieces();
        System.out.println();
    }

    public void isInCheck(){
        List<Piece> whoCanKill = new ArrayList<>();
        if (this.color.equals("black")){

            for (Piece p :
                    Piece.whitePiecesOnBoard) {
                p.availableMoves();
                if (p.availableLocation.contains(this.location)){
                    whoCanKill.add(p);
                }


            }

        }
        else if (this.color.equals("white")){

        }
    }
}
