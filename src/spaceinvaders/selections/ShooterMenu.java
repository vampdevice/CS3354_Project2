package spaceinvaders.selections;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import spaceinvaders.ImageSelection;
import spaceinvaders.MenuBarUI;
import spaceinvaders.ParentButton;
import spaceinvaders.SpaceInvadersUI;


public class ShooterMenu extends MenuBarUI implements ActionListener {
     //private static final String URL = null;
     private SpaceInvadersUI game;
     
         public ShooterMenu(SpaceInvadersUI game){
            this.game = game;
            JMenuItem shooterMenu = new JMenuItem("Shooter");
            MenuBarUI.menu.add(shooterMenu);
            shooterMenu.addActionListener(this);
         }
      
            @Override
             public void actionPerformed(ActionEvent e){
                JFrame shooterFrame = new JFrame("Shooter");
                shooterFrame.setSize(500,350);
                shooterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shooterFrame.setLocationRelativeTo(null);
                shooterFrame.setVisible(true);

        JPanel shooterPanel = new JPanel();

                JButton madotsuki = ParentButton.createButtonWithImage("Madotsuki", "src/spaceinvaders/resources/madotsuki.png");
                JButton huhCat = ParentButton.createButtonWithImage("Huh Cat", "src/spaceinvaders/resources/HUHCAT.png");
                JButton elGato = ParentButton.createButtonWithImage("El Gato", "src/spaceinvaders/resources/elGato.png");
                JButton newImage = ParentButton.createButtonWithImage("Add", "src/spaceinvaders/resources/newImage.png");
                
              madotsuki.addActionListener(click -> {
                  Image madotsukiImage = (Image) madotsuki.getClientProperty("iconImage");
                  game.setShooterImage(madotsukiImage);
              });
              
              huhCat.addActionListener(click -> {
                  Image huhCatImage = (Image) huhCat.getClientProperty("iconImage");
                  game.setShooterImage(huhCatImage);
              });
              
              elGato.addActionListener(click -> {
                  Image elGatoImage = (Image) elGato.getClientProperty("iconImage");
                  game.setShooterImage(elGatoImage);
              });

              newImage.addActionListener(click -> {
                game.setShooterImage(ImageSelection.loadImage("shooter","src/spaceinvaders/resources/newImage.png"));
            });
                
                shooterPanel.add(madotsuki);
                shooterPanel.add(huhCat);
                shooterPanel.add(elGato);
                shooterPanel.add(newImage);

                shooterFrame.add(shooterPanel);
                shooterPanel.setVisible(true);


                
            }

}

    
