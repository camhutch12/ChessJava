import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChessB extends JPanel implements ActionListener {

    private Piece piece;
    Piece[] pawnArray;
    Pair[][] pixelCords;
    Piece[] black_pieces;
    Piece[] whitePieces;
    List tileBounds;

    public ChessB() {
       initPieces();
        initUI();
    }

    private void initPieces(){
        tileBounds = new List();

        this.pixelCords = new Pair[8][8];
        this.pawnArray = new Piece[16];
        this.black_pieces = new Piece[8];
        this.whitePieces = new Piece[8];


        this.black_pieces[0] = new Rook("rook", "black");
        this.black_pieces[1] = new Knight("knight", "black");
        this.black_pieces[2] = new Bishop("bishop", "black");
        this.black_pieces[3] = new Queen("queen", "black");
        this.black_pieces[4] = new King("king", "black");
        this.black_pieces[5] = new Bishop("bishop", "black");
        this.black_pieces[6] = new Knight("knight", "black");
        this.black_pieces[7] = new Rook("rook", "black");

        this.whitePieces[0] = new Rook("rook", "white");
        this.whitePieces[1] = new Knight("knight", "white");
        this.whitePieces[2] = new Bishop("bishop", "white");
        this.whitePieces[3] = new Queen("queen", "white");
        this.whitePieces[4] = new King("king", "white");
        this.whitePieces[5] = new Bishop("bishop", "white");
        this.whitePieces[6] = new Knight("knight", "white");
        this.whitePieces[7] = new Rook("rook", "white");

    }

    private void initUI() {
        addMouseListener(new Tadapter());
        get_starting_points();
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn("Pawn" + i, "white");

            int x = (int) ((double) pixelCords[6][i].x);
            int y = (int) ((double) pixelCords[6][i].y);
            pawn.setX(x);
            pawn.setY(y);
            pawnArray[i] = pawn;
        }


        for (int i = 8; i < 16; i++) {
            Piece pawn = new Pawn("Pawn" + i, "black");

            int x = (int) ((double) pixelCords[1][i - 8].x);
            int y = (int) ((double) pixelCords[1][i - 8].y);
            pawn.setX(x);
            pawn.setY(y);
            pawnArray[i] = pawn;
        }

        for (int i = 0; i < 8; i++) {


            int x = (int) ((double) pixelCords[0][i].x);
            int y = (int) ((double) pixelCords[0][i].y);
            this.black_pieces[i].setX(x);
            this.black_pieces[i].setY(y);

            x = (int) ((double) pixelCords[7][i].x);
            y = (int) ((double) pixelCords[7][i].y);
            this.whitePieces[i].setX(x);
            this.whitePieces[i].setY(y);

        }




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
        System.out.println(middleHeight + " is ");
        int count1 = 0;

        for (int i = 0; i < 8; i++) {
            int count2 = 0;
            for (int j = 0; j < 8; j++) {

                //middleWidth = (startposX + (widthPerSqaure) / 2);
                //middleHeight = (startposY + heightPerSqaure)/2;
                //middleHeight += heightPerSqaure/2;
                Pair<Double, Double> points = new Pair(middleWidth, middleHeight);
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
        super.paintComponent(g);
        drawBoard(g);
        doDraw(g);
    }


    private void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        int middleWidth;
        int middleHeight;
        int startposX = 0;
        int startposY = 0;
        int heightPerSqaure = (int) size.getHeight() / 8;
        int widthPerSqaure = (int) size.getWidth() / 8;

        g.setColor(Color.green);
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                swapColor(g2d);
                g2d.fillRect(startposX, startposY, widthPerSqaure, heightPerSqaure);
                middleWidth = (startposX + widthPerSqaure) / 2;
                middleHeight = (startposY + heightPerSqaure) / 2;


                startposX = widthPerSqaure * (j + 1);
            }
            swapColor(g2d);
            startposX = 0;
            startposY = heightPerSqaure * (i + 1);

        }


    }

    private void doDraw(Graphics g) {
        Graphics2D g2g = (Graphics2D) g;
        for (int i = 0; i < this.pawnArray.length; i++) {
            Piece piece1 = this.pawnArray[i];
           // System.out.println("print Piece one location:   " + piece1.getX() + " " + piece1.getY());
            g2g.drawImage(piece1.getImage(), piece1.x, piece1.y, this);

        }
        for(int i =0; i<8; i++){
            g2g.drawImage(this.black_pieces[i].getImage(),this.black_pieces[i].x,this.black_pieces[i].y,this);
            g2g.drawImage(this.whitePieces[i].getImage(),this.whitePieces[i].x,this.whitePieces[i].y,this);
        }






    }

    private void swapColor(Graphics2D g) {
        if (g.getColor() == Color.GREEN) {
            g.setColor(Color.CYAN);
        } else {
            g.setColor(Color.GREEN);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Move");
        piece.move();
        repaint(piece.getX(), piece.getY() - 1, piece.width, piece.height);
    }

    private class Tadapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
        for(int i =0; i<pawnArray.length; i++){
            Rectangle p1 = pawnArray[i].getBounds();
            Point p =  e.getPoint();
            System.out.println(p1.contains(p.getX(),p.getY()));
            System.out.println("YYYYYYYYYY");
            System.out.println(p1.getX() == p.getX());
            System.out.println(p1.y + " : p= " + p.getY());

            if(p.getX() >= p1.getX() && p.getX() < pawnArray[i+1].getBounds().getX() && p.getY() >= p1.getY() && p.getY() < pawnArray[i+1].getBounds().getY() ){

                System.out.println(pawnArray[i].name);
                Piece click_piece = pawnArray[i];
                click_piece.move();
                System.out.println("TRUE");
            }


        }

//            for (int i = 0; i < pixelCords.length; i++) {
//                for (int j = 0; j < pixelCords.length; j++) {
//
//                    Pair pair = pixelCords[i][j];
//                    if (r.contains((double)pair.x, (Double) pair.y)){
//                        System.out.println("It is there my friend");
//                    }
//                    else
//                    {
//                        System.out.println("NO");
//                    }
                //}
            //}




            //repaint(pawnArray[0].getX(), pawnArray[0].getY() - 1, pawnArray[0].width, pawnArray[0].height);
            //repaint();
        }


    }




}
