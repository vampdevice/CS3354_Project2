package spaceinvaders.selections;

import javax.swing.*;

import spaceinvaders.MenuBarUI;
import spaceinvaders.ParentButton;

import java.awt.event.*;

public class MusicMenu extends MenuBarUI implements ActionListener {


    public MusicMenu() {
        JMenuItem musicMenu = new JMenuItem("Music");
        MenuBarUI.menu.add(musicMenu);
        musicMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 350;
        JFrame musicFrame = new JFrame("Music Menu");
        musicFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        musicFrame.setLocationRelativeTo(null);
        musicFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel musicPanel = new JPanel();
        
        JButton option1 = ParentButton.createMusicButton("Silly Option");
        JButton option2 = ParentButton.createMusicButton("Dreamy Option");
        JButton option3 = ParentButton.createMusicButton("Minecraft Option");
        JButton option4 = ParentButton.createMusicButton("Choose your Own!");

        option1.addActionListener(newEvent -> {
            MusicSelection.loadMusicUrl("https://www.youtube.com/watch?v=Twi92KYddW4");
        });

        option2.addActionListener(newEvent -> {
            MusicSelection.loadMusicUrl("https://www.youtube.com/watch?v=YjGN80doH9g&ab_channel=FrogRadio");
        });

        option3.addActionListener(newEvent -> {
            MusicSelection.loadMusicUrl("https://www.youtube.com/watch?v=jYq_dNVlJVc&ab_channel=AlvinPlayzMC");
        });

        option4.addActionListener(newEvent -> {
            MusicSelection.loadMusicUrl(JOptionPane.showInputDialog(null,"Enter URL for music "));
        });

        musicPanel.add(option1);
        musicPanel.add(option2);
        musicPanel.add(option3);
        musicPanel.add(option4);
        musicFrame.add(musicPanel);

        musicFrame.setVisible(true);

    } 
}
