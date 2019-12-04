import java.awt.*;

public class Pawn extends Piece {

    private Image image;
    Pawn(String name, String color, String location) {
        super(name,color,location);
        setupImage(file);


    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-pawn.png" : "black-pawn.png";
        loadImage(this.file);
    }

}
