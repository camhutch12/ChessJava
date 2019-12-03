public class Bishop extends Piece{
    public Bishop(String name,String color) {
        super(name,color);
        setupImage(file);
    }

    @Override
    public void setupImage(String file) {
        this.file = this.color == "white" ? "white-bishop.png" : "black-bishop.png";
        loadImage(this.file);
    }
}
