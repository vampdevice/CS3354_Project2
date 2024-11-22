package spaceinvaders;

import javax.swing.*;

public class MenuBarUI extends JMenuBar {
    static JMenuBar menuBar = new JMenuBar();
    protected static JMenu menu = new JMenu("Menu");

    public MenuBarUI() {
    }

    public MenuBarUI(JFrame frame) {
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}