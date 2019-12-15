public class Knight extends Piece {
    @Override
    public void availableMoves() {
        this.availableLocation.clear();

        int row = this.row;
        int col = this.col;

        try {
            // checks if moves will be valid for all 4 diagnol quardants

            // checks north+2 and checks east +1
            if (row+2 > -1 && row +2 < 8 && col + 1 > -1 && col + 1 < 8)
                this.availableLocation.add(this.board[row + 2][col + 1]);
            // checks north + 2 and checks west one space
            if (row + 2 > -1 && row + 2 < 8 && col - 1 > -1 && col -1 < 8) {
                this.availableLocation.add(this.board[row + 2][col - 1]);
            }
            // checks 2 spaces west and one space east
            if (row+1 > -1 && row +1 < 8 && col - 2 > -1 && col -2 < 8){
                this.availableLocation.add(this.board[row+1][col-2]);

            }

            if (row-1 > -1 && row -1 < 8 && col - 2 > -1 && col -2 < 8){
                this.availableLocation.add(this.board[row-1][col-2]);

            }
            // checks 2 spaces east and 1 space north
            if (row+1 > -1 && row+1 < 8 && col + 2 > -1 && col + 2 < 8){
                this.availableLocation.add(this.board[row + 1][col+2]);

            }
            // checks 2 spaces east and 1 space south
            if (row-1 > -1 && row-1 < 8 && col + 2 > -1 && col + 2 < 8){
                this.availableLocation.add(this.board[row - 1][col+2]);

            }


            if (row > -2 && row -2 < 8 && col + 1 > -1 && col + 1 < 8)
                this.availableLocation.add(this.board[row-2][col + 1]);
            // check to the left
            if (row > -2 && row-2 < 8 && col + 1 > -1 && col +1 < 8) {
                this.availableLocation.add(this.board[row-2][col + 1]);
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
