package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;

public class GameLogic {

    private int clickCount = 0; // Begin state
    private int pairsMatched = 0;
    private MainButton firstClickedButton = null;
    private List<Integer> number = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8));
    private String[] imagePaths = {
        "data/images/apple.png", "data/images/avocado.png", "data/images/banana.png", "data/images/genipe.png",
        "data/images/mandarin.png", "data/images/orange.png", "data/images/pumpkin.png", "data/images/watermelon.png"
    };
    private JPanel panel;

    public GameLogic(JPanel panel) {
        this.panel = panel;
        Collections.shuffle(number);
        initializeButtons();
    }

    private void initializeButtons() {
        // Begin state voor de buttons
        for (int buttonAmount = 0; buttonAmount < 16; buttonAmount++) {
            int imageCount = number.get(buttonAmount) - 1;
            MainButton button = new MainButton();
            button.setFruitImage(imagePaths[imageCount]);
            button.setName(Integer.toString(buttonAmount));
            panel.add(button);

            button.addActionListener(ac);
        }
    }

    public void resetGame() {
        clickCount = 0; // Begin state
        pairsMatched = 0;
        number.clear();
        number.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8));
        Collections.shuffle(number);

        panel.removeAll();
        initializeButtons();
        
        panel.revalidate();
        panel.repaint();
    }

    ActionListener  ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clickCount++;
            System.out.println(clickCount);

            MainButton button = (MainButton)e.getSource();

            if (clickCount == 1) {
                firstClickedButton = button;
                button.setBgImage(button.getFruitImage());
            } 

            if (clickCount == 2) {
                button.setBgImage(button.getFruitImage());

                if (firstClickedButton != button && button.getFruitImage().equals(firstClickedButton.getFruitImage())) {
                    // Als zee gelijk zijn worden de buttens gedisabled.
                    System.out.println("Dit klopt");
                    button.setEnabled(false);
                    firstClickedButton.setEnabled(false);
                    pairsMatched++;
                    
                    if (pairsMatched == 8) { // Als alles gelijk is krijg je een succes message en word de game gereset.
                        JOptionPane.showMessageDialog(panel, "You won!");
                        resetGame();
                    }
                    clickCount = 0; // reset the clickcount als het 2 is
                    firstClickedButton = null;
                } else {
                    // Timer met 2 sec delay
                    Timer t = new Timer(1000, event -> {
                        System.out.println("Dit klopt niet");
                        firstClickedButton.setBgImage(null);
                        button.setBgImage(null);
                        clickCount = 0;
                        firstClickedButton = null;
                    });

                    t.start();
                    t.setRepeats(false); // Zorgt ervoor dat de timer maar een keer word uitgevoerd
                }
            }
        }
    };
}