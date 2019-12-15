public class Bishop extends Piece{
    @Override
    public void availableMoves() {
    this.availableLocation.clear();

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



            // Check diagnol going forward


            // check diagnol going backwards,

            // check diagnol going left

            // check diagnol going right





    }

    public Bishop(String name, String color, String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color.equals ("white") ? "white-bishop.png" : "black-bishop.png";
        loadImage(this.file);
    }
}