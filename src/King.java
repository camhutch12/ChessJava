public class King extends Piece {
    public King(String name,String color) {
        super(name,color);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-king.png" : "black-king.png";
        loadImage(this.file);
    }
}
