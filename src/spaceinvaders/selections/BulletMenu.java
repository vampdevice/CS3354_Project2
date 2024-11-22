package spaceinvaders.selections;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import spaceinvaders.ImageSelection;
import spaceinvaders.MenuBarUI;
import spaceinvaders.ParentButton;
import spaceinvaders.SpaceInvadersUI;


public class BulletMenu extends MenuBarUI implements ActionListener{
     //private static final String URL = null;
     private SpaceInvadersUI game;
     
         public BulletMenu(SpaceInvadersUI game){
            this.game = game;
            JMenuItem BulletMenu = new JMenuItem("Bullet");
            MenuBarUI.menu.add(BulletMenu);
            BulletMenu.addActionListener(this);
         }
      
            @Override
             public void actionPerformed(ActionEvent e){
                JFrame bulletFrame = new JFrame("Bullet");
                bulletFrame.setSize(500,350);
                bulletFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                bulletFrame.setLocationRelativeTo(null);
                bulletFrame.setVisible(true);

        JPanel bulletPanel = new JPanel();

                JButton arrow = ParentButton.createButtonWithImage("Arrow", "src/spaceinvaders/resources/arrow.png");
                JButton circle = ParentButton.createButtonWithImage("Circle", "src/spaceinvaders/resources/circle.png");
                JButton rectangle = ParentButton.createButtonWithImage("Rectangle", "src/spaceinvaders/resources/rectangle.png");
                JButton newImage = ParentButton.createButtonWithImage("Add", "src/spaceinvaders/resources/newImage.png");
                
              arrow.addActionListener(click -> {
                  Image arrowImage = (Image) arrow.getClientProperty("iconImage");
                  game.setBulletImage(arrowImage);
              });
              
              circle.addActionListener(click -> {
                  Image circleImage = (Image) circle.getClientProperty("iconImage");
                  game.setBulletImage(circleImage);
              });
              
              rectangle.addActionListener(click -> {
                  Image rectagleImage = (Image) rectangle.getClientProperty("iconImage");
                  game.setBulletImage(rectagleImage);
              });

              newImage.addActionListener(click -> {
                game.setShooterImage(ImageSelection.loadImage("shooter","src/spaceinvaders/resources/newImage.png"));
            });
                
                bulletPanel.add(arrow);
                bulletPanel.add(circle);
                bulletPanel.add(rectangle);
                bulletPanel.add(newImage);

                bulletFrame.add(bulletPanel);
                bulletPanel.setVisible(true);


                
            }

}
