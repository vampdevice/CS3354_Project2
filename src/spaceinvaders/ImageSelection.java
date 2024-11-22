package spaceinvaders;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageSelection {
    private Image shooterImage;
    private Image invaderImage;
    private Image bulletImage;

    public Image getShooterImage() {
        return shooterImage;
    }
    public Image getBulletImage() {
        return bulletImage;
    }

    public Image getInvaderImage() {
        return invaderImage;
    }

    public void setGameImages() {
        shooterImage = loadImage("shooter", "./resources/ShooterImage.png");
        invaderImage = loadImage("invader", "./resources/InvaderImage.png");
    }

    @SuppressWarnings("deprecation")
    public
    static Image loadImage(String imageType, String defaultResourcePath) {
        String imageUrl = JOptionPane.showInputDialog(null,
                "Enter URL for " + imageType + " image (or leave blank for default):");

        // Need to handle case where url is not an image, ie a png or jpeg.
        if (imageUrl != null && !imageUrl.isEmpty() && (imageUrl.contains(".png") || imageUrl.contains(".jpeg"))) {
            try {
                return ImageIO.read(new URL(imageUrl));
            } catch (MalformedURLException e) {
                GameExceptions.showErrorDialog(
                        "Invalid URL for " + imageType + " image: " + e.getMessage() + "\nLoading default image");
            } catch (IOException e) {
                GameExceptions.showErrorDialog(
                        "Failed to load " + imageType + " image: " + e.getMessage() + "\nLoading default image");
            }
        }
        else {
            GameExceptions.showErrorDialog(
                    "This is not a image URL or is empty.");
        }
        // If no URL is provided or URL fails, load the default resource
        try {
            return ImageIO.read(ImageSelection.class.getResource(defaultResourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load default " + imageType + " image: " + e.getMessage());
        }

        return null;
    }
    }
