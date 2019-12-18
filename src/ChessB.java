import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;


public class ChessB extends JPanel implements ActionListener {
    private static Scanner scanner = new Scanner(System.in);
    private Piece piece;
    Map<String, Rectangle> mapLocationToCords;
    java.util.List<Piece> pawnArray;
    Pair[][] pixelCords;
    java.util.List<Piece> black_pieces;
    java.util.List<Piece> whitePieces;
    java.util.List<Piece> allPiecesOnBoard = new ArrayList<Piece>();
    Point[][] x1_y1;
    Point[][] x2_y2;
    List tileBounds;
    Rectangle[][] cords;
    Piece selectedPiece;
    java.util.List<Rectangle> shadedTiles = new ArrayList<>();
    private String selectedPiece_loc;
    boolean playersTurn = true;
    String player1;
    String player2;
    boolean startGame = false;
    Button btn;
    Button btn2;
    Button btn3;
    boolean playerPreferanceClicked = false;
    Map<String,String> loadState;


    java.util.List<Piece> whitePiecesOnBoard;
    java.util.List<Piece> blackPiecesOnBoard;

    String[][] board_locations = {
            {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
            {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
            {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
            {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
            {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
            {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
            {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
            {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}};
    private boolean moveOccured;
    java.util.List<Rectangle> inCheckTiles = new ArrayList<>();


    public ChessB() {
        initStartMenu();
        initPieces();
        initUI();
    }
    private void temp(JButton button){
        this.add(button);
    }
    private void initStartMenu() {
        java.util.List<Integer> numList = new ArrayList<>();
        JButton button = new JButton("Click me");
        JButton pvpBtn = new JButton("PVP");
        JButton aiBtn = new JButton("Play Vs Computer");
        JButton loadFile = new JButton("Load File");
        SpinnerNumberModel spinnerNumberModel;
        Integer current = 2;
        Integer min = 1;
        Integer max = 5;
        Integer step = 1;
        spinnerNumberModel = new SpinnerNumberModel(current,min,max,step);
        JSpinner jSpinner = new JSpinner(spinnerNumberModel);
        JButton startAi = new JButton("Start Game");
        JButton testingBtn = new JButton("Testing");
        JTextField txtChooser = new JTextField(20);




        this.add(pvpBtn);
        pvpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO play PVP
                startGame = true;
                remove(button);
                remove(pvpBtn);
                remove(aiBtn);
                remove(testingBtn);
                remove(loadFile);
                remove(txtChooser);
                System.out.println("Start PVP");
                startGame = true;
                ChessB.super.validate();
                repaint();


            }
        });

        add(aiBtn);
        aiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Start Ai");
                remove(button);
                remove(pvpBtn);
                remove(aiBtn);
                remove(testingBtn);
                add(jSpinner);
                add(startAi);
                ChessB.super.validate();
                startAi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        startGame = true;
                        remove(startAi);
                        remove(jSpinner);
                        repaint();
                        ChessB.super.validate();
                    }
                });

                ChessB.super.validate();
            }
        });

        this.add(testingBtn);
        testingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            add(txtChooser);
            add(loadFile);
            validate();

            loadFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String txt = txtChooser.getText()+".txt";
                    System.out.println(txt);
                    try {
                        loadFile(txt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });



            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                playerPreferanceClicked = true;




                ChessB.super.validate();
            }
        });

        if (playerPreferanceClicked){

        this.remove(button);
        this.add(pvpBtn);
        this.add(aiBtn);
        }
        //this.remove(button);



    }


    private void saveFile(Map<String,String> locationsStates) throws IOException{
        try(FileWriter pieceAndLocations = new FileWriter("testFiles.txt");){

        }
    }

    private void loadFile(String fileName) throws IOException {
        this.loadState = new HashMap<>();
   try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))){
       scanner.useDelimiter(":");
        while (scanner.hasNext()){
            String peice = scanner.next();
            scanner.skip(scanner.delimiter());
            String location = scanner.next();
            scanner.nextLine();
            System.out.println("Importing Piece: " + peice + " Location: " + location);
        }
   }
   catch (IOException e){
       e.printStackTrace();
   }


    }

    private void gamePreferance(MouseEvent e){
        System.out.println();
    }

    private void initUI() {
        addMouseListener(new Tadapter());
        get_starting_points();
        setupMap();
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn("Pawn" + i, "white", board_locations[6][i]);
            pawn.setBoard(this.board_locations);


            int x = (int) ((double) pixelCords[6][i].x);
            int y = (int) ((double) pixelCords[6][i].y);
            pawn.setX(x);
            pawn.setY(y);
            pawnArray.add(pawn);
        }


        for (int i = 8; i < 16; i++) {
            Piece pawn = new Pawn("Pawn" + i, "black", board_locations[1][i - 8]);

            // System.out.println(pixelCords[1][i - 8].x + "were also printing y" + pixelCords[1][i - 8].y);
            int x = (int) ((double) pixelCords[1][i - 8].x);
            int y = (int) ((double) pixelCords[1][i - 8].y);
            //System.out.println(x + "were also printing y" + y);
            pawn.setX(x);
            pawn.setY(y);
            pawnArray.add(pawn);
        }

        for (int i = 0; i < 8; i++) {


            int x = (int) ((double) pixelCords[0][i].x);
            int y = (int) ((double) pixelCords[0][i].y);
            this.black_pieces.get(i).setX(x);
            this.black_pieces.get(i).setY(y);

            x = (int) ((double) pixelCords[7][i].x);
            y = (int) ((double) pixelCords[7][i].y);
            this.whitePieces.get(i).setX(x);
            this.whitePieces.get(i).setY(y);

        }

        allPiecesOnBoard.addAll(pawnArray);
        setUpIndex();
        this.setupPiecesLists();

        for (Piece piece1 : this.pawnArray) {
            ((Pawn) piece1).setupForPawnToQueenLists();
        }


    }

    // does the basic intilization of the Chess peices
    // this is all for the graphical interface
    private void initPieces() {
        this.allPiecesOnBoard = new ArrayList<>();
        this.blackPiecesOnBoard = new ArrayList<>();
        this.whitePiecesOnBoard = new ArrayList<>();
        mapLocationToCords = new HashMap<>();

        x1_y1 = new Point[8][8];
        x2_y2 = new Point[8][8];
        cords = new Rectangle[8][8];


        tileBounds = new List();

        this.pixelCords = new Pair[8][8];
        this.pawnArray = new ArrayList<>();
        this.black_pieces = new ArrayList<>();
        this.whitePieces = new ArrayList<>();

        // creates each chess peice Object
        this.black_pieces.add(0, new Rook("rook", "black", "a8"));
        this.black_pieces.add(1, new Knight("knight", "black", "b8"));
        this.black_pieces.add(2, new Bishop("bishop", "black", "c8"));
        this.black_pieces.add(3, new Queen("queen", "black", "d8"));
        this.black_pieces.add(4, new King("king", "black", "e8"));
        this.black_pieces.add(5, new Bishop("bishop", "black", "f8"));
        this.black_pieces.add(6, new Knight("knight", "black", "g8"));
        this.black_pieces.add(7, new Rook("rook", "black", "h8"));

        this.whitePieces.add(0, new Rook("rook", "white", "a1"));
        this.whitePieces.add(1, new Knight("knight", "white", "b1"));
        this.whitePieces.add(2, new Bishop("bishop", "white", "c1"));
        this.whitePieces.add(3, new Queen("queen", "white", "d1"));
        this.whitePieces.add(4, new King("king", "white", "e1"));
        this.whitePieces.add(5, new Bishop("bishop", "white", "f1"));
        this.whitePieces.add(6, new Knight("knight", "white", "g1"));
        this.whitePieces.add(7, new Rook("rook", "white", "h1"));

        this.allPiecesOnBoard.addAll(this.black_pieces);
        this.allPiecesOnBoard.addAll(this.whitePieces);


    }

    // does is sets up the index of where a location will be
    // both there rows and columns
    private void setUpIndex() {
        for (Piece p : allPiecesOnBoard) {
            for (int i = 0; i < board_locations.length; i++) {
                for (int j = 0; j < board_locations.length; j++) {
                    if (p.location.equals(board_locations[i][j])) {
                        p.row = i;
                        p.col = j;
                        p.setBoard(board_locations);
                    }
                }

            }
        }
    }

    // This function is used to intilize the map which consists of
    // the location, and the cordinate which relate to that location in the GUI
    private void setupMap() {
        for (int i = 0; i < board_locations.length; i++) {
            for (int j = 0; j < board_locations.length; j++) {
                mapLocationToCords.put(board_locations[i][j], cords[i][j]);
            }
        }
        System.out.println("working");
    }


    // this is function create two seperate list
    // one for the blackChess pieces
    // one for the whiteChess pieces
    private void setupPiecesLists() {
        for (Piece piece : this.allPiecesOnBoard) {
            if (piece.color.equals("black")) {
                this.blackPiecesOnBoard.add(piece);
            } else if (piece.color.equals("white")) {
                this.whitePiecesOnBoard.add(piece);
            }

        }

        Piece.setAllPiecesOnBoard(this.allPiecesOnBoard);
        Piece.setBlackPiecesOnBoard(this.blackPiecesOnBoard);
        Piece.setWhitePiecesOnBoard(this.whitePiecesOnBoard);
    }

    private void get_starting_points() {

        double w = Constants.width;
        double h = Constants.hieght;
        double startposX = 0;
        double startposY = 0;
        double heightPerSqaure = w / 8;
        // System.out.println(heightPerSqaure);
        double widthPerSqaure = h / 8;
        double middleWidth = widthPerSqaure / 2;
        //System.out.println(middleWidth);
        // System.out.println(widthPerSqaure);
        double middleHeight = middleWidth;
        // System.out.println(middleHeight + " is ");
        int count1 = 0;


        for (int i = 0; i < 8; i++) {
            int count2 = 0;
            for (int j = 0; j < 8; j++) {

                Rectangle rectangle = new Rectangle((int) startposX, (int) startposY, (int) widthPerSqaure, (int) heightPerSqaure);
                //  System.out.println(rectangle);
                cords[count1][count2] = rectangle;
                //Pair<Double, Double> points = new Pair (middleWidth, middleHeight);
                Pair<Double, Double> points;
                if (i == 6 || i == 7) {
                    //System.out.println(startposY+widthPerSqaure);
                    points = new Pair((startposX + widthPerSqaure - 30 + 0.0) - middleWidth, (startposY + 15) - middleWidth);

                } else {
                    points = new Pair((startposX + widthPerSqaure - 30 + 0.0) - middleWidth, (startposY + widthPerSqaure - 30) - middleWidth);

                }

                this.pixelCords[count1][count2] = points;

                startposX = widthPerSqaure * (j + 1);
                count2++;
            }

            //middleWidth = 10.7;

            count1++;
            //middleHeight += heightPerSqaure / 2 + 26 + i;
            startposX = 0;

            startposY = heightPerSqaure * (i + 1);


        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!this.startGame) {
            g.setColor(Color.lightGray);
            g.fillRect(0,0,Constants.width,Constants.hieght);
            g.setColor(Color.red);
            g.drawString("CHess Game", 150, 240);

        }
        else {
        drawBoard(g);
        doDraw(g);

        }
        Toolkit.getDefaultToolkit().sync();
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

        if (!this.shadedTiles.isEmpty()) {
            for (Rectangle r : this.shadedTiles
            ) {
                g2d.setColor(Color.MAGENTA);
//                System.out.println(r.getMinX() + " " + r.getMaxX());
//                System.out.println(r.getMinY() + "," + r.getMaxY());
//                System.out.println(r.getWidth() + " " + r.getHeight());
                g2d.fillRect(((int) r.getMinX()), ((int) r.getMinY()), (int) r.getWidth(), (int) r.getHeight());
            }
        }

        if (!this.inCheckTiles.isEmpty()) {
            for (Rectangle r : this.inCheckTiles
            ) {
                g2d.setColor(Color.MAGENTA);
//                System.out.println(r.getMinX() + " " + r.getMaxX());
//                System.out.println(r.getMinY() + "," + r.getMaxY());
//                System.out.println(r.getWidth() + " " + r.getHeight());
                g2d.fillRect(((int) r.getMinX()), ((int) r.getMinY()), (int) r.getWidth(), (int) r.getHeight());
            }
        }


    }


    private void make_sqaure_tile() {
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        int startposX = 0;
        int startposY = 0;
        int heightPerSqaure = (int) size.getHeight() / 8;
        int widthPerSqaure = (int) size.getWidth() / 8;


        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(startposX, startposY, widthPerSqaure, heightPerSqaure);
                System.out.println(rectangle);
                cords[i][j] = rectangle;

                startposX = widthPerSqaure * (j);
            }

            startposX = 0;
            startposY = heightPerSqaure * (i);

        }
    }

    private void doDraw(Graphics g) {
        Graphics2D g2g = (Graphics2D) g;
        for (int i = 0; i < this.pawnArray.size(); i++) {
            Piece piece1 = this.pawnArray.get(i);
            // System.out.println("print Piece one location:   " + piece1.getX() + " " + piece1.getY());
            g2g.drawImage(piece1.getImage(), piece1.x, piece1.y, this);

        }
        for (int i = 0; i < this.black_pieces.size(); i++)
            g2g.drawImage(this.black_pieces.get(i).getImage(), this.black_pieces.get(i).x, this.black_pieces.get(i).y, this);
        //   System.out.println(this.whitePieces.get(i).getX() + " y:" + this.whitePieces.get(i).y);
        for (int i = 0; i < this.whitePieces.size(); i++) {

            g2g.drawImage(this.whitePieces.get(i).getImage(), this.whitePieces.get(i).x, this.whitePieces.get(i).y, this);
        }



    }

    private void swapColor(Graphics2D g) {
        if (g.getColor() == Color.GREEN) {
            g.setColor(Color.CYAN);
        } else {
            g.setColor(Color.GREEN);

        }
    }

    public <K, V> Stream<K> keys(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Move");
        //piece.move ();
        repaint(piece.getX(), piece.getY(), piece.width, piece.height);
    }



    private void selectedPieceMove(Piece selectedPiece, Rectangle rectangle) {
        Piece piece = selectedPiece;
        String key = this.keys(this.mapLocationToCords, rectangle).findFirst().get();
        Piece otherPiece;

        if (piece.availableLocation.contains(key)) {
            if (containsPiece(key)) {
                otherPiece = getPiece(key);

            } else {
                otherPiece = null;
            }

            if (otherPiece == null) {

                piece.setX((int) rectangle.getX());
                piece.setY((int) rectangle.getY());
                this.moveOccured = true;
                this.moveOccured = true;
                int dis = piece.location.charAt(0);
                piece.move(key);

                int dis2 = piece.location.charAt(0);

                int horiDis = dis - dis2;

                String nam = String.valueOf(Arrays.copyOf(piece.name.toCharArray(), 4));

                if (nam.equals("Pawn")  && Math.abs(horiDis) == 1){
                    if(piece.color.equals("white") ){
                        char[] r = new char[2];
                        r[0] = piece.location.charAt(0);
                        int secPos = Integer.parseInt(String.valueOf(piece.location.charAt(1))) -1;
                        String strSecPos = Integer.toString(secPos);
                        r[1] = strSecPos.charAt(0);
                        System.out.println("r = "+String.valueOf(r));

                        Piece enemy = null;

                        for(Piece find : allPiecesOnBoard) {

                            String en = String.valueOf(Arrays.copyOf(find.name.toCharArray(), 4));

                            if(en.equals("Pawn") && find.location.equals(String.valueOf(r))) {

                                enemy = find;
                                break;
                            }
                        }

                        System.out.println("Need to remove other peice");
                        Piece.allPiecesOnBoard.remove(enemy);
                        this.allPiecesOnBoard.remove(enemy);

                        Piece.blackPiecesOnBoard.remove(enemy);
                        this.blackPiecesOnBoard.remove(enemy);

                        //     System.out.println(otherPiece.getClass());
                        //     System.out.println(otherPiece.getClass().isInstance("Pawn"));
                        removePawn(enemy);

                        this.black_pieces.remove(enemy);
                        this.shadedTiles.clear();


                        repaint();



                    }
                    if(piece.color.equals("black")){
                        char[] r = new char[2];
                        r[0] = piece.location.charAt(0);
                        int secPos = Integer.parseInt(String.valueOf(piece.location.charAt(1))) +1;
                        String strSecPos = Integer.toString(secPos);
                        r[1] = strSecPos.charAt(0);
                        System.out.println("r = "+String.valueOf(r));

                        Piece enemy = null;

                        for(Piece find : allPiecesOnBoard) {

                            String en = String.valueOf(Arrays.copyOf(find.name.toCharArray(), 4));

                            if(en.equals("Pawn") && find.location.equals(String.valueOf(r))) {

                                enemy = find;
                                break;
                            }
                        }

                        System.out.println("Need to remove other peice");
                        Piece.allPiecesOnBoard.remove(enemy);
                        this.allPiecesOnBoard.remove(enemy);

                        Piece.blackPiecesOnBoard.remove(enemy);
                        this.blackPiecesOnBoard.remove(enemy);

                        //     System.out.println(otherPiece.getClass());
                        //     System.out.println(otherPiece.getClass().isInstance("Pawn"));
                        removePawn(enemy);

                        this.black_pieces.remove(enemy);
                        this.shadedTiles.clear();


                        repaint();



                    }
                }

            } else {
                String oldLocation = piece.location;
                int oldX = piece.getX();
                int oldY = piece.getY();


                piece.setX((int) rectangle.getX());
                piece.setY((int) rectangle.getY());
                this.moveOccured = true;
                piece.move(key);

                if (piece.checkCollision(otherPiece)) {
                    System.out.println("Need to remove other peice");
                    Piece.allPiecesOnBoard.remove(otherPiece);
                    this.allPiecesOnBoard.remove(otherPiece);
                    if (otherPiece.color.equals("black")) {
                        Piece.blackPiecesOnBoard.remove(otherPiece);
                        this.blackPiecesOnBoard.remove(otherPiece);
                    } else if (otherPiece.color.equals("white")) {
                        Piece.whitePiecesOnBoard.remove(otherPiece);
                        this.whitePiecesOnBoard.remove(otherPiece);


                    }
                    //     System.out.println(otherPiece.getClass());
                    //     System.out.println(otherPiece.getClass().isInstance("Pawn"));
                    removePawn(otherPiece);


                    if (otherPiece.color.equals("white")) {
                        this.whitePieces.remove(otherPiece);
                        this.shadedTiles.clear();
                    } else if (otherPiece.color.equals("black")) {
                        this.black_pieces.remove(otherPiece);
                        this.shadedTiles.clear();
                    }

                    repaint();

                } else {
                    piece.location = oldLocation;
                    piece.setX(oldX);
                    piece.setY(oldY);
                    this.moveOccured = false;
                    piece.move(oldLocation);
                }

            }


        }

        checkConditions(piece);


    }

    private void removePawn(Piece otherPiece) {
        if (otherPiece instanceof Pawn) {
            this.pawnArray.remove(otherPiece);
            this.allPiecesOnBoard.remove(otherPiece);
            this.shadedTiles.clear();
        }
    }

    private void checkConditions(Piece piece) {

        King blackKing = null;
        King whiteKing = null;

        for (Piece p : this.allPiecesOnBoard) {
            if (p.name.equals("king") && p.color.equals("black")) {
                blackKing = ((King) p);
            } else if (p.name.equals("king") && p.color.equals("white")) {
                whiteKing = ((King) p);
            }
        }

        if (piece.color.equals("white")) {
            if (blackKing != null) {
                if (piece.checkHasOccured(blackKing)) {


                    shadeTilesRed(blackKing, blackKing.getX(), blackKing.getY());
                    repaint();

                }
            }


        } else if (piece.color.equals("black")) {
            if (whiteKing != null) {
                if (piece.checkHasOccured(whiteKing)) {
                    shadeTilesRed(whiteKing, whiteKing.getX(), whiteKing.getY());
                    repaint();

                }
            }
        }


        if (piece instanceof Pawn) {
            // this is for changing a Pawn to a queen
            if (pawnToQueen(piece)) {

                String newLocation = piece.location;
                int newX = piece.x;
                int newY = piece.y;
                int newRow = piece.row;
                int newCol = piece.col;
                //TODO
                Queen newQ = new Queen("queen", piece.color, piece.location);
                newQ.setX(newX);
                newQ.setY(newY);
                newQ.setRow(newRow);
                newQ.setCol(newCol);
                newQ.setLocation(newLocation);
                newQ.setBoard(this.board_locations);
                removePawn(piece);
                this.allPiecesOnBoard.add(newQ);
                if (newQ.color.equals("black")) {
                    this.black_pieces.add(newQ);

                } else if (newQ.color.equals("white")) {
                    this.whitePieces.add(newQ);
                }


            }


        }
    }


    private void shadeTilesRed(Piece clickedPiece, int posX, int posY) {

        if (clickedPiece != null) {
            System.out.println(clickedPiece);
            this.selectedPiece = clickedPiece;
            this.selectedPiece_loc = clickedPiece.location;


            if (this.inCheckTiles != null) {

                Rectangle rec = mapLocationToCords.get(clickedPiece.location);
//                    System.out.println("rec min in" + rec.getMinX() + "," + rec.getMinY());
//                    System.out.println("rec max in" + rec.getMaxX() + "," + rec.getMaxY());
                this.shadedTiles.add(rec);

            }

        }


    }


    private boolean pawnToQueen(Piece piece) {
        if (piece.color.equals("black")) {
            if (((Pawn) piece).getBlackToBeQueen().contains(piece.location)) {
                return true;
            }
            return false;
        } else if (piece.color.equals("white")) {
            if (((Pawn) piece).getWhiteToBeQueen().contains(piece.location)) {
                return true;
            }
        }

        return false;
    }

    private Piece getPiece(String key) {
        for (Piece p : this.allPiecesOnBoard
        ) {
            if (p.location.equals(key)) return p;
        }
        return null;
    }

    private boolean containsPiece(String key) {
        for (Piece p : this.allPiecesOnBoard
        ) {
            if (p.location.equals(key))
                return true;
        }
        return false;

    }

    private void shadeTiles(Piece clickedPiece, int posX, int posY) {
        this.shadedTiles.clear();
        if (clickedPiece != null) {
            System.out.println(clickedPiece);
            this.selectedPiece = clickedPiece;
            this.selectedPiece_loc = clickedPiece.location;
            clickedPiece.availableMoves();
            java.util.List<String> available_moves = clickedPiece.availableLocation;

            if (available_moves != null) {
                for (String s : available_moves) {
                    Rectangle rec = mapLocationToCords.get(s);
//                    System.out.println("rec min in" + rec.getMinX() + "," + rec.getMinY());
//                    System.out.println("rec max in" + rec.getMaxX() + "," + rec.getMaxY());
                    this.shadedTiles.add(rec);

                }
                System.out.println(available_moves.toString());
            }

        }
    }

    private class Tadapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
//            if (playersTurn){
//                //TODO
//                gameLogic(e);
//
//            }
//            else {
//                gameLogic(e);
//            }
            testingLogic(e);


        }

    }


    private void testingLogic(MouseEvent e) {
        Rectangle tile = null;
        Point newE = e.getPoint();
        newE.y += 0;
        for (Rectangle[] rec : cords) {
            if (tile != null) {
                break;
            }
            for (Rectangle r : rec) {
                //     System.out.println(r.getBounds());
                if (r.contains(newE.getLocation())) {
//                        System.out.println(e.getPoint());
//                        System.out.println(newE.getLocation());
//                        System.out.println ("True");

                    tile = r;
//                        System.out.println(tile.getMinX() + " min y " + tile.getMinY());
//                        System.out.println(tile.getMaxX() + " Max y " + tile.getMaxY());
                    break;
                }
            }
        }
        if (mapLocationToCords.containsValue(tile)) {
            Stream<String> key = keys(mapLocationToCords, tile);
            String loc = key.findFirst().get();
            System.out.println(loc);
            Piece clickedPiece = null;
            for (Piece p : allPiecesOnBoard) {
                if (loc.compareTo(p.location) == 0) {
                    clickedPiece = p;
//                        System.out.println ("print true");
                    break;

                }
            }
            // if playersTurn is true it is player1 turn
            // other wise it is player2 turn


            testingMainPlayerLogic(clickedPiece, tile);


        }


    }

    private void playGame() {
        String player1 = "white";
        String player2 = "black";
        boolean isCheckMate = false;
        while (!isCheckMate) {

        }
    }

    private void gameLogic(MouseEvent e) {
        Rectangle tile = null;
        Point newE = e.getPoint();
        newE.y += 0;
        for (Rectangle[] rec : cords) {
            if (tile != null) {
                break;
            }
            for (Rectangle r : rec) {
                //     System.out.println(r.getBounds());
                if (r.contains(newE.getLocation())) {
//                        System.out.println(e.getPoint());
//                        System.out.println(newE.getLocation());
//                        System.out.println ("True");

                    tile = r;
//                        System.out.println(tile.getMinX() + " min y " + tile.getMinY());
//                        System.out.println(tile.getMaxX() + " Max y " + tile.getMaxY());
                    break;
                }
            }
        }
        if (mapLocationToCords.containsValue(tile)) {
            Stream<String> key = keys(mapLocationToCords, tile);
            String loc = key.findFirst().get();
            System.out.println(loc);
            Piece clickedPiece = null;
            for (Piece p : allPiecesOnBoard) {
                if (loc.compareTo(p.location) == 0) {
                    clickedPiece = p;
//                        System.out.println ("print true");
                    break;

                }
            }
            // if playersTurn is true it is player1 turn
            // other wise it is player2 turn

            if (playersTurn) {
                mainPlayerLogic(clickedPiece, tile);
                if (moveOccured) {
                    playersTurn = false;
                    this.moveOccured = false;

                }


            } else if (!playersTurn) {
                mainPlayerLogic(clickedPiece, tile);
                if (moveOccured) {
                    playersTurn = true;
                    this.moveOccured = false;

                }
            }


        }
    }

    private void mainPlayerLogic(Piece clickedPiece, Rectangle tile) {
        if (clickedPiece != null) {
            if (playersTurn && clickedPiece.color.equals("white")) {

                int posX = clickedPiece.row;
                int posY = clickedPiece.col;

                if (selectedPiece_loc != null) {

                    selectedPieceMove(selectedPiece, tile);
                    selectedPiece_loc = null;

                }
                shadeTiles(clickedPiece, posX, posY);
            } else if (!playersTurn && clickedPiece.color.equals("black")) {

                int posX = clickedPiece.row;
                int posY = clickedPiece.col;

                if (selectedPiece_loc != null) {

                    selectedPieceMove(selectedPiece, tile);
                    selectedPiece_loc = null;

                }
                shadeTiles(clickedPiece, posX, posY);
            }


            repaint();


        } else if (selectedPiece_loc != null) {
            if (selectedPiece.color.equals("white") && playersTurn) {
                shadedTiles.clear();
                selectedPieceMove(selectedPiece, tile);
                selectedPiece_loc = null;
            } else if (selectedPiece.color.equals("black") && (!playersTurn)) {
                shadedTiles.clear();
                selectedPieceMove(selectedPiece, tile);
                selectedPiece_loc = null;
            }


            repaint();

        }
    }


    private void testingMainPlayerLogic(Piece clickedPiece, Rectangle tile) {
        if (clickedPiece != null) {
            int posX = clickedPiece.row;
            int posY = clickedPiece.col;

            if (selectedPiece_loc != null) {

                selectedPieceMove(selectedPiece, tile);
                selectedPiece_loc = null;

            }
            shadeTiles(clickedPiece, posX, posY);
            repaint();


        } else {


            shadedTiles.clear();
            selectedPieceMove(selectedPiece, tile);
            selectedPiece_loc = null;
            repaint();

        }
    }
}


