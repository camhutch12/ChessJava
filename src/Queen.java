public class Queen extends Piece {
    public Queen(String name,String color) {
        super(name,color);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-queen.png" : "black-queen.png";
        loadImage(this.file);
    }
}
