package spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class ListenerActions {

    public void updatePositions(SpaceInvadersUI game) {
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Width = game.getShooterWidth();
        // Move shooter left or right
        if (game.moveLeft && shooter_X_Coordinate > 0) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate - 5);
        }
        if (game.moveRight && shooter_X_Coordinate < game.getWidth() - shooter_Width) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate + 5);
        }

        // Add new falling invaderboxs randomly
        if (game.random.nextInt(100) < 2) {
            int x = game.random.nextInt(game.getWidth());
            game.invaderboxes.add(game.new InvaderBox(x, 0, 40)); // Example size 40
        }

        // Move invaderboxes down
        Iterator<SpaceInvadersUI.InvaderBox> invaderboxIterator = game.invaderboxes.iterator();
        while (invaderboxIterator.hasNext()) {
            SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
            invaderbox.y += 2;
            if (invaderbox.y > game.getHeight()) {
                invaderboxIterator.remove(); // Remove invaderboxes that go off the screen
            }
        }

        // Move bullets up
        Iterator<SpaceInvadersUI.Bullet> bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            bullet.y -= 5;
            if (bullet.y < 0) {
                bulletIterator.remove(); // Remove bullets that go off the screen
            }
        }

        // Check for bullet-invaderbox collisions
        bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            invaderboxIterator = game.invaderboxes.iterator();
            while (invaderboxIterator.hasNext()) {
                SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
                if (new Rectangle(bullet.x - 5, bullet.y, 10, 10).intersects(
                        new Rectangle(invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size))) {
                    bulletIterator.remove();
                    invaderboxIterator.remove();
                    break;
                }
            }
        }
    }

    public void keyPressed(KeyEvent e, SpaceInvadersUI game) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            game.firing = true;
            int shooter_X_Coordinate = game.getShooter_X_Coordinate();
            int shooter_width = game.getShooterWidth();
            int shooter_height = game.getShooterHeight();
            game.bullets.add(
                    game.new Bullet(shooter_X_Coordinate + shooter_width / 2, game.getHeight() - shooter_height));
        }
    }

    public void keyReleased(KeyEvent e, SpaceInvadersUI game) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            // Set firing to false to stop continuous shooting
            game.firing = false;
        }
    }
}
