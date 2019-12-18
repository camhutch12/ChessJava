import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {

        initUI();
    }


    private void initUI() {

        add(new ChessB());

        setSize(620, 600);
        //setPreferredSize(new Dimension(600,600));
        setTitle("Application");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
            System.out.println(ex.getSize());


        });
    }
}
