package data;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public MainWindow(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(new MainPanel());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
