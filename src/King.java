public class King extends Piece {
    public King(String name,String color,String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-king.png" : "black-king.png";
        loadImage(this.file);
    }
}
