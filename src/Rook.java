public class Rook extends Piece {
    public Rook(String name,String color) {
        super(name, color);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-rooke.png" : "black-rook.png";
        loadImage(this.file);
    }
}
