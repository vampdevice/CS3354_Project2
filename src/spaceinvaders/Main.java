package spaceinvaders;

import javax.swing.JFrame;

import spaceinvaders.selections.BulletMenu;
import spaceinvaders.selections.InvaderSelection;
import spaceinvaders.selections.MusicMenu;
import spaceinvaders.selections.ShooterMenu;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders with Images");
        SpaceInvadersUI game = new SpaceInvadersUI();
        frame.add(game);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MenuBarUI(frame));
        frame.add(new MusicMenu());
        frame.add(new ShooterMenu(game));
        frame.add(new InvaderSelection(game));
        frame.add(new BulletMenu(game));
        frame.setVisible(true);
    }
}
