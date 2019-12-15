public class King extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();

        int row = this.row;
        int col = this.col;

        try {
            // checks if moves will be valid for all 4 diagnol quardants

                if (row+1 > -1 && row +1 < 8 && col + 1 > -1 && col + 1 < 8)
                    this.availableLocation.add(this.board[row + 1][col + 1]);

                if (row-1 > -1 && row -1 < 8 && col - 1 > -1 && col -1 < 8) {
                    this.availableLocation.add(this.board[row - 1][col - 1]);
                }

                if (row+1 > -1 && row +1 < 8 && col - 1 > -1 && col -1 < 8){
                    this.availableLocation.add(this.board[row+1][col-1]);

                }

                if (row-1 > -1 && row -1 < 8 && col + 1 > -1 && col + 1 < 8){
                    this.availableLocation.add(this.board[row-1][col+1]);

                }

            // check to the right
            if (row > -1 && row < 8 && col + 1 > -1 && col + 1 < 8)
                this.availableLocation.add(this.board[row][col + 1]);
            // check to the left
            if (row > -1 && row < 8 && col - 1 > -1 && col -1 < 8) {
                this.availableLocation.add(this.board[row][col - 1]);
            }
            // check to the south
            if (row+1 > -1 && row +1 < 8 && col > -1 && col< 8){
                this.availableLocation.add(this.board[row+1][col]);

            }
            // check to the north
            if (row-1 > -1 && row -1 < 8 && col> -1 && col< 8){
                this.availableLocation.add(this.board[row-1][col]);

            }

                //TODO add collision detection

        }catch (IndexOutOfBoundsException e){
            System.out.println("Index want out of bounds");
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

}
