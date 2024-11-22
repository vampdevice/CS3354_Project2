package spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SpaceInvadersUI extends JPanel implements ActionListener, KeyListener {

    private final Timer timer;
    public ArrayList<InvaderBox> invaderboxes;
    public ArrayList<Bullet> bullets;
    public Random random;
    public boolean moveLeft, moveRight;
    private final ListenerActions listenerActions;
    public final ImageSelection imageSelection;
    private final PaintingActions paintingActions;
    private int shooter_width = 50;
    private int shooter_height = 60;
    private int shooter_X_Coordinate = 200;
    public boolean firing = false;
    private int bulletCooldown = 0;             // Current cooldown value
    private final int BULLET_COOLDOWN_LIMIT = 4; // Adjust this to control bullet spacing
    private Image shooterImage;
    private Image invaderImage;
    private Image bulletImage;
      
        
    
    
        // Constructor
        public SpaceInvadersUI() {
            //
            timer = new Timer(20, this); // 20ms delay for smoother animations
            invaderboxes = new ArrayList<>(); // Need to describe what ArrayList<> is.
            bullets = new ArrayList<>();
            random = new Random();
            moveLeft = false;
            moveRight = false;
            listenerActions = new ListenerActions();
            imageSelection = new ImageSelection();
            paintingActions = new PaintingActions();
            
    
            // Set images
            imageSelection.setGameImages();
            shooterImage = imageSelection.getShooterImage();
            invaderImage = imageSelection.getInvaderImage();
            bulletImage = imageSelection.getBulletImage();
            setFocusable(true);
            addKeyListener(this);
            timer.start();
        }
    
        @Override
        // Perhaps change this to specifically look for timer event or move all code to
        // ListenerActions and add overloading
        public void actionPerformed(ActionEvent e) {
            listenerActions.updatePositions(this);
            if (firing && bulletCooldown == 0) {
                bullets.add(new Bullet(shooter_X_Coordinate + shooter_width / 2, getHeight() - shooter_height));
                bulletCooldown = BULLET_COOLDOWN_LIMIT; // Reset cooldown after firing
            }
        
            // Decrement the cooldown timer if it's above zero
            if (bulletCooldown > 0) {
                bulletCooldown--;
            }
            repaint();
        }
    
        @Override
        public void keyPressed(KeyEvent e) {
            listenerActions.keyPressed(e, this);
        }
    
        @Override
        public void keyReleased(KeyEvent e) {
            listenerActions.keyReleased(e, this);
        }
    
        @Override
        public void keyTyped(KeyEvent e) {
            // Not used. Not providing an implementation Violates Integration Segregation
            // Principle
            // Could be used for character keys.
            //
        } 
    
        public void setShooterImage(Image newImage) {
            this.shooterImage = newImage;
            repaint();
        }
    
        public void setInvaderImage(Image newImage) {
            this.invaderImage = newImage;
            repaint();
        }
    
        public void setBulletImage(Image newImage) {
            this.bulletImage = newImage;
            repaint();
        }

    @Override
    // Let's move these methods into a separate PaintUI class
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // Draw shooter (rectangle)
        paintingActions.drawShooter(g, this, shooterImage);

        // Draw falling invaderboxes (as images)
        paintingActions.drawInvaders(g, invaderboxes, invaderImage, this);

        // Draw bullets (bullets)
        paintingActions.drawBullets(g, bullets, bulletImage, this );
    }

    public int getShooterWidth() {
        return (shooter_width);
    }

    public int getShooterHeight() {
        return (shooter_height);
    }

    public int getShooter_X_Coordinate() {
        return (shooter_X_Coordinate);
    }

    public void setShooter_X_Coordinate(int shooter_X) {
        shooter_X_Coordinate = shooter_X;
    }

    // These are the characters or objects used in the game. Create a shooter class
    // thing.

    // Inner class representing falling invaderboxes
    public class InvaderBox {
        int x, y, size;

        public InvaderBox(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    // Inner class representing bullets (bullets)
    // Look for Java bullet class
    public class Bullet {
        int x, y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
