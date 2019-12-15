public class Queen extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();
        this.diagnolMoves();
        this.verticalHorizontalMoves();
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


    private void diagnolMoves(){


        int row = this.row;
        int col = this.col;

        try {
            // checks if moves will be valid for all 4 diagnol quardants
            for (int i = 0; i < this.getBoard().length; i++) {
                if (row+i > -1 && row +i < 8 && col + i > -1 && col + i < 8)
                    this.availableLocation.add(this.board[row + i][col + i]);

                if (row-i > -1 && row -i < 8 && col - i > -1 && col -i < 8) {
                    this.availableLocation.add(this.board[row - i][col - i]);
                }

                if (row+i > -1 && row +i < 8 && col - i > -1 && col -i < 8){
                    this.availableLocation.add(this.board[row+i][col-i]);

                }

                if (row-i > -1 && row -i < 8 && col + i > -1 && col + i < 8){
                    this.availableLocation.add(this.board[row-i][col+i]);

                }

                //TODO add collision detection




            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index want out of bounds");
        }
    }

    private void verticalHorizontalMoves(){

        int row = this.row;
        int col = this.col;

        try {
            // checks if moves will be valid for all 4 diagnol quardants
            for (int i = 0; i < this.getBoard().length; i++) {
                // check to the right
                if (row > -1 && row < 8 && col + i > -1 && col + i < 8)
                    this.availableLocation.add(this.board[row][col + i]);
                // check to the left
                if (row > -1 && row < 8 && col - i > -1 && col -i < 8) {
                    this.availableLocation.add(this.board[row][col - i]);
                }
                // check to the south
                if (row+i > -1 && row +i < 8 && col > -1 && col< 8){
                    this.availableLocation.add(this.board[row+i][col]);

                }
                // check to the north
                if (row-i > -1 && row -i < 8 && col> -1 && col< 8){
                    this.availableLocation.add(this.board[row-i][col]);

                }

                //TODO add collision detection




            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index want out of bounds");
        }
    }
}
