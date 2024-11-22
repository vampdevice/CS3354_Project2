package spaceinvaders;

import javax.swing.*;
import java.awt.*;

public class ParentButton {

    public static JButton createButtonWithImage(String text, String imagePath) {
        JButton button = new JButton(text);
        
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        button.setIcon(resizedIcon);
        //button.setPreferredSize(new Dimension(200, 200));
        
        button.putClientProperty("iconImage", resizedImage);
        
        return button;
    }

    public static JButton createMusicButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 150));

        return button;
    }
}

