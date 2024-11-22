package spaceinvaders.selections;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import spaceinvaders.ImageSelection;
import spaceinvaders.MenuBarUI;
import spaceinvaders.ParentButton;
import spaceinvaders.SpaceInvadersUI;


public class InvaderSelection extends MenuBarUI implements ActionListener {
     //private static final String URL = null;
     private SpaceInvadersUI game;
     
         public InvaderSelection(SpaceInvadersUI game){
            this.game = game;
            JMenuItem InvaderMenu = new JMenuItem("Invader");
            MenuBarUI.menu.add(InvaderMenu);
            InvaderMenu.addActionListener(this);
         }
      
            @Override
             public void actionPerformed(ActionEvent e){
                JFrame invaderFrame = new JFrame("Invader");
                invaderFrame.setSize(500,350);
                invaderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                invaderFrame.setLocationRelativeTo(null);
                invaderFrame.setVisible(true);

                JPanel invaderPanel = new JPanel();

                JButton ubao = ParentButton.createButtonWithImage("Ubao", "src/spaceinvaders/resources/Ubao.png");
                JButton cricket = ParentButton.createButtonWithImage("Cricket", "src/spaceinvaders/resources/cricket.png");
                JButton creeper = ParentButton.createButtonWithImage("Creeper", "src/spaceinvaders/resources/creeper.png");
                JButton newImage = ParentButton.createButtonWithImage("Add", "src/spaceinvaders/resources/newImage.png");
                
                ubao.addActionListener(click -> {
                  Image ubaoImage = (Image) ubao.getClientProperty("iconImage");
                  game.setInvaderImage(ubaoImage);
              });
              
              cricket.addActionListener(click -> {
                  Image cricketImage = (Image) cricket.getClientProperty("iconImage");
                  game.setInvaderImage(cricketImage);
              });
              
              creeper.addActionListener(click -> {
                  Image creeperImage = (Image) creeper.getClientProperty("iconImage");
                  game.setInvaderImage(creeperImage);
              });

              newImage.addActionListener(click -> {
                game.setInvaderImage(ImageSelection.loadImage("invader","src/spaceinvaders/resources/newImage.png"));
            });
                
                invaderPanel.add(ubao);
                invaderPanel.add(cricket);
                invaderPanel.add(creeper);
                invaderPanel.add(newImage);

                invaderFrame.add(invaderPanel);
                invaderPanel.setVisible(true);


                
            }

}
