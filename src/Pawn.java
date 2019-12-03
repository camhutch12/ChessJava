import java.awt.*;

public class Pawn extends Piece {

    private Image image;
    public Pawn(String name,String color) {
        super(name,color);
        setupImage(file);


    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-pawn.png" : "black-pawn.png";
        loadImage(this.file);
    }

}
