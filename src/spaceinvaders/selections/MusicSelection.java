package spaceinvaders.selections;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import spaceinvaders.GameExceptions;

import java.awt.Desktop;

public class MusicSelection {

    public static String loadMusicUrl(String musicUrl) {
        if (musicUrl != null && !musicUrl.isEmpty() && musicUrl.contains("=")) {
            try {
                URI uri = new URI(musicUrl);

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(uri);
                } else {
                    System.out.println("Desktop is not supported on this system.");
                }
            }
            catch (URISyntaxException | IOException e) {
                GameExceptions.showErrorDialog(
                    "Failed to load music: " + e.getMessage() + " Please try another URL.");
            }
        }
        else {
            GameExceptions.showErrorDialog(
                    "This is not a streaming URL...Please try another URL.");
        }
        return null;
    }
}
