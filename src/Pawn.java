import java.awt.*;

public class Pawn extends Piece {

    private Image image;
    private int turn;


    Pawn(String name, String color, String location) {
        super (name, color, location);
        setupImage (file);


    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-pawn.png" : "black-pawn.png";
        loadImage (this.file);
    }

    @Override
    public void availableMoves() {
        this.availableLocation.clear ();
        //self.canAttack()
        int i;
        int j = this.index;
        //if its the first turn move 2 tiles
        if (this.turn == 0) {
            if (this.color.equals ("black")) {
                // TODO add funcationality to get code
                System.out.println ();
                //this.availableLocation.add ()
                //self.available_moves_list.append (self.board[i + 2][j])
            } else if (this.color.equals ("white")) {
                this.availableLocation.add (this.board[i - 1][j]);
                this.availableLocation.add (this.board[i - 2][j]);
            }

        } else {
            if (this.color.equals ("black")) {
                this.availableLocation.add (this.board[i + 1][j]);

            } else if (this.color.equals ("white")) {
                this.availableLocation.add (this.board[i - 1][j]);

            }

        }

    }

}
