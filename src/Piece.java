import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Piece extends MouseAdapter {
    private Image image;
    int row, col;
    int x, y;
    int dy, dx;
    int width, height;
    int turn;
    String file;
    String color;
    String name;
    String location;
    List<String> availableLocation;
    String[][] board;
    static List<Piece> allPiecesOnBoard;
    static List<Piece> blackPiecesOnBoard;
    static List<Piece> whitePiecesOnBoard;
    Map<String,Piece> canAttack;




    public Piece(String name, String color, String location) {
        this.x = 0;
        this.y = 0;
        this.turn = 0;
        this.color = color;
        this.name = name;
        this.location = location;
        availableLocation = new ArrayList<> ();
        this.board = getBoard ();
        allPiecesOnBoard = new ArrayList<>();
        blackPiecesOnBoard = new ArrayList<>();
        whitePiecesOnBoard = new ArrayList<>();
        this.canAttack = new HashMap<>();
    }


    public List<Piece> getAllPiecesOnBoard() {
        return allPiecesOnBoard;
    }


    public static void setAllPiecesOnBoard(List<Piece> allPiecesOnBoard) {

        Piece.allPiecesOnBoard = allPiecesOnBoard;
    }

    public List<Piece> getBlackPiecesOnBoard() {
        return blackPiecesOnBoard;
    }

    public static void setBlackPiecesOnBoard(List<Piece> blackPiecesOnBoard) {

        Piece.blackPiecesOnBoard = blackPiecesOnBoard;
    }

    public List<Piece> getWhitePiecesOnBoard() {
        return whitePiecesOnBoard;
    }

    public static void setWhitePiecesOnBoard(List<Piece> whitePiecesOnBoard) {

        Piece.whitePiecesOnBoard = whitePiecesOnBoard;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getAvailableLocation() {
        return availableLocation;
    }

    public void setAvailableLocation(List<String> availableLocation) {
        this.availableLocation = availableLocation;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Image getImage() {
        return image;
    }

    public void getIndex(int row, int col) {
        this.row = row;
        this.col = col;
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


    public abstract void availableMoves();



    public void loadImage(String file) {
        ImageIcon ii = new ImageIcon (file);
        image = ii.getImage ();
        image = image.getScaledInstance ((image.getWidth (null) / 2), (image.getHeight (null) / 2), Image.SCALE_DEFAULT);
        this.width = image.getWidth (null);
        this.height = image.getHeight (null);


    }

    public void ontouch(MouseEvent e) {
        dy = 30;
    }

    public void move(String key) {
        int pos1 = this.location.charAt(0);
        this.location = key;
        setIndex ();
        int pos2 = this.location.charAt(0);

        int dis = pos1-pos2;

        System.out.println("name = "+this.name+", turn = "+this.turn+", dis = "+dis);

        if(this.name == "king" && this.turn == 0 && Math.abs(dis) == 2){
            //king moved right

            Piece onB;
            List<Piece> friendlies = allPiecesOnBoard;
            if(this.color == "white"){
                friendlies = whitePiecesOnBoard;
            }
            if(this.color == "black"){
                friendlies = blackPiecesOnBoard;
            }

            if(dis == 2){
                for(int i = 0; i < friendlies.size(); i++) {
                    onB = friendlies.get(i);
                    char[] rPos = new char[2];
                    char[] newPos = new char[2];
                    rPos[0] = 'a';
                    newPos[0] = 'd';
                    rPos[1] = this.location.charAt(1);
                    newPos[1] = this.location.charAt(1);
                    String newP = String.valueOf(rPos);
                    if(onB.name == "rook" && onB.location.equals(newP)){
                        int x1 = Constants.width/8;
                        int y1 = Constants.hieght/8;
                        //distances from 0,0 aka a1
                        int disX = ((int) newPos[0])-((int) 'a');
                        int disY = ((int) '8')-((int) newPos[1]);
                        //
                        onB.setX((x1*disX));
                        onB.setY(y1*disY);
                        onB.move(String.valueOf(newPos));
                    }
                }
            }
            //king moved left
            if(dis == -2){
                for(int i = 0; i < friendlies.size(); i++) {
                    onB = friendlies.get(i);
                    char[] rPos = new char[2];
                    char[] newPos = new char[2];
                    rPos[0] = 'h';
                    newPos[0] = 'f';
                    rPos[1] = this.location.charAt(1);
                    newPos[1] = this.location.charAt(1);
                    String newP = String.valueOf(rPos);
                    if(onB.name == "rook" && onB.location.equals(newP)){
                        int x1 = Constants.width/8;
                        int y1 = Constants.hieght/8;
                        //distances from 0,0 aka a1
                        int disX = ((int) newPos[0])-((int) 'a');
                        int disY = ((int) '8')-((int) newPos[1]);
                        //
                        onB.setX((x1*disX));
                        onB.setY(y1*disY);
                        onB.move(String.valueOf(newPos));
                    }
                }
            }
        }

        this.turn++;
    }

    public abstract void setupImage(String file);

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked (e);
        if (e.equals (this)) {
            System.out.println ("True");


        }

        System.out.println ("Hii");
    }


    public Rectangle getBounds() {
        return new Rectangle (x , y, 75, 75);

    }

    public boolean checkCollision(Piece otherPiece){
        Rectangle currentRec = this.getBounds();
        Rectangle otherRec = otherPiece.getBounds();

        if (currentRec.intersects(otherRec)){
            System.out.println("A Collision has occued");
            System.out.println(otherPiece.location + " OtherPiece is " + otherPiece);
            return true;
        }

        else {
            return false;
        }



    }




    public void checkPieces() {
        List<Piece> pplist = new ArrayList<>();
        for (Piece piece :
                Piece.allPiecesOnBoard) {
            if (this.availableLocation.contains(piece.location)) {
                for (String p :
                        this.availableLocation) {
                    if (p.equals(piece.location)) {
                        System.out.println(piece.location + "This current Piece is " + p);
                        pplist.add(piece);
                    }
                }
            }
        }
        this.modifyAvailbaleMovesList(pplist);

    }

    public void modifyAvailbaleMovesList(List<Piece> allPiecesList) {
        for (Piece p :
                allPiecesList) {
            if (this.color.equals("white")) {
                if (p.color.equals("white")) {
                    this.availableLocation.removeIf(s -> p.location.equals(s));

                } else if (this.color.equals("black")) {

                }
            }

        }
    }

    public void setIndex(){
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j].equals (this.location)){
                    this.row = i;
                    this.col = j;
                    break;
                }

            }

        }
    }


}
