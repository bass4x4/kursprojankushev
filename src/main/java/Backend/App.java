package Backend;

import UI.MainMenuWindow;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame cipherWindow = new JFrame("Auth window");
        cipherWindow.setContentPane(new MainMenuWindow().getMainPanel());
        cipherWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cipherWindow.pack();
        cipherWindow.setSize(400, 300);
        cipherWindow.setResizable(false);
        cipherWindow.setVisible(true);
    }
}
