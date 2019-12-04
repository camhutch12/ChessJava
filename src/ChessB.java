import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class ChessB extends JPanel implements ActionListener {

    private Piece piece;
    Map<String, Rectangle> mapLocationToCords;
    Piece[] pawnArray;
    Pair[][] pixelCords;
    Piece[] black_pieces;
    Piece[] whitePieces;
    java.util.List<Piece> allPiecesOnBoard = new ArrayList<Piece> ();
    Point[][] x1_y1;
    Point[][] x2_y2;
    List tileBounds;
    Rectangle[][] cords;
    Piece selectedPiece;
    java.util.List<Rectangle> shadedTiles = new ArrayList<> ();
    private String selectedPiece_loc;

    String[][] board_locations = {
            {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
            {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
            {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
            {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
            {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
            {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
            {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
            {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}};


    public ChessB() {
        initPieces ();
        initUI ();
    }

    private void initPieces() {

        mapLocationToCords = new HashMap<> ();

        x1_y1 = new Point[8][8];
        x2_y2 = new Point[8][8];
        cords = new Rectangle[8][8];


        tileBounds = new List ();

        this.pixelCords = new Pair[8][8];
        this.pawnArray = new Piece[16];
        this.black_pieces = new Piece[8];
        this.whitePieces = new Piece[8];


        this.black_pieces[0] = new Rook ("rook", "black", "a8");
        this.black_pieces[1] = new Knight ("knight", "black", "b8");
        this.black_pieces[2] = new Bishop ("bishop", "black", "c8");
        this.black_pieces[3] = new Queen ("queen", "black", "d8");
        this.black_pieces[4] = new King ("king", "black", "e8");
        this.black_pieces[5] = new Bishop ("bishop", "black", "f8");
        this.black_pieces[6] = new Knight ("knight", "black", "g8");
        this.black_pieces[7] = new Rook ("rook", "black", "h8");

        this.whitePieces[0] = new Rook ("rook", "white", "a1");
        this.whitePieces[1] = new Knight ("knight", "white", "b1,");
        this.whitePieces[2] = new Bishop ("bishop", "white", "c1");
        this.whitePieces[3] = new Queen ("queen", "white", "d1");
        this.whitePieces[4] = new King ("king", "white", "e1");
        this.whitePieces[5] = new Bishop ("bishop", "white", "f1");
        this.whitePieces[6] = new Knight ("knight", "white", "g1");
        this.whitePieces[7] = new Rook ("rook", "white", "h1");

        this.allPiecesOnBoard.addAll (Arrays.asList (this.black_pieces));
        this.allPiecesOnBoard.addAll (Arrays.asList (this.whitePieces));


    }

    private void setUpIndex() {
        for (Piece p : allPiecesOnBoard) {
            for (int i = 0; i < board_locations.length; i++) {
                for (int j = 0; j < board_locations.length; j++) {
                    if (p.location.equals (board_locations[i][j])) {
                        p.row = i;
                        p.col = j;
                        p.setBoard (board_locations);
                    }
                }

            }
        }
    }

    private void setupMap() {
        for (int i = 0; i < board_locations.length; i++) {
            for (int j = 0; j < board_locations.length; j++) {
                mapLocationToCords.put (board_locations[i][j], cords[i][j]);
            }
        }
    }

    private void initUI() {
        addMouseListener (new Tadapter ());
        get_starting_points ();
        setupMap ();
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn ("Pawn" + i, "white", board_locations[6][i]);
            pawn.setBoard (this.board_locations);


            int x = (int) ((double) pixelCords[6][i].x);
            int y = (int) ((double) pixelCords[6][i].y);
            pawn.setX (x);
            pawn.setY (y);
            pawnArray[i] = pawn;
        }


        for (int i = 8; i < 16; i++) {
            Piece pawn = new Pawn ("Pawn" + i, "black", board_locations[1][i - 8]);

            int x = (int) ((double) pixelCords[1][i - 8].x);
            int y = (int) ((double) pixelCords[1][i - 8].y);
            pawn.setX (x);
            pawn.setY (y);
            pawnArray[i] = pawn;
        }

        for (int i = 0; i < 8; i++) {


            int x = (int) ((double) pixelCords[0][i].x);
            int y = (int) ((double) pixelCords[0][i].y);
            this.black_pieces[i].setX (x);
            this.black_pieces[i].setY (y);

            x = (int) ((double) pixelCords[7][i].x);
            y = (int) ((double) pixelCords[7][i].y);
            this.whitePieces[i].setX (x);
            this.whitePieces[i].setY (y);

        }

        allPiecesOnBoard.addAll (Arrays.asList (pawnArray));
        setUpIndex ();


    }

    private void get_starting_points() {

        double w = 600;
        double h = 550;
        double middleWidth = 0;
        double startposX = 0;
        double startposY = 0;
        double heightPerSqaure = w / 8;
        double widthPerSqaure = h / 8;
        double middleHeight = 20;
        System.out.println (middleHeight + " is ");
        int count1 = 0;

        for (int i = 0; i < 8; i++) {
            int count2 = 0;
            for (int j = 0; j < 8; j++) {

                //middleWidth = (startposX + (widthPerSqaure) / 2);
                //middleHeight = (startposY + heightPerSqaure)/2;
                //middleHeight += heightPerSqaure/2;
                Rectangle rectangle = new Rectangle ((int) startposX, (int) startposY, (int) widthPerSqaure, (int) heightPerSqaure);
                System.out.println (rectangle);
                cords[i][j] = rectangle;
                Pair<Double, Double> points = new Pair (middleWidth, middleHeight);
                middleWidth += 75;
                this.pixelCords[count1][count2] = points;
                startposX = widthPerSqaure * (j + 1);
                count2++;
            }

            middleWidth = 10.7;

            count1++;
            middleHeight += heightPerSqaure / 2 + 26 + i;
            startposX = 0;
            startposY = heightPerSqaure * (i + 1);

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent (g);
        drawBoard (g);
        doDraw (g);
    }


    private void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        RenderingHints rh = new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put (RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints (rh);
        Dimension size = getSize ();
        double w = size.getWidth ();
        double h = size.getHeight ();
        int middleWidth;
        int middleHeight;
        int startposX = 0;
        int startposY = 0;
        int heightPerSqaure = (int) size.getHeight () / 8;
        int widthPerSqaure = (int) size.getWidth () / 8;

        g.setColor (Color.green);
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                swapColor (g2d);
                g2d.fillRect (startposX, startposY, widthPerSqaure, heightPerSqaure);
                middleWidth = (startposX + widthPerSqaure) / 2;
                middleHeight = (startposY + heightPerSqaure) / 2;


                startposX = widthPerSqaure * (j + 1);
            }
            swapColor (g2d);
            startposX = 0;
            startposY = heightPerSqaure * (i + 1);

        }

        if(!this.shadedTiles.isEmpty ()){
            for (Rectangle r:this.shadedTiles
                 ) {
                g2d.setColor (Color.MAGENTA);
                g2d.fillRect (r.x + 5,r.y + 10,r.width,r.height);
            }
        }


    }


    private void make_sqaure_tile() {
        Dimension size = getSize ();
        double w = size.getWidth ();
        double h = size.getHeight ();
        int startposX = 0;
        int startposY = 0;
        int heightPerSqaure = (int) size.getHeight () / 8;
        int widthPerSqaure = (int) size.getWidth () / 8;


        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle (startposX, startposY, widthPerSqaure, heightPerSqaure);
                System.out.println (rectangle);
                cords[i][j] = rectangle;

                startposX = widthPerSqaure * (j);
            }

            startposX = 0;
            startposY = heightPerSqaure * (i);

        }
    }

    private void doDraw(Graphics g) {
        Graphics2D g2g = (Graphics2D) g;
        for (int i = 0; i < this.pawnArray.length; i++) {
            Piece piece1 = this.pawnArray[i];
            // System.out.println("print Piece one location:   " + piece1.getX() + " " + piece1.getY());
            g2g.drawImage (piece1.getImage (), piece1.x, piece1.y, this);

        }
        for (int i = 0; i < 8; i++) {
            g2g.drawImage (this.black_pieces[i].getImage (), this.black_pieces[i].x, this.black_pieces[i].y, this);
            g2g.drawImage (this.whitePieces[i].getImage (), this.whitePieces[i].x, this.whitePieces[i].y, this);
        }


    }

    private void swapColor(Graphics2D g) {
        if (g.getColor () == Color.GREEN) {
            g.setColor (Color.CYAN);
        } else {
            g.setColor (Color.GREEN);

        }
    }

    public <K, V> Stream<K> keys(Map<K, V> map, V value) {
        return map
                .entrySet ()
                .stream ()
                .filter (entry -> value.equals (entry.getValue ()))
                .map (Map.Entry::getKey);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println ("Move");
        //piece.move ();
        repaint (piece.getX (), piece.getY () - 1, piece.width, piece.height);
    }

    private class Tadapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle tile = null;
            for (Rectangle[] rec : cords) {
                for (Rectangle r : rec) {
                    if (r.contains (e.getPoint ())) {
                        System.out.println ("True");
                        ;
                        tile = r;
                    }
                }
            }



            if (mapLocationToCords.containsValue (tile)) {
                Stream<String> key = keys (mapLocationToCords, tile);
                String loc = key.findFirst ().get ();
                System.out.println (loc);
                Piece clickedPiece = null;
                for (Piece p : allPiecesOnBoard) {
                    if (loc.compareTo (p.location) == 0) {
                        clickedPiece = p;
                        System.out.println ("print true");
                        break;

                    }
                }

                if (clickedPiece != null ) {
                    int posX = clickedPiece.row;
                    int posY = clickedPiece.col;

                    if (selectedPiece_loc != null) {

                        selectedPieceMove(selectedPiece,tile);
                        selectedPiece_loc = null;

                    }

                    shadeTiles (clickedPiece, posX, posY);
                    repaint ();


                }

                else if (selectedPiece_loc != null){
                    shadedTiles.clear ();
                    selectedPieceMove(selectedPiece,tile);
                    selectedPiece_loc = null;

                    repaint ();

                }


            }

        }


    }

    private void selectedPieceMove(Piece selectedPiece,Rectangle rectangle ) {
        Piece piece = selectedPiece;
      String key = this.keys (this.mapLocationToCords,rectangle).findFirst ().get ();
        Piece otherPiece;
      if (containsPiece(key)){
         otherPiece = getPiece(key);

      }
      else {
          otherPiece = null;
      }

      if (otherPiece == null){
          piece.location = key;
          piece.setX ((int)rectangle.getX ());
          piece.setY ((int) rectangle.getY ());
          piece.move (key);

      }




    }

    private Piece getPiece(String key) {
        for (Piece p :this.allPiecesOnBoard
        ) {
            if (p.location.equals (key)) return p;
        }
        return null;
    }

    private boolean containsPiece(String key) {
        for (Piece p :this.allPiecesOnBoard
             ) {
            if (p.location.equals (key)) return true;
        }
        return false;

    }

    private void shadeTiles(Piece clickedPiece, int posX, int posY) {
        this.shadedTiles.clear ();
        if (clickedPiece != null) {
            System.out.println (clickedPiece);
             this.selectedPiece = clickedPiece;
             this.selectedPiece_loc = clickedPiece.location;
            clickedPiece.availableMoves ();
            java.util.List<String> available_moves = clickedPiece.availableLocation;

            if (available_moves != null){
                for(String s : available_moves){
                    Rectangle rec = mapLocationToCords.get (s);
                    this.shadedTiles.add(rec);

                }
                System.out.println (available_moves.toString ());
            }

        }
    }


}


