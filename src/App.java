import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {

        initUI();
    }


    private void initUI() {
        add(new ChessB());
        setSize(600, 600);
        setTitle("Application");
        setResizable (false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);

        });
    }
}
