import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Queen extends Piece {
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

    public Queen(String name, String color, String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color.equals("white") ? "white-queen.png" : "black-queen.png";
        loadImage(this.file);
    }

    @Override
    public void findRoute() {

    }


    private void diagnolMoves(List<Piece> colorList, List<Piece> oppentList){
        helperAvailableMoves(colorList,oppentList);
        stupidFrustingThing(colorList,oppentList);
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

            // checks if moves will be valid for north, south, east and west quardants
            for (int i = 1; i < this.getBoard().length; i++) {
                // check to the right
                if (row > -1 && row < 8 && col + i > -1 && col + i < 8) {
                    if (west.get() && oppentWest.get()) {
                        currentSpotChecking = this.board[row][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                west.set(false);
                            }
                        }));



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

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index want out of bounds");
        }

        this.checkPieces();
        System.out.println();
    }

    private void helperAvailableMoves(List<Piece> colorList, List<Piece> oppentList) {
        int row = this.row;
        int col = this.col;
        Piece oppent1 = null;
        Piece oppent2 = null;
        Piece oppent3 = null;
        Piece oppent4 = null;
        String currentSpotChecking1 = null;
        String currentSpotChecking2 = null;
        String currentSpotChecking3 = null;
        String currentSpotChecking4 = null;
        boolean currentSpotCheckingBoolOpp1 = false;
        boolean currentSpotCheckingBoolOpp2 = false;
        boolean currentSpotCheckingBoolOpp3 = false;
        boolean currentSpotCheckingBoolOpp4 = false;

        boolean currentMemberWasAttackAlready1 = false;
        boolean currentMemberWasAttackAlready2 = false;
        boolean currentMemberWasAttackAlready3 = false;
        boolean currentMemberWasAttackAlready4 = false;


        boolean currentSpotCheckingBool1 = true;
        boolean currentSpotCheckingBool2 = true;
        boolean currentSpotCheckingBool3 = true;
        boolean currentSpotCheckingBool4 = true;

        /*boolean currentSpotCheckingBool1 = true;
        boolean currentSpotCheckingBool2 = true;
        boolean currentSpotCheckingBool3 = true;
        boolean currentSpotCheckingBool4 = true;*/


        // checks if moves will be valid for all 4 diagnol quardants
        for (int i = 1; i < this.getBoard().length; i++) {
            if (this.location == "d5")
                System.out.println();
            currentSpotChecking1 = null;
            currentSpotChecking2 = null;
            currentSpotChecking3 = null;
            currentSpotChecking4 = null;


            if (row + i > -1 && row + i < 8 && col + i > -1 && col + i < 8) {

                currentSpotChecking1 = this.board[row + i][col + i];
            }

            if (row + i > -1 && row + i < 8 && col - i > -1 && col - i < 8) {

                currentSpotChecking2 = this.board[row + i][col - i];
            }

            if (row - i > -1 && row - i < 8 && col + i > -1 && col + i < 8) {

                currentSpotChecking3 = this.board[row - i][col + i];
            }

            if (row - i > -1 && row - i < 8 && col - i > -1 && col - i < 8) {

                currentSpotChecking4 = this.board[row - i][col - i];
            }

            for (Piece piece : colorList) {

                if (currentSpotChecking1 != null) {
                    if (piece.location.equals(currentSpotChecking1)) {
                        currentSpotCheckingBool1 = false;
                    }

                }
                if (currentSpotChecking2 != null) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        currentSpotCheckingBool2 = false;

                    }
                }
                if (currentSpotChecking3 != null) {
                    if (piece.location.equals(currentSpotChecking3)) {
                        currentSpotCheckingBool3 = false;

                    }
                }
                if (currentSpotChecking4 != null) {
                    if (piece.location.equals(currentSpotChecking4)) {
                        currentSpotCheckingBool4 = false;

                    }
                }
            }


            for (Piece piece : oppentList) {

                if (currentSpotChecking1 != null) {
                    if (piece.location.equals(currentSpotChecking1)) {
                        currentSpotCheckingBool1 = false;
                    }

                }
                if (currentSpotChecking2 != null) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        currentSpotCheckingBool2 = false;

                    }
                }
                if (currentSpotChecking3 != null) {
                    if (piece.location.equals(currentSpotChecking3)) {
                        currentSpotCheckingBool3 = false;

                    }
                }
                if (currentSpotChecking4 != null) {
                    if (piece.location.equals(currentSpotChecking4)) {
                        currentSpotCheckingBool4 = false;

                    }
                }
            }

            if (currentSpotCheckingBool1 && currentSpotChecking1 != null) {
                this.availableLocation.add(currentSpotChecking1);
            }

            if (currentSpotCheckingBool2 && currentSpotChecking2 != null) {
                this.availableLocation.add(currentSpotChecking2);

            }

            if (currentSpotCheckingBool3 && currentSpotChecking3 != null) {
                this.availableLocation.add(currentSpotChecking3);

            }

            if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
                this.availableLocation.add(currentSpotChecking4);

            }








//            if (oppentNorthWest.get() && northWest.get()) {
//                currentSpotChecking = this.board[row + i][col + i];
//                String finalCurrentSpotChecking = currentSpotChecking;
//                for (Piece piece : oppentList) {
//                    if (piece.location.equals(finalCurrentSpotChecking)) {
//                        oppent = piece;
//                        oppentNorthWest.set(false);
//                    }
//
//                }
//
//
//            }
//
//            if (northWest.get() && oppentNorthWest.get()) {
//                this.availableLocation.add(this.board[row + i][col + i]);
//            }
//
//            if (!oppentNorthWest.get() && northWest.get()) {
//                this.canAttack.put(this.board[row + i][col + i], oppent);
//                this.availableLocation.add(this.board[row + i][col + i]);
//                northWest.set(false);
//
//            }
//
//
//            if (row - i > -1 && row - i < 8 && col - i > -1 && col - i < 8) {
//                if (southWest.get() && oppentSouthWest.get()) {
//                    currentSpotChecking = this.board[row - i][col - i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    colorList.forEach((piece -> {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            southWest.set(false);
//                        }
//                    }));
//                }
//
//                if (oppentSouthWest.get() && southWest.get()) {
//                    currentSpotChecking = this.board[row - i][col - i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    for (Piece piece : oppentList) {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            oppent = piece;
//                            oppentSouthWest.set(false);
//                        }
//
//                    }
//
//
//                }
//
//                if (southWest.get() && oppentSouthWest.get()) {
//                    if (row + i > -1 && row + i < 8 && col + i > -1 && col + i < 8) {
//                        this.availableLocation.add(this.board[row + i][col + i]);
//
//                    }
//                }
//
//                if (!oppentSouthWest.get() && southWest.get()) {
//                    this.canAttack.put(this.board[row - i][col - i], oppent);
//                    this.availableLocation.add(this.board[row - i][col - i]);
//                    southWest.set(false);
//
//                }
//            }
//
//            if (row + i > -1 && row + i < 8 && col - i > -1 && col - i < 8) {
//                if (southEast.get() && oppentSouthEast.get()) {
//                    currentSpotChecking = this.board[row + i][col - i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    colorList.forEach((piece -> {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            southEast.set(false);
//                        }
//                    }));
//                }
//
//                if (oppentSouthEast.get() && southEast.get()) {
//                    currentSpotChecking = this.board[row + i][col - i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    for (Piece piece : oppentList) {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            oppent = piece;
//                            oppentSouthEast.set(false);
//                        }
//
//                    }
//
//
//                }
//
//                if (southEast.get() && oppentSouthEast.get()) {
//                    if (row + i > -1 && row + i < 8 && col - i > -1 && col - i < 8) {
//                        this.availableLocation.add(this.board[row + i][col - i]);
//
//                    }
//                }
//
//                if (!oppentSouthEast.get() && southEast.get()) {
//                    this.canAttack.put(this.board[row + i][col - i], oppent);
//                    this.availableLocation.add(this.board[row + i][col - i]);
//                    southEast.set(false);
//
//                }
//
//            }
//
//            if (row - i > -1 && row - i < 8 && col + i > -1 && col + i < 8) {
//                if (northEast.get() && oppentNorthEast.get()) {
//                    currentSpotChecking = this.board[row - i][col + i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    colorList.forEach((piece -> {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            northEast.set(false);
//                        }
//                    }));
//                }
//
//                if (oppentNorthEast.get() && northEast.get()) {
//                    currentSpotChecking = this.board[row - i][col + i];
//                    String finalCurrentSpotChecking = currentSpotChecking;
//                    for (Piece piece : oppentList) {
//                        if (piece.location.equals(finalCurrentSpotChecking)) {
//                            oppent = piece;
//                            oppentNorthEast.set(false);
//                        }
//
//                    }
//
//
//                }
//
//                if (northEast.get() && oppentNorthEast.get()) {
//                    this.availableLocation.add(this.board[row - i][col + i]);
//                }
//
//                if (!oppentNorthEast.get() && northEast.get()) {
//                    this.canAttack.put(this.board[row - i][col + i], oppent);
//                    this.availableLocation.add(this.board[row - i][col + i]);
//                    northEast.set(false);
//
//                }
//            }

        }


    }
    private void stupidFrustingThing(List<Piece> colorList, List<Piece> oppentList){

        int row = this.row;
        int col = this.col;
        Piece oppent1 = null;
        Piece oppent2 = null;
        Piece oppent3 = null;
        Piece oppent4 = null;
        String currentSpotChecking1 = null;
        String currentSpotChecking2 = null;
        String currentSpotChecking3 = null;
        String currentSpotChecking4 = null;
        boolean currentSpotCheckingBoolOpp1 = false;
        boolean currentSpotCheckingBoolOpp2 = false;
        boolean currentSpotCheckingBoolOpp3 = false;
        boolean currentSpotCheckingBoolOpp4 = false;

        boolean currentMemberWasAttackAlready1 = false;
        boolean currentMemberWasAttackAlready2 = false;
        boolean currentMemberWasAttackAlready3 = false;
        boolean currentMemberWasAttackAlready4 = false;



        currentSpotChecking1 = null;
        currentSpotChecking2 = null;
        currentSpotChecking3 = null;
        currentSpotChecking4 = null;


        for (int i = 1; i <8 ; i++) {


            if (row + i > -1 && row + i < 8 && col + i > -1 && col + i < 8) {

                currentSpotChecking1 = this.board[row + i][col + i];
            }

            if (row + i > -1 && row + i < 8 && col - i > -1 && col - i < 8) {

                currentSpotChecking2 = this.board[row + i][col - i];
            }

            if (row - i > -1 && row - i < 8 && col + i > -1 && col + i < 8) {

                currentSpotChecking3 = this.board[row - i][col + i];
            }

            if (row - i > -1 && row - i < 8 && col - i > -1 && col - i < 8) {

                currentSpotChecking4 = this.board[row - i][col - i];
            }


            for (Piece piece : oppentList) {

                if (currentSpotChecking1 != null && (!currentSpotCheckingBoolOpp1) && (!currentMemberWasAttackAlready1)) {
                    if (piece.location.equals(currentSpotChecking1)) {
                        oppent1 = piece;
                        currentSpotCheckingBoolOpp1 = true;


                    }
                }
                if (currentSpotChecking2 != null && (!currentMemberWasAttackAlready2) && (!currentSpotCheckingBoolOpp2)) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        oppent2 = piece;
                        currentSpotCheckingBoolOpp2 = true;


                    }
                }
                if (currentSpotChecking3 != null && (!currentMemberWasAttackAlready3) && (!currentSpotCheckingBoolOpp3)) {

                    if (piece.location.equals(currentSpotChecking3)) {
                        oppent3 = piece;
                        currentSpotCheckingBoolOpp3 = true;


                    }
                }
                if (currentSpotChecking4 != null && (!currentMemberWasAttackAlready4) && (!currentSpotCheckingBoolOpp4)) {
                    if (piece.location.equals(currentSpotChecking4)) {
                        oppent4 = piece;
                        currentSpotCheckingBoolOpp4 = true;


                    }
                }
            }


            if (currentSpotCheckingBoolOpp1 && currentSpotChecking1 != null && oppent1 != null && (!currentMemberWasAttackAlready1)) {
                this.availableLocation.add(currentSpotChecking1);
                this.canAttack.put(currentSpotChecking1, oppent1);
                currentMemberWasAttackAlready1 = true;

            }

            if (currentSpotCheckingBoolOpp2 && currentSpotChecking2 != null && oppent2 != null && !currentMemberWasAttackAlready2) {
                this.availableLocation.add(currentSpotChecking2);
                this.canAttack.put(currentSpotChecking2, oppent2);
                currentMemberWasAttackAlready2 = true;

            }

            if (currentSpotCheckingBoolOpp3 && currentSpotChecking3 != null && oppent3 != null && !currentMemberWasAttackAlready3) {
                this.availableLocation.add(currentSpotChecking3);
                this.canAttack.put(currentSpotChecking3, oppent3);
                currentMemberWasAttackAlready3 = true;

            }

            if (currentSpotCheckingBoolOpp4 && currentSpotChecking4 != null && oppent4 != null && !currentMemberWasAttackAlready4) {
                this.availableLocation.add(currentSpotChecking4);
                this.canAttack.put(currentSpotChecking4, oppent4);
                currentMemberWasAttackAlready4 = true;

            }
        }
    }
}
