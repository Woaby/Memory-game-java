package data;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainButton extends JButton{

    String fruitImage;

    public void setFruitImage(String fruitImage){
        this.fruitImage = fruitImage;
    }

    public String getFruitImage(){
        return fruitImage;
    }

    public MainButton() {
        this.setBackground(Color.WHITE);
    }

    public void setBgImage(String imagePath) {
        ImageIcon image = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        this.setIcon(image);
    }
}
