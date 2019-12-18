import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class ABP {

    public ABP(){

    }

    private int heuristic(List<Piece> PiecesOnBoard){
        int queenValue = 100;
        int bishopValue = 30;
        int knightValue = 25;
        int rookValue = 20;
        int pawnValue = 5;

        int h = 0;

        for(int i = 0; i < PiecesOnBoard.size(); i++){
            Piece cur = PiecesOnBoard.get(i);
            if(cur.color.equals("black") ){
                switch (cur.name){
                    case "queen":
                        h += queenValue;

                    case "bishop":
                        h += bishopValue;

                    case "knight":
                        h += knightValue;

                    case "rook":
                        h += rookValue;

                    case "pawn":
                        h += pawnValue;
                }
            }
            if(cur.color.equals("white")){
                switch (cur.name){
                    case "queen":
                        h -= queenValue;

                    case "bishop":
                        h -= bishopValue;

                    case "knight":
                        h -= knightValue;

                    case "rook":
                        h -= rookValue;

                    case "pawn":
                        h -= pawnValue;
                }
            }
        }

        return h;
    }

}
