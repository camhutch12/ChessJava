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
        } else if (this.color.equals("black")) {
            availableMovesHelper(Piece.blackPiecesOnBoard, Piece.whitePiecesOnBoard);
        }

    }

    private void availableMovesHelper(List<Piece> colorList, List<Piece> oppentList) {
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
        checkDiagnolOne(colorList, oppentList);
        checkDiagnolTwo(colorList,oppentList);
        checkDiagnolThree(colorList,oppentList);
        checkDiagnolFour(colorList,oppentList);
        checkDiagnolOneOppent(colorList,oppentList);
        checkDiagnolTwoOppent(colorList,oppentList);
        checkDiagnolThreeOppent(colorList,oppentList);
        checkDiagnolFourOppent(colorList,oppentList);
        checkDiagnolfiveOppent(colorList,oppentList);
        checkDiagnolsixOppent(colorList,oppentList);
        // checks if moves will be valid for all 4 diagnol quardants

    }

    public Knight(String name, String color, String location) {
        super(name, color, location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color.equals("white") ? "white-knight.png" : "black-knight.png";
        loadImage(this.file);
    }

    @Override
    public void findRoute(King king, String locationForKing) {

    }

    private void checkDiagnolOne(List<Piece> colorList, List<Piece> oppentList) {
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


        if (row + 2 > -1 && row + 2 < 8 && col + 1 > -1 && col + 1 < 8) {
            currentSpotChecking1 = this.board[row + 2][col + 1];
        }


        for (Piece piece : colorList) {

            if (currentSpotChecking1 != null) {
                if (piece.location.equals(currentSpotChecking1)) {
                    currentSpotCheckingBool1 = false;
                }


            }


        }
        for (Piece piece : oppentList) {

            if (currentSpotChecking1 != null) {
                if (piece.location.equals(currentSpotChecking1)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;
                }

            }

        }
        if (currentSpotCheckingBool1 && currentSpotChecking1 != null) {
            this.availableLocation.add(currentSpotChecking1);
        }
    }


    private void checkDiagnolTwo(List<Piece> colorList, List<Piece> oppentList) {


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


        currentSpotChecking2 = null;

            if (row + 2 > -1 && row + 2 < 8 && col - 1 > -1 && col - 1 < 8) {

                currentSpotChecking2 = this.board[row + 2][col - 1];
            }


            for (Piece piece : colorList) {

                if (currentSpotChecking2 != null) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        currentSpotCheckingBool2 = false;

                    }
                }

            }

            for (Piece piece : oppentList) {

                if (currentSpotChecking2 != null) {
                    if (piece.location.equals(currentSpotChecking2)) {
                        System.out.println();
                        //currentSpotCheckingBool4 = false;

                    }
                }

            }

            if (currentSpotCheckingBool2 && currentSpotChecking2 != null) {
                this.availableLocation.add(currentSpotChecking2);

            }
        }




    private void checkDiagnolThree(List<Piece> colorList, List<Piece> oppentList) {
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



            if (row + 1 > -1 && row + 1 < 8 && col + 2 > -1 && col + 2 < 8) {

                currentSpotChecking3 = this.board[row + 1][col + 2];
            }


            for (Piece piece : colorList) {

                if (currentSpotChecking3 != null) {
                    if (piece.location.equals(currentSpotChecking3)) {
                        currentSpotCheckingBool3 = false;

                    }
                }

            }

            for (Piece piece : oppentList) {


                if (currentSpotChecking3 != null) {
                    if (piece.location.equals(currentSpotChecking3)) {
                        System.out.println();
                        //currentSpotCheckingBool4 = false;

                    }
                }

            }


            if (currentSpotCheckingBool3 && currentSpotChecking3 != null) {
                this.availableLocation.add(currentSpotChecking3);

            }


    }

    private void checkDiagnolFour(List<Piece> colorList, List<Piece> oppentList) {
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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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






        currentSpotChecking4 = null;


            if (row + 1 > -1 && row + 1 < 8 && col - 2 > -1 && col - 2 < 8) {

                currentSpotChecking4 = this.board[row + 1][col - 2];
            }


            for (Piece piece : colorList) {

                if (currentSpotChecking4 != null) {
                    if (piece.location.equals(currentSpotChecking4)) {
                        currentSpotCheckingBool4 = false;

                    }
                }
            }

            for (Piece piece : oppentList) {


                if (currentSpotChecking4 != null) {
                    if (piece.location.equals(currentSpotChecking4)) {
                        System.out.println();
                        //currentSpotCheckingBool4 = false;

                    }
                }
            }

            if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
                this.availableLocation.add(currentSpotChecking4);

            }



    }

    private void checkDiagnolOneOppent(List<Piece> colorList, List<Piece> oppentList) {
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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



            if (row - 2 > -1 && row -2 < 8 && col -1 > -1 && col - 1 < 8) {

                currentSpotChecking4 = this.board[row -2][col - 1];
            }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }
        }


    private void checkDiagnolTwoOppent(List<Piece> colorList, List<Piece> oppentList) {

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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



        if (row - 2 > -1 && row -2 < 8 && col +1 > -1 && col + 1 < 8) {

            currentSpotChecking4 = this.board[row -2][col + 1];
        }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }



    }

    private void checkDiagnolThreeOppent(List<Piece> colorList, List<Piece> oppentList) {
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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



        if (row - 1 > -1 && row -1 < 8 && col +2 > -1 && col +2 < 8) {

            currentSpotChecking4 = this.board[row -1][col + 2];
        }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }


    }

    private void checkDiagnolFourOppent(List<Piece> colorList, List<Piece> oppentList) {

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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



        if (row - 1 > -1 && row -1 < 8 && col -2 > -1 && col - 2 < 8) {

            currentSpotChecking4 = this.board[row -1][col - 2];
        }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }


    }

    private void checkDiagnolfiveOppent(List<Piece> colorList, List<Piece> oppentList) {

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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



        if (row + 1 > -1 && row + 1 < 8 && col -2 > -1 && col - 2 < 8) {

            currentSpotChecking4 = this.board[row + 1][col - 2];
        }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }


    }

    private void checkDiagnolsixOppent(List<Piece> colorList, List<Piece> oppentList) {

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

        String currentSpotChecking6 = null;
        String currentSpotChecking7 = null;
        String currentSpotChecking8 = null;
        String currentSpotChecking9 = null;
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



        if (row + 1 > -1 && row + 1 < 8 && col +2 > -1 && col +2 < 8) {

            currentSpotChecking4 = this.board[row + 1][col + 2];
        }
        for (Piece piece : colorList) {

            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    currentSpotCheckingBool4 = false;

                }
            }
        }

        for (Piece piece : oppentList) {


            if (currentSpotChecking4 != null) {
                if (piece.location.equals(currentSpotChecking4)) {
                    System.out.println();
                    //currentSpotCheckingBool4 = false;

                }
            }
        }

        if (currentSpotCheckingBool4 && currentSpotChecking4 != null) {
            this.availableLocation.add(currentSpotChecking4);

        }


    }
}
