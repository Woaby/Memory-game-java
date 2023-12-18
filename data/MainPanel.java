package data;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class MainPanel extends JPanel {

    public MainPanel() {
        this.setLayout(new GridLayout(4, 4, 10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(Color.WHITE);

        new GameLogic(this);
    }
}