package spaceinvaders;

import java.awt.*;

public class PaintingActions {

    public PaintingActions() {

    }

    public void drawShooter(Graphics g, SpaceInvadersUI game, Image shooterImage) {
        //Image shooter_image = game.imageSelection.getShooterImage();
        int shooter_height = game.getShooterHeight();
        int shooter_width = game.getShooterWidth();
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Y_Coordinate = game.getHeight() - shooter_height;

        g.drawImage(shooterImage, shooter_X_Coordinate, shooter_Y_Coordinate, shooter_width, shooter_height, game);

    }

    public void drawInvaders(Graphics g, java.util.List<SpaceInvadersUI.InvaderBox> invaderboxes, Image invaderboxImage,
            SpaceInvadersUI game) {
        for (SpaceInvadersUI.InvaderBox invaderbox : invaderboxes) {
            g.drawImage(invaderboxImage, invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size, game);
        }
    }

    public void drawBullets(Graphics g, java.util.List<SpaceInvadersUI.Bullet> bullets, Image bulletImage, SpaceInvadersUI game) {
        for (SpaceInvadersUI.Bullet bullet : bullets) {
            if (bulletImage != null) {
                int bulletWidth = 10;
                int bulletHeight = 20;
                g.drawImage(bulletImage, bullet.x - bulletWidth / 2, bullet.y, bulletWidth, bulletHeight, game);
            } else {
                // Default to a yellow triangle bullet if no image is provided
                g.setColor(Color.YELLOW);
                int[] xPoints = { bullet.x, bullet.x - 5, bullet.x + 5 };
                int[] yPoints = { bullet.y, bullet.y + 10, bullet.y + 10 };
                g.fillPolygon(xPoints, yPoints, 3);
            }
        }
    }
}
