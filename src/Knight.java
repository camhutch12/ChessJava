public class Knight extends Piece {
    public Knight(String name,String color,String location) {
        super(name,color,location);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-knight.png" : "black-knight.png";
        loadImage(this.file);
    }
}
