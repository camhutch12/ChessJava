import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bishop extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.canAttack.clear();
        if (this.location.equals("e5"))
            System.out.println();
        if (this.color.equals("white")) {
            helperAvailableMoves(Piece.whitePiecesOnBoard, Piece.blackPiecesOnBoard);
        }
        else if (this.color.equals("black")) {
            helperAvailableMoves(Piece.blackPiecesOnBoard, Piece.whitePiecesOnBoard);
        }


    }

    private void helperAvailableMoves(List<Piece> colorList, List<Piece> oppentList) {
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
            for (int i = 1; i < this.getBoard().length; i++) {
                if (row + i > -1 && row + i < 8 && col + i > -1 && col + i < 8) {
                    if (northWest.get() && oppentNorthWest.get()) {
                        currentSpotChecking = this.board[row + i][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                northWest.set(false);
                            }
                        }));
                    }

                    if (oppentNorthWest.get() && northWest.get()) {
                        currentSpotChecking = this.board[row + i][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorthWest.set(false);
                            }

                        }


                    }

                    if (northWest.get() && oppentNorthWest.get()) {
                        this.availableLocation.add(this.board[row + i][col + i]);
                    }

                    if (!oppentNorthWest.get() && northWest.get()) {
                        this.canAttack.put(this.board[row + i][col + i], oppent);
                        this.availableLocation.add(this.board[row + i][col + i]);
                        northWest.set(false);

                    }


                }

                if (row - i > -1 && row - i < 8 && col - i > -1 && col - i < 8) {
                    if (southWest.get() && oppentSouthWest.get()) {
                        currentSpotChecking = this.board[row - i][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                southWest.set(false);
                            }
                        }));
                    }

                    if (oppentSouthWest.get() && southWest.get()) {
                        currentSpotChecking = this.board[row - i][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouthWest.set(false);
                            }

                        }


                    }

                    if (southWest.get() && oppentSouthWest.get()) {
                        this.availableLocation.add(this.board[row + i][col + i]);
                    }

                    if (!oppentSouthWest.get() && southWest.get()) {
                        this.canAttack.put(this.board[row - i][col - i], oppent);
                        this.availableLocation.add(this.board[row - i][col - i]);
                        southWest.set(false);

                    }
                }

                if (row + i > -1 && row + i < 8 && col - i > -1 && col - i < 8) {
                    if (southEast.get() && oppentSouthEast.get()) {
                        currentSpotChecking = this.board[row + i][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                southEast.set(false);
                            }
                        }));
                    }

                    if (oppentSouthEast.get() && southEast.get()) {
                        currentSpotChecking = this.board[row + i][col - i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentSouthEast.set(false);
                            }

                        }


                    }

                    if (southEast.get() && oppentSouthEast.get()) {
                        this.availableLocation.add(this.board[row + i][col - i]);
                    }

                    if (!oppentSouthEast.get() && southEast.get()) {
                        this.canAttack.put(this.board[row + i][col - i], oppent);
                        this.availableLocation.add(this.board[row + i][col - i]);
                        southEast.set(false);

                    }

                }

                if (row - i > -1 && row - i < 8 && col + i > -1 && col + i < 8) {
                    if (northEast.get() && oppentNorthEast.get()) {
                        currentSpotChecking = this.board[row - i][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        colorList.forEach((piece -> {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                northEast.set(false);
                            }
                        }));
                    }

                    if (oppentNorthEast.get() && northEast.get()) {
                        currentSpotChecking = this.board[row - i][col + i];
                        String finalCurrentSpotChecking = currentSpotChecking;
                        for (Piece piece : oppentList) {
                            if (piece.location.equals(finalCurrentSpotChecking)) {
                                oppent = piece;
                                oppentNorthEast.set(false);
                            }

                        }


                    }

                    if (northEast.get() && oppentNorthEast.get()) {
                        this.availableLocation.add(this.board[row - i][col + i]);
                    }

                    if (!oppentNorthEast.get() && northEast.get()) {
                        this.canAttack.put(this.board[row - i][col + i], oppent);
                        this.availableLocation.add(this.board[row - i][col + i]);
                        northEast.set(false);

                    }
                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index want out of bounds");
        }

    }

    public Bishop(String name, String color, String location) {
        super(name, color, location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color.equals("white") ? "white-bishop.png" : "black-bishop.png";
        loadImage(this.file);
    }
}