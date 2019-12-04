import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public abstract class Piece extends MouseAdapter {
    private Image image;
    int row,col;
    int x,y;
    int dy,dx;
    int width,height;
    String file;
    String color;
    String name;
    String location;
    List<String> availableLocation;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public  abstract void availableMoves();

    public Piece(String name,String color, String location ) {
        this.x = 10;
        this.y = 20;
        this.color =  color;
        this.name = name;
        this.location = location;

    }

    public void loadImage(String file){
        ImageIcon ii = new ImageIcon(file);
        image = ii.getImage();
        image = image.getScaledInstance((image.getWidth(null)/2), (image.getHeight(null)/2), Image.SCALE_DEFAULT);
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);

    }

    public void ontouch(MouseEvent e){
         dy =  30;
    }

    public void move(){
        y += 50;
    }

    public abstract void setupImage(String file);

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.equals(this)){
            System.out.println("True");


        }

        System.out.println("Hii");
    }


        public Rectangle getBounds(){
            return new Rectangle(x-10,y-10,width,height);

        }


}
