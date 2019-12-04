public class Rook extends Piece {
    @Override
    public void availableMoves() {
        System.out.println ();
    }

    public Rook(String name, String color, String location) {
        super(name, color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-rooke.png" : "black-rook.png";
        loadImage(this.file);
    }
}
